use std::{alloc::{alloc, Layout}, collections::HashMap, ffi::c_void, fs::File, io::{Read, Seek, SeekFrom}, path::Path, ptr::null, sync::{LazyLock, Mutex}};

use anyhow::Context;
use jni::{objects::{JObject, JObjectArray, JValue}, JNIEnv};
use jvmti::environment::jvmti::JVMTI;
use winapi::um::wincon::LEFT_CTRL_PRESSED;
use zip::ZipArchive;

use crate::{tiny::TinyFile, WINDOW_TEXT};

static CLASS_CACHE: LazyLock<Mutex<HashMap<String, jni::objects::JClass>>> = LazyLock::new(|| Mutex::new(HashMap::new()));

// static MC_CLASSES: LazyLock<Mutex<HashMap<String, jni::objects::JClass>>> = LazyLock::new(|| Mutex::new(HashMap::new()));

static mut YUSUKE: Option<Yusuke> = None;

static INITIALIZED: Mutex<bool> = Mutex::new(false);

static mut MC_VER: MCVer = MCVer::V189;
static mut MC_BRAND: MCBrand = MCBrand::Vanilla;

enum MCVer {
    V189,
}

enum MCBrand {
    Vanilla,
    Lunar,
}

fn get_mapping_data() -> &'static str {
    let binding = WINDOW_TEXT.lock().unwrap();
    let text = binding.as_ref().unwrap().as_str();

    unsafe {
        // determine version
        if text.contains("1.8.9") {
            MC_VER = MCVer::V189;
        }

        // determine brand
        if text.contains("Lunar") {
            MC_BRAND = MCBrand::Lunar;
        } else {
            MC_BRAND = MCBrand::Vanilla;
        }
    }

    if text.contains("Lunar") {
        ""
    } else {
        include_str!("mappings/vanillav189")
    }
}

static mut HOOKS: Vec<String> = Vec::new();

fn class_file_load_hook(event: jvmti::runtime::ClassFileLoadEvent) -> Option<Vec<u8>> {
    unsafe {
        if !HOOKS.contains(&event.class_name) {
            return None;
        }
    }
    println!("class_file_load_hook: {}", event.class_name);
    let class_cache = CLASS_CACHE.lock().unwrap();
    let main_class = class_cache.get("yusuke.retransform.Retransformer").unwrap();

    let mut class_data = Vec::<u8>::new();
    let mut writer = jvmti::bytecode::writer::ClassWriter::new(&mut class_data);
    writer.write_class(&event.class).unwrap();

    unsafe {
        let mut env = YUSUKE.as_ref().unwrap().jvm.get_env().unwrap();

        if !*INITIALIZED.lock().unwrap() {
            let mapping_field = env.get_static_field_id(main_class, "mappingRaw", "Ljava/lang/String;").unwrap();
            env.set_static_field(
                main_class,
                mapping_field,
                jni::objects::JValueGen::Object(&env.new_string(get_mapping_data()).unwrap()),
            ).unwrap();
            
            let method_id = env.get_static_method_id(main_class, "init", "(Ljava/lang/String;)V").unwrap();
            
            let _ = env.call_static_method_unchecked(
                main_class,
                method_id,
                jni::signature::ReturnType::Primitive(jni::signature::Primitive::Void),
                &[
                    jni::sys::jvalue { l: env.new_string(WINDOW_TEXT.lock().unwrap().as_ref().unwrap()).unwrap().as_raw() }.into(),
                ]
            );
            *INITIALIZED.lock().unwrap() = true;
        }
        
        let method_id = env.get_static_method_id(main_class, "retransform", "([BLjava/lang/String;)[B").unwrap();
        
        let res = env.call_static_method_unchecked(
            main_class,
            method_id,
            jni::signature::ReturnType::Array,
            &[
                jni::sys::jvalue { l: env.byte_array_from_slice(&class_data).unwrap().as_raw() }.into(),
                jni::sys::jvalue { l: env.new_string(event.class_name).unwrap().as_raw() }.into(),
            ]
        ).unwrap().l().unwrap();

        let byte_array = jni::objects::JByteArray::from_raw(res.as_raw());
        let mut buf = vec![0; env.get_array_length(&byte_array).unwrap() as usize];
        env.get_byte_array_region(&byte_array, 0, &mut buf).unwrap();

        return Some(buf.iter().map(|&x| x as u8).collect());
    }
}

pub(crate) struct Yusuke {
    jvm: jni::JavaVM,
    jvmti: jvmti::environment::jvmti::JVMTIEnvironment,
    jvmti_raw: jvmti::native::JVMTIEnvPtr,
}
unsafe impl Send for Yusuke {}
unsafe impl Sync for Yusuke {}

impl Yusuke {
    pub unsafe fn new(jvm: *mut jni::sys::JavaVM) -> anyhow::Result<Self> {
        get_mapping_data();
        let jvmti_raw = alloc(Layout::new::<jvmti::native::jvmti_native::jvmtiEnv>()) as *mut *mut c_void;
        if (**jvm).GetEnv.context("Failed to get GetEnv")?(jvm, jvmti_raw, jvmti::native::jvmti_native::JVMTI_VERSION_1_2 as i32)
            != jvmti::native::jvmti_native::JVMTI_ERROR_NONE as i32 {
            return Err(anyhow::anyhow!("Failed to get JVMTI environment"));
        }
    
        let mut jvmti = jvmti::environment::jvmti::JVMTIEnvironment::new(*jvmti_raw as jvmti::native::JVMTIEnvPtr);
    
        let mut capabilities = jvmti.get_capabilities();
        capabilities.can_redefine_classes = true;
        capabilities.can_redefine_any_class = true;
        capabilities.can_retransform_classes = true;
        capabilities.can_retransform_any_class = true;
    
        let Result::Ok(_) = jvmti.add_capabilities(&capabilities) else {
            return Err(anyhow::anyhow!("Failed to add capabilities"));
        };
    
        let callbacks = jvmti::event::EventCallbacks {
            class_file_load_hook: Some(class_file_load_hook),
            ..Default::default()
        };
        jvmti.set_event_callbacks(callbacks);

        YUSUKE.replace(Self {
            jvm: jni::JavaVM::from_raw(jvm).context("Failed to get JavaVM")?,
            jvmti: jvmti::environment::jvmti::JVMTIEnvironment::new(*jvmti_raw as jvmti::native::JVMTIEnvPtr),
            jvmti_raw: *jvmti_raw as jvmti::native::JVMTIEnvPtr
        });

        let mut me = Self {
            jvm: jni::JavaVM::from_raw(jvm).context("Failed to get JavaVM")?,
            jvmti,
            jvmti_raw: *jvmti_raw as jvmti::native::JVMTIEnvPtr
        };

        me.init()?;

        YUSUKE.as_mut().unwrap().jvmti.set_event_callbacks(jvmti::event::EventCallbacks::default());

        Ok(me)
    }

    unsafe fn init(&mut self) -> anyhow::Result<()> {
        let classes = self.class_names_to_retransform().iter().map(|class_name| {
            println!("class_name: {}", class_name);
            HOOKS.push(class_name.clone());
            Self::find_class(&mut self.jvm.get_env().unwrap(), class_name).unwrap()
            // jni::objects::JClass::from_raw(self.jvm.get_env().unwrap().find_class(class_name).unwrap().as_raw())
        }).collect::<Vec<_>>();
        
        if !self.load_client_classes(jni::objects::JClass::from_raw(classes[0].as_raw()))? {
            println!("Already defined");
            return Ok(());
        }

        for class in &classes {
            println!("retransform: {:?}", class);
            self.jvmti.set_event_notification_mode(jvmti::event::VMEvent::ClassFileLoadHook, true);
            (**self.jvmti_raw).RetransformClasses.context("Failed to get RetransformClasses")?(self.jvmti_raw, 1, &(class.as_raw() as jvmti::native::JavaClass));
            self.jvmti.set_event_notification_mode(jvmti::event::VMEvent::ClassFileLoadHook, false);
        }

        Ok(())
    }

    // 祐介クライアントのJarファイルを読み込んで、クラスをロードする
    pub unsafe fn load_client_classes(&self, temp_class: jni::objects::JClass<'_>) -> anyhow::Result<bool> {
        // let temp_class = self.jvm.get_env()?.find_class("bew")?;
        // let temp_class = Self::find_class(&mut self.jvm.get_env().unwrap(), "net/minecraft/client/entity/EntityPlayerSP").unwrap();

        let mut env = self.jvm.get_env()?;
        let url_class = env.find_class("java/net/URL")?;

        let mut class_loader = alloc(Layout::new::<jni::sys::jobject>()) as *mut jvmti::native::jvmti_native::Struct__jobject;
        (**self.jvmti_raw).GetClassLoader.context("Failed to get GetClassLoader")?(self.jvmti_raw, url_class.as_raw() as *mut jvmti::native::jvmti_native::Struct__jobject, &mut class_loader);
        
        let mut class_loader2 = alloc(Layout::new::<jni::sys::jobject>()) as *mut jvmti::native::jvmti_native::Struct__jobject;
        (**self.jvmti_raw).GetClassLoader.context("Failed to get GetClassLoader")?(self.jvmti_raw, temp_class.as_raw() as *mut jvmti::native::jvmti_native::Struct__jobject, &mut class_loader2);

        let mut already_defined = false;

        {
            // let file = File::open(Self::get_adapter_path())?;
            // let mut archive = ZipArchive::new(file)?;
            let mut archive = if cfg!(debug_assertions) {
                let mut f = File::open(Self::get_adapter_path())?;
                let mut buf = vec![];
                f.read_to_end(&mut buf)?;
                let cursor = std::io::Cursor::new(buf);
                ZipArchive::new(cursor)?
            } else {
                let file = include_bytes!("../../lbb/app/build/libs/app-remapped.jar");
                let buf = file.to_vec();
                let cursor = std::io::Cursor::new(buf);
                // let file = File::open(Self::get_adapter_path())?;
                ZipArchive::new(cursor)?
            };

            let mut map = HashMap::new();
            
            for i in 0..archive.len() {
                let mut file = archive.by_index(i)?;
                let file_name = file.name().to_string();

                if !file_name.ends_with(".class") || !file_name.starts_with("yusuke") {
                    continue;
                }

                let mut class_data = Vec::new();
                file.read_to_end(&mut class_data)?;

                map.insert(file_name, class_data);
            }

            loop {
                if map.is_empty() {
                    break;
                }
                let mut ok = false;

                for (file_name, class_data) in map.clone() {
                    let class_copy = if matches!(MC_BRAND, MCBrand::Lunar) || (!file_name.contains("retransform") && !file_name.contains("asm")) {
                        (**env.get_raw()).DefineClass.context("Failed to get DefineClass")?
                            (env.get_raw(), null(), class_loader2 as *mut jni::sys::_jobject, class_data.as_ptr() as *const jni::sys::jbyte, class_data.len() as i32)
                    } else {
                        (**env.get_raw()).DefineClass.context("Failed to get DefineClass")?
                            (env.get_raw(), null(), class_loader as *mut jni::sys::_jobject, class_data.as_ptr() as *const jni::sys::jbyte, class_data.len() as i32)
                    };

                    if !class_copy.is_null() {
                        let class_name = file_name.replace("/", ".").replace(".class", "");
                        CLASS_CACHE.lock().unwrap().insert(class_name.clone(), jni::objects::JClass::from_raw(class_copy));
                        map.remove(&file_name);
                        ok = true;
                        println!("loaded: {}", file_name);
                    } else {
                        println!("failed lo load: {}", file_name);
                    }
                }
                // if !ok {
                //     already_defined = true;
                //     break;
                // }
            }
        }

        println!("loaded classes 2");

        Ok(!already_defined)
    }

    fn get_adapter_path() -> String {
        unsafe {
            if let MCBrand::Lunar = MC_BRAND {
                format!("{}\\lbb\\app\\build\\libs\\app.jar", Path::new(env!("CARGO_MANIFEST_DIR")).parent().unwrap().display())
            } else {
                format!("{}\\lbb\\app\\build\\libs\\app-remapped.jar", Path::new(env!("CARGO_MANIFEST_DIR")).parent().unwrap().display())
            }
        }
    }

    // 改変したクラスの名前一覧を返す
    unsafe fn class_names_to_retransform(&self) -> Vec<String> {
        let mut orig = match MC_VER {
            MCVer::V189 => include_str!("classes/v189").lines().map(|x| x.to_string()).collect::<Vec<_>>(),
        };

        if let MCBrand::Lunar = MC_BRAND {
            println!("Lunar detected, skipping class name mapping");
            return orig;
        } else {
            println!("Vanilla detected, mapping class names");
        }

        let mapping = match MC_BRAND {
            MCBrand::Vanilla => include_str!("mappings/vanillav189"),
            _ => ""
        };

        let tiny = TinyFile::parse_file(&mapping).unwrap();
        for i in 0..orig.len() {
            if let Some(class) = tiny.classes.get(&orig[i]) {
                orig[i] = class.obf.clone();
            }
        }

        orig
    }

    pub unsafe fn find_class<'a>(ENV: &mut JNIEnv<'a>, class_name_: &str) -> Option<JObject<'a>> {
        if let MCBrand::Vanilla = MC_BRAND {
            let attempt = ENV.find_class(class_name_);
            if let Ok(class) = attempt {
                if !class.is_null() {
                    return Some(jni::objects::JObject::from_raw(class.as_raw()));
                }
            }
        }
        // Self::get_class_loader(ENV).unwrap();
        println!("class_name: {}", class_name_);
        let stack_traces_map: JObject = ENV.call_static_method("java/lang/Thread", "getAllStackTraces", "()Ljava/util/Map;", &[]).unwrap().l().unwrap();
        let threads_set: JObject = ENV.call_method(&stack_traces_map, "keySet", "()Ljava/util/Set;", &[]).unwrap().l().unwrap();
        let threads: JObject = ENV.call_method(&threads_set, "toArray", "()[Ljava/lang/Object;", &[]).unwrap().l().unwrap();
        let threads_array: JObjectArray = JObjectArray::from(threads);
        let threads_amount: i32 = ENV.get_array_length(&threads_array).unwrap();
        let klass = ENV.find_class("java/lang/ClassLoader").unwrap();
        let mut class_loader: JObject = JObject::null();
        println!("threads: {}", threads_amount);
        let get_class = ENV.get_method_id(&klass, "findClass", "(Ljava/lang/String;)Ljava/lang/Class;").unwrap();
        println!("get_class: {:?}", get_class);

        for i in 0..threads_amount {
            println!("thread: {}", i);
            let thread = ENV.get_object_array_element(&threads_array, i);
            if let Err(e) = thread {
                println!("error on 3: {:?}", e);
                continue;
            }
            let thread = thread.unwrap();
            println!("thread: {:?}", thread);
            class_loader = ENV.call_method(&thread, "getContextClassLoader", "()Ljava/lang/ClassLoader;", &[]).unwrap().l().unwrap();
            println!("class_loader: {:?}", class_loader);
            if !class_loader.is_null() {
                // let minecraft_class = ENV.call_method(
                //     &class_loader,
                //     "findClass",
                //     "(Ljava/lang/String;)Ljava/lang/Class;",
                //     &[JValue::Object(&*class_name)]
                // );//.unwrap().l().unwrap();
                let minecraft_class = ENV.call_method_unchecked(
                    &class_loader,
                    get_class, jni::signature::ReturnType::Object,
                &[
                        jni::sys::jvalue { l: ENV.new_string(class_name_).unwrap().as_raw() }.into(),
                    ]
                );
                if let Err(e) = minecraft_class {
                    println!("error on 2: {:?}", e);
                    continue;
                }
                let minecraft_class = minecraft_class.unwrap().l();
                if let Err(e) = minecraft_class {
                    println!("error on 1: {:?}", e);
                    continue;
                }
                let minecraft_class = minecraft_class.unwrap();
                println!("minecraft_class: {:?}", minecraft_class);
                if !minecraft_class.is_null() {
                    println!("found class: {}", class_name_);
                    return Some(minecraft_class);
                }
            }
            // ENV.delete_local_ref(thread).unwrap();
        }

        None
    }

    pub unsafe fn get_class_loader<'a>(ENV: &mut JNIEnv<'a>) -> anyhow::Result<Option<JObject<'a>>> {
        let stack_traces_map: JObject = ENV.call_static_method("java/lang/Thread", "getAllStackTraces", "()Ljava/util/Map;", &[]).unwrap().l().unwrap();
        let threads_set: JObject = ENV.call_method(&stack_traces_map, "keySet", "()Ljava/util/Set;", &[]).unwrap().l().unwrap();
        let threads: JObject = ENV.call_method(&threads_set, "toArray", "()[Ljava/lang/Object;", &[]).unwrap().l().unwrap();
        let threads_array: JObjectArray = JObjectArray::from(threads);
        let threads_amount: i32 = ENV.get_array_length(&threads_array).unwrap();
        let mut class_loader: JObject = JObject::null();

        println!("Threads: {}", threads_amount);

        for i in 0..threads_amount {
            let thread = ENV.get_object_array_element(&threads_array, i);
            let Result::Ok(thread) = thread else {
                println!("Failed to get thread");
                continue;
            };

            let class_loader_class = ENV.call_method(&thread, "getContextClassLoader", "()Ljava/lang/ClassLoader;", &[]);
            let Result::Ok(class_loader_class) = class_loader_class else {
                println!("Failed to get class loader class");
                continue;
            };

            let class_loader_class = class_loader_class.l();
            let Result::Ok(class_loader_class) = class_loader_class else {
                println!("Failed to get class loader class");
                continue;
            };

            class_loader = class_loader_class;
            
            if !class_loader.is_null() {
                let class_name = ENV.new_string("net/minecraft/client/Minecraft");
                let Result::Ok(class_name) = class_name else {
                    println!("Failed to create class name");
                    continue;
                };

                let minecraft_class = ENV.call_method(&class_loader, "findClass", "(Ljava/lang/String;)Ljava/lang/Class;", &[JValue::Object(&class_name)]);
                let Result::Ok(minecraft_class) = minecraft_class else {
                    println!("Failed to find class");
                    continue;
                };

                let minecraft_class = minecraft_class.l();
                let Result::Ok(minecraft_class) = minecraft_class else {
                    continue;
                };
                
                if !minecraft_class.is_null() {
                    println!("Found Minecraft class");
                    ENV.delete_local_ref(minecraft_class).unwrap();
                    break;
                }
            }
            ENV.delete_local_ref(thread).unwrap();
        }

        Ok(Some(class_loader))
    }
}

unsafe fn get_class_name(env: &mut jni::JNIEnv<'_>, class: &jvmti::class::ClassId) -> anyhow::Result<String> {
    let klass = env.find_class("java/lang/Class")?;
    let get_name = env.get_method_id(klass, "getName", "()Ljava/lang/String;")?;
    let name = env.call_method_unchecked(
        jni::objects::JObject::from_raw(class.native_id as *mut jni::sys::_jobject),
        get_name,
        jni::signature::ReturnType::Object, &[]
    )?.l()?;

    Ok(env.get_string(&jni::objects::JString::from_raw(name.into_raw()))?.to_str()?.replace(".", "/"))
}

#[cfg(test)]
mod tests {
    use std::path::Path;

    #[test]
    fn main() {
        println!("{}", format!("{}\\yusuke-core\\out\\artifacts\\yusuke_core_jar\\yusuke-core.jar", Path::new(env!("CARGO_MANIFEST_DIR")).parent().unwrap().display()));
    }
}

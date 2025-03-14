use std::{ffi::{c_int, c_void}, fs::OpenOptions, os::windows::io::AsRawHandle, sync::Mutex, thread::sleep, time::Duration};

use anyhow::Context;

use windows::{core::s, Win32::Foundation::HINSTANCE};
use winapi::{shared::windef::HWND, um::{consoleapi::AllocConsole, libloaderapi::{FreeLibraryAndExitThread, GetModuleHandleA, GetProcAddress}, processenv::SetStdHandle, processthreadsapi::GetCurrentProcessId, winbase::STD_OUTPUT_HANDLE, wincon::GetConsoleWindow, winuser::{EnumWindows, GetWindow, GetWindowTextA, GetWindowThreadProcessId, IsWindowVisible, GW_OWNER}}};
use windows::Win32::System::SystemServices::DLL_PROCESS_ATTACH;
use winapi::um::wincon::FreeConsole;

pub static WINDOW_TEXT: Mutex<Option<String>> = Mutex::new(None);

type GetCreatedJavaVMs = extern "system" fn(*mut *mut c_void, c_int, *mut c_int) -> c_int;

mod yusuke;
pub mod tiny;

fn get_jni_get_created_jvms() -> Option<GetCreatedJavaVMs> {
    let jvm_module = unsafe { GetModuleHandleA(s!("jvm.dll").as_ptr() as *const i8) };
    if jvm_module.is_null() {
        return None;
    }

    let jvm_proc_address = unsafe { GetProcAddress(jvm_module, s!("JNI_GetCreatedJavaVMs").as_ptr() as *const i8) };
    if jvm_proc_address.is_null() {
        return None;
    }
    
    let get_created_jvm = unsafe { std::mem::transmute(jvm_proc_address) };
    
    Some(get_created_jvm)
}

struct HWNDWrapper(HWND);
unsafe impl Send for HWNDWrapper {}

static FOUND_WINDOW: Mutex<Option<HWNDWrapper>> = Mutex::new(None);

unsafe extern "system" fn enum_windows_callback(hwnd: HWND, lparam: isize) -> i32 {
    let mut window_pid = 0;
    GetWindowThreadProcessId(hwnd, &mut window_pid);
    if window_pid == lparam as u32
    && IsWindowVisible(hwnd) != 0
    && GetConsoleWindow() != hwnd {
        *FOUND_WINDOW.lock().unwrap() = Some(HWNDWrapper(hwnd));
        return 0; // Stop enumeration.
    }
    1 // Continue enumeration.
}

fn get_window_name() -> String {
    unsafe {
        let current = GetCurrentProcessId();
        EnumWindows(Some(enum_windows_callback), current as _);

        let mut lpString = [0u8; 128];
        GetWindowTextA(FOUND_WINDOW.lock().unwrap().as_ref().unwrap().0, lpString.as_mut_ptr() as *mut i8, 128);
        let c_str = std::ffi::CStr::from_ptr(lpString.as_ptr() as *const i8);
        c_str.to_string_lossy().into_owned()
    }
}

unsafe fn start() -> anyhow::Result<()> {
    AllocConsole();
    
    let file = OpenOptions::new()
        .write(true)
        .read(true)
        .open("CONOUT$")?;
    SetStdHandle(
        STD_OUTPUT_HANDLE,
        file.as_raw_handle() as *mut winapi::ctypes::c_void
    );

    WINDOW_TEXT.lock().unwrap().replace(get_window_name());
    println!("injecting into: {:?}", WINDOW_TEXT.lock().unwrap().as_ref().unwrap());
    
    let mut jvm_ciunt = 0;

    let mut jvm_raw = Vec::<*mut c_void>::with_capacity(1);

    if get_jni_get_created_jvms().context("get_jni_get_created_jvms")?(
        jvm_raw.as_mut_ptr(),
        1,
        &mut jvm_ciunt
    ) != jvmti::native::jvmti_native::JVMTI_ERROR_NONE as i32 {
        return Err(anyhow::anyhow!("failed to get jvm"));
    }

    jvm_raw.set_len(jvm_ciunt as usize);

    // println!("jvm: {:?}", jvm_raw.len());

    let jvm = jni::JavaVM::from_raw(*jvm_raw.first().context("jvm is empty")? as *mut jni::sys::JavaVM)?;
    let env = jvm.attach_current_thread()?;
    let _ = yusuke::Yusuke::new(jvm.get_java_vm_pointer())?;

    jvm.detach_current_thread();
    
    println!("You may close this window now.");
    FreeConsole();

    let module = GetModuleHandleA(s!("yusuke_bridge.dll").as_ptr() as *const i8);
    FreeLibraryAndExitThread(module, 0);

    Ok(())
}

#[no_mangle]
extern "system" fn DllMain(_: HINSTANCE, call_reason: u32, _: *mut ()) -> bool {
    if call_reason == DLL_PROCESS_ATTACH {
        std::thread::spawn(|| unsafe {
            if let anyhow::Result::Err(err) = start() {
                println!("error: {:?}", err);
            }
        });
    }
    true
}

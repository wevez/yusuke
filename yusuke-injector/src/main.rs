use std::{path::PathBuf, ptr::null_mut, sync::{Arc, LazyLock, Mutex}};

use regex::Regex;
use structs::AbstractHWND;

mod structs;

macro_rules! lock {
    ($mutex:expr) => {
        $mutex.lock().unwrap()
    };
}

static HWNDS: LazyLock<Arc<Mutex<Vec<structs::AbstractHWND>>>> = LazyLock::new(Arc::default);

#[cfg(windows)]
fn enumurate_hwnd() -> anyhow::Result<()> {

    use std::char::{decode_utf16, REPLACEMENT_CHARACTER};
    use structs::WindowsHWND;
    use winapi::{
        um::winuser::{EnumWindows, GetWindowTextW},
        shared::{
            windef::HWND,
            minwindef::{LPARAM, BOOL, TRUE}
        },
    };

    // EnumWindows関数のコールバック関数
    unsafe extern "system" fn enum_proc(hwnd: HWND, _l_param: LPARAM) -> BOOL {

        let mut buf = [0u16; 1024];
        
        if GetWindowTextW(hwnd, &mut buf[0], 1024) > 0 {

            let title = decode_utf16(buf.iter().take_while(|&i| *i != 0).cloned())
                .map(|r| r.unwrap_or(REPLACEMENT_CHARACTER))
                .collect::<String>();

            lock!(HWNDS).push(structs::AbstractHWND::Windows(WindowsHWND {
                hwnd,
                title,
            }));
        }
        
        TRUE
    }

    unsafe {
        EnumWindows(Some(enum_proc), 0);
    }

    Ok(())
}


fn inject(hwnd: &AbstractHWND, dll_path: PathBuf) -> anyhow::Result<()> {

    use winapi::um::winuser::GetWindowThreadProcessId;
    use winapi::um::{processthreadsapi::*, winnt::*};
    use winapi::um::memoryapi::*;
    use winapi::um::{handleapi::CloseHandle, libloaderapi::*};

    match hwnd {
        AbstractHWND::Windows(hwnd) => {

            let mut pid = 0;
            unsafe { GetWindowThreadProcessId(hwnd.hwnd, &mut pid) };
            if pid == 0 {
                return Err(anyhow::anyhow!("Failed to get process ID"));
            }

            let process_handle = unsafe {
                OpenProcess(
                    PROCESS_CREATE_THREAD | PROCESS_QUERY_INFORMATION | PROCESS_VM_OPERATION | PROCESS_VM_WRITE | PROCESS_VM_READ,
                    0,
                    pid
                )
            };

            let dll_path_cstring = std::ffi::CString::new(dll_path.to_str().unwrap()).unwrap();
            let dll_path_address = unsafe {
                VirtualAllocEx(
                    process_handle,
                    null_mut(),
                    dll_path_cstring.to_bytes().len(),
                    MEM_COMMIT,
                    PAGE_READWRITE
                )
            };

            unsafe {
                WriteProcessMemory(
                    process_handle,
                    dll_path_address,
                    dll_path_cstring.as_ptr() as *mut _,
                    dll_path_cstring.to_bytes().len(),
                    null_mut()
                )
            };
    
            let load_library_address = unsafe {
                GetProcAddress(
                    GetModuleHandleA(
                        b"kernel32\0".as_ptr() as *const _
                    ),
                    b"LoadLibraryA\0".as_ptr() as *const _
                )
            };

            let thread_id = unsafe {
                CreateRemoteThread(
                    process_handle,
                    null_mut(),
                    0,
                    Some(std::mem::transmute(load_library_address)),
                    dll_path_address,
                    0,
                    null_mut()
                )
            };
            if thread_id.is_null() {
                unsafe {
                    VirtualFreeEx(
                        process_handle,
                        dll_path_address,
                        0,
                        MEM_RELEASE
                    )
                };

                return Err(anyhow::anyhow!("Failed to create remote thread"));
            }
            
            unsafe { CloseHandle(process_handle) };
        }
    }

    Ok(())
}


fn main() -> Result<(), Box<dyn std::error::Error>> {
    let minecraft_candidates = [
        Regex::new(r"Minecraft 1\.8\.9").unwrap(),
        Regex::new(r"Badlion Minecraft Client v.* \(1\.8\.9\)").unwrap(),
        Regex::new(r"Lunar Client 1.8.9 .*").unwrap(),
    ];
    
    // ファイルダイアログを開いて、DLLファイルのパスを取得する
    let dll_file_path = rfd::FileDialog::new()
        .pick_file();

    // ファイルが選択されない場合は終了
    let Some(dll_file_path) = dll_file_path else {
        println!("ファイルが選択されませんでした。");   
        return Ok(());
    };

    enumurate_hwnd()?;

    let binding = lock!(HWNDS);
    let hwnd_candiates = binding.iter()
        .filter(|hwnd| minecraft_candidates.iter().any(|candidate| candidate.is_match(hwnd.title())))
        .collect::<Vec<_>>();

    if hwnd_candiates.is_empty() {
        println!("Minecraftが見つかりませんでした。");
        return Ok(());
    }

    let selected_hwnd = if hwnd_candiates.len() == 1 {
        hwnd_candiates[0]
    } else {
        println!("以下のMinecraftウィンドウが見つかりました。");
        hwnd_candiates.iter().enumerate().for_each(|(i, hwnd)| {
            println!("{}: {}", i + 1, hwnd.title());
        });

        loop {
            let mut input = String::new();
            std::io::stdin().read_line(&mut input)?;
            let input = input.trim().parse::<usize>()?;
            if input >= 1 && input <= hwnd_candiates.len() {
                break hwnd_candiates[input - 1];
            }
        }
    };

    inject(selected_hwnd, dll_file_path)?;
    
    Ok(())
}
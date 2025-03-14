use winapi::shared::windef::HWND;

pub struct WindowsHWND {
    pub hwnd: HWND,
    pub title: String,
}

pub enum AbstractHWND {
    Windows(WindowsHWND),
}

impl AbstractHWND {
    pub fn title(&self) -> &str {
        match self {
            AbstractHWND::Windows(windows_hwnd) => &windows_hwnd.title,
        }
    }
}

unsafe impl Sync for AbstractHWND {}
unsafe impl Send for AbstractHWND {}

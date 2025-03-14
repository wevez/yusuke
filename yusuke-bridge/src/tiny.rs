use std::collections::HashMap;
use std::io::{self, BufRead};
use std::fs::File;

#[derive(Debug)]
pub struct TinyFile {
    pub header: Header,
    pub classes: HashMap<String, ClassEntry>,
}

#[derive(Debug)]
pub struct Header {
    pub kind: String,
    pub version: u32,
    pub revision: u32,
    pub mode: String,
    pub mapping: String,
}

#[derive(Debug)]
pub struct ClassEntry {
    pub obf: String,
    pub name: String,
    pub members: HashMap<String, Member>,
}

#[derive(Debug)]
pub enum Member {
    Field(FieldEntry),
    Method(MethodEntry),
}

#[derive(Debug)]
pub struct FieldEntry {
    pub access: String,
    pub slot: String,
    pub name: String,
}

#[derive(Debug)]
pub struct MethodEntry {
    pub descriptor: String,
    pub slot: String,
    pub name: String,
}

impl TinyFile {
    // Change signature to accept file content instead of path.
    pub fn parse_file(content: &str) -> io::Result<TinyFile> {
        let mut lines = content.lines().map(|l| l.to_string());
        
        // Parse header: tiny	2	0	intermediary	named
        let header_line = lines.next().ok_or_else(|| io::Error::new(io::ErrorKind::InvalidData, "Empty file"))?;
        let header_parts: Vec<&str> = header_line.split_whitespace().collect();
        if header_parts.len() < 5 {
            return Err(io::Error::new(io::ErrorKind::InvalidData, "Invalid header line"));
        }
        let header = Header {
            kind: header_parts[0].to_string(),
            version: header_parts[1].parse().unwrap_or(0),
            revision: header_parts[2].parse().unwrap_or(0),
            mode: header_parts[3].to_string(),
            mapping: header_parts[4].to_string(),
        };

        let mut classes = HashMap::new();
        let mut current_class: Option<ClassEntry> = None;

        for line in lines {
            if line.trim().is_empty() { continue; }
            // New class entry if line does not start with space/tab.
            if !line.starts_with(' ') && !line.starts_with('\t') {
                if let Some(class) = current_class.take() {
                    classes.insert(class.name.clone(), class);
                }
                let parts: Vec<&str> = line.split_whitespace().collect();
                if parts.len() < 3 { continue; }
                current_class = Some(ClassEntry {
                    obf: parts[1].to_string(),
                    name: parts[2].to_string(),
                    members: HashMap::new(),
                });
            } else {
                // Parse member entries.
                let parts: Vec<&str> = line.trim().split_whitespace().collect();
                if parts.is_empty() || current_class.is_none() { continue; }
                match parts[0] {
                    "f" => {
                        if parts.len() >= 4 {
                            let field = FieldEntry {
                                access: parts[1].to_string(),
                                slot: parts[2].to_string(),
                                name: parts[3].to_string(),
                            };
                            current_class.as_mut().unwrap().members.insert(field.name.clone(), Member::Field(field));
                        }
                    }
                    "m" => {
                        if parts.len() >= 4 {
                            let method = MethodEntry {
                                descriptor: parts[1].to_string(),
                                slot: parts[2].to_string(),
                                name: parts[3].to_string(),
                            };
                            current_class.as_mut().unwrap().members.insert(method.name.clone(), Member::Method(method));
                        }
                    }
                    _ => {}
                }
            }
        }
        if let Some(class) = current_class {
            classes.insert(class.name.clone(), class);
        }
        Ok(TinyFile { header, classes })
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_parse_tiny_file() {
        let tiny = TinyFile::parse_file(include_str!("mappings/vanillav189")).unwrap();
        let player = tiny.classes.get("net/minecraft/client/entity/EntityPlayerSP").unwrap();
        println!("{:?}", player.obf);
        let onupdate = player.members.get("onUpdate").unwrap();
        if let Member::Method(method) = onupdate {
            println!("{:?}", method);
        }
    }
}
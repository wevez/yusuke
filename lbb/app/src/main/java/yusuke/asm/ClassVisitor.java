package yusuke.asm;

public abstract class ClassVisitor
{
    protected final int api;
    protected ClassVisitor cv;
    
    protected ClassVisitor(final int api) {
        this(api, null);
    }
    
    protected ClassVisitor(final int api, final ClassVisitor classVisitor) {
        super();
        if (api != 589824 && api != 524288 && api != 458752 && api != 393216 && api != 327680 && api != 262144 && api != 17432576) {
            throw new IllegalArgumentException("Unsupported api " + api);
        }
        if (api == 17432576) {
            Constants.checkAsmExperimental(this);
        }
        this.api = api;
        this.cv = classVisitor;
    }
    
    public void visit(final int version, final int access, final String name, final String signature, final String superName, final String[] interfaces) {
        if (this.api < 524288 && (access & 0x10000) != 0x0) {
            throw new UnsupportedOperationException("Records requires ASM8");
        }
        if (this.cv != null) {
            this.cv.visit(version, access, name, signature, superName, interfaces);
        }
    }
    
    public void visitSource(final String source, final String debug) {
        if (this.cv != null) {
            this.cv.visitSource(source, debug);
        }
    }
    
    public ModuleVisitor visitModule(final String name, final int access, final String version) {
        if (this.api < 393216) {
            throw new UnsupportedOperationException("Module requires ASM6");
        }
        if (this.cv != null) {
            return this.cv.visitModule(name, access, version);
        }
        return null;
    }
    
    public void visitNestHost(final String nestHost) {
        if (this.api < 458752) {
            throw new UnsupportedOperationException("NestHost requires ASM7");
        }
        if (this.cv != null) {
            this.cv.visitNestHost(nestHost);
        }
    }
    
    public void visitOuterClass(final String owner, final String name, final String descriptor) {
        if (this.cv != null) {
            this.cv.visitOuterClass(owner, name, descriptor);
        }
    }
    
    public AnnotationVisitor visitAnnotation(final String descriptor, final boolean visible) {
        if (this.cv != null) {
            return this.cv.visitAnnotation(descriptor, visible);
        }
        return null;
    }
    
    public AnnotationVisitor visitTypeAnnotation(final int typeRef, final TypePath typePath, final String descriptor, final boolean visible) {
        if (this.api < 327680) {
            throw new UnsupportedOperationException("TypeAnnotation requires ASM5");
        }
        if (this.cv != null) {
            return this.cv.visitTypeAnnotation(typeRef, typePath, descriptor, visible);
        }
        return null;
    }
    
    public void visitAttribute(final Attribute attribute) {
        if (this.cv != null) {
            this.cv.visitAttribute(attribute);
        }
    }
    
    public void visitNestMember(final String nestMember) {
        if (this.api < 458752) {
            throw new UnsupportedOperationException("NestMember requires ASM7");
        }
        if (this.cv != null) {
            this.cv.visitNestMember(nestMember);
        }
    }
    
    public void visitPermittedSubclass(final String permittedSubclass) {
        if (this.api < 589824) {
            throw new UnsupportedOperationException("PermittedSubclasses requires ASM9");
        }
        if (this.cv != null) {
            this.cv.visitPermittedSubclass(permittedSubclass);
        }
    }
    
    public void visitInnerClass(final String name, final String outerName, final String innerName, final int access) {
        if (this.cv != null) {
            this.cv.visitInnerClass(name, outerName, innerName, access);
        }
    }
    
    public RecordComponentVisitor visitRecordComponent(final String name, final String descriptor, final String signature) {
        if (this.api < 524288) {
            throw new UnsupportedOperationException("Record requires ASM8");
        }
        if (this.cv != null) {
            return this.cv.visitRecordComponent(name, descriptor, signature);
        }
        return null;
    }
    
    public FieldVisitor visitField(final int access, final String name, final String descriptor, final String signature, final Object value) {
        if (this.cv != null) {
            return this.cv.visitField(access, name, descriptor, signature, value);
        }
        return null;
    }
    
    public MethodVisitor visitMethod(final int access, final String name, final String descriptor, final String signature, final String[] exceptions) {
        if (this.cv != null) {
            return this.cv.visitMethod(access, name, descriptor, signature, exceptions);
        }
        return null;
    }
    
    public void visitEnd() {
        if (this.cv != null) {
            this.cv.visitEnd();
        }
    }
}

package yusuke.asm;

public abstract class RecordComponentVisitor
{
    protected final int api;
    RecordComponentVisitor delegate;
    
    protected RecordComponentVisitor(final int api) {
        this(api, null);
    }
    
    protected RecordComponentVisitor(final int api, final RecordComponentVisitor recordComponentVisitor) {
        super();
        if (api != 589824 && api != 524288 && api != 458752 && api != 393216 && api != 327680 && api != 262144 && api != 17432576) {
            throw new IllegalArgumentException("Unsupported api " + api);
        }
        if (api == 17432576) {
            Constants.checkAsmExperimental(this);
        }
        this.api = api;
        this.delegate = recordComponentVisitor;
    }
    
    public RecordComponentVisitor getDelegate() {
        return this.delegate;
    }
    
    public AnnotationVisitor visitAnnotation(final String descriptor, final boolean visible) {
        if (this.delegate != null) {
            return this.delegate.visitAnnotation(descriptor, visible);
        }
        return null;
    }
    
    public AnnotationVisitor visitTypeAnnotation(final int typeRef, final TypePath typePath, final String descriptor, final boolean visible) {
        if (this.delegate != null) {
            return this.delegate.visitTypeAnnotation(typeRef, typePath, descriptor, visible);
        }
        return null;
    }
    
    public void visitAttribute(final Attribute attribute) {
        if (this.delegate != null) {
            this.delegate.visitAttribute(attribute);
        }
    }
    
    public void visitEnd() {
        if (this.delegate != null) {
            this.delegate.visitEnd();
        }
    }
}

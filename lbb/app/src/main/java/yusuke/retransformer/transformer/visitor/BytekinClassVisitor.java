package yusuke.retransformer.transformer.visitor;

import yusuke.retransformer.target.MethodData;
import yusuke.retransformer.transformer.BytekinClassTransformer;
import yusuke.retransformer.transformer.api.IBytekinMethodTransformer;
import yusuke.asm.ClassVisitor;
import yusuke.asm.ClassWriter;
import yusuke.asm.MethodVisitor;

import java.util.List;

public class BytekinClassVisitor extends ClassVisitor {

    private final BytekinClassTransformer transformer;

    public BytekinClassVisitor(int api, ClassWriter writer, BytekinClassTransformer transformer) {
        super(api, writer);
        this.transformer = transformer;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        MethodVisitor visitor = super.visitMethod(access, name, descriptor, signature, exceptions);

        List<IBytekinMethodTransformer> transformers = transformer.getMethodTransformers().get(new MethodData(name, descriptor));
        if (transformers == null) {
            return visitor;
        }

        return new BytekinMethodVisitor(api, visitor, transformers, access, name, descriptor, signature, exceptions);
    }
}

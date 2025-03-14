package yusuke.retransformer.transformer;

import yusuke.retransformer.logging.ILogger;
import yusuke.retransformer.mapping.IMappingProvider;
import yusuke.retransformer.target.MethodData;
import yusuke.retransformer.transformer.api.IBytekinMethodTransformer;
import yusuke.retransformer.transformer.visitor.BytekinClassVisitor;
import lombok.Getter;
import yusuke.asm.ClassReader;
import yusuke.asm.ClassWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class BytekinClassTransformer {

    private final Map<MethodData, List<IBytekinMethodTransformer>> methodTransformers;

    public BytekinClassTransformer(ILogger logger, IMappingProvider mapping, Class<?> clazz, String className) {

        this.methodTransformers = IBytekinMethodTransformer.createTransformers(logger, mapping, clazz, className);
    }

    public BytekinClassTransformer() {
        this.methodTransformers = new HashMap<>();
    }

    public byte[] transform(byte[] bytes, int api) {

        ClassReader reader = new ClassReader(bytes);
        ClassWriter writer = new ClassWriter(reader, ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

        reader.accept(new BytekinClassVisitor(api, writer, this), 0);

        return writer.toByteArray();
    }

    public void addTransformer(MethodData methodData, IBytekinMethodTransformer transformer) {
        List<IBytekinMethodTransformer> methodTransformers = this.methodTransformers.computeIfAbsent(methodData, k -> new ArrayList<>());
        methodTransformers.add(transformer);
    }

}

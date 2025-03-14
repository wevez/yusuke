package yusuke.retransformer.transformer.api;

import yusuke.retransformer.injection.Inject;
import yusuke.retransformer.injection.Invoke;
import yusuke.retransformer.logging.ILogger;
import yusuke.retransformer.mapping.IMappingProvider;
import yusuke.retransformer.target.MethodData;
import yusuke.retransformer.transformer.method.InjectMethodTransformer;
import yusuke.retransformer.transformer.method.InvokeMethodTransformer;
import yusuke.retransformer.transformer.visitor.BytekinMethodVisitor;
import yusuke.asm.MethodVisitor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

public interface IBytekinMethodTransformer {

    default void beforeCode(MethodVisitor mv, BytekinMethodVisitor visitor) {}

    default void beforeInsn(MethodVisitor mv, BytekinMethodVisitor visitor, int opcode) {}

    default void beforeMethodInsn(MethodVisitor mv, BytekinMethodVisitor visitor, int opcode, String owner, String name, String descriptor, boolean isInterface) {}

    default void afterMethodInsn(MethodVisitor mv, BytekinMethodVisitor visitor, int opcode, String owner, String name, String descriptor, boolean isInterface) {}

    static Map<MethodData, List<IBytekinMethodTransformer>> createTransformers(ILogger logger, IMappingProvider mapping, Class<?> clazz, String className) {

        Map<MethodData, List<IBytekinMethodTransformer>> transformers = new HashMap<>();

        for (Method method : clazz.getDeclaredMethods()) {

            for (Annotation annotation : method.getDeclaredAnnotations()) {
                if (annotation instanceof Inject) {
                    Inject inject = (Inject) annotation;
                    MethodData methodData = new MethodData(
                            mapping.getMethodName(clazz.getName(), inject.methodName(), inject.methodDesc()),
                            mapping.getMethodDesc(clazz.getName(), inject.methodName(), inject.methodDesc())
                    );
                    List<IBytekinMethodTransformer> methodTransformers = transformers.computeIfAbsent(methodData, k -> new ArrayList<>());
                    methodTransformers.add(new InjectMethodTransformer(logger, mapping, clazz, method, inject, className));
                }

                if (annotation instanceof Invoke) {
                    Invoke invoke = (Invoke) annotation;
                    MethodData methodData = new MethodData(
                            mapping.getMethodName(clazz.getName(), invoke.targetMethodName(), invoke.targetMethodDesc()),
                            mapping.getMethodDesc(clazz.getName(), invoke.targetMethodName(), invoke.targetMethodDesc())
                    );
                    List<IBytekinMethodTransformer> methodTransformers = transformers.computeIfAbsent(methodData, k -> new ArrayList<>());
                    methodTransformers.add(new InvokeMethodTransformer(logger, mapping, clazz, method, invoke, className));
                }
            }

        }

        return transformers;
    }

}

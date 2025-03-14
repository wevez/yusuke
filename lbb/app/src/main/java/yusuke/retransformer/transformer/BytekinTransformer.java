package yusuke.retransformer.transformer;

import yusuke.retransformer.injection.At;
import yusuke.retransformer.injection.ModifyClass;
import yusuke.retransformer.injection.Shift;
import yusuke.retransformer.logging.ILogger;
import yusuke.retransformer.logging.impl.StdLogger;
import yusuke.retransformer.mapping.IMappingProvider;
import yusuke.retransformer.mapping.impl.EmptyMappingProvider;
import yusuke.retransformer.target.MethodData;
import yusuke.retransformer.transformer.method.InjectMethodTransformer;
import yusuke.retransformer.transformer.method.InvokeMethodTransformer;

import java.util.HashMap;
import java.util.Map;

public class BytekinTransformer {

    private final ILogger logger;

    private final Map<String, BytekinClassTransformer> transformers = new HashMap<>();

    private final IMappingProvider mapping;

    public BytekinTransformer(ILogger logger, IMappingProvider mapping, Class<?>... classes) {

        this.logger = logger;
        this.mapping = mapping;

        for (Class<?> clazz : classes) {
            ModifyClass modifyClass = clazz.getAnnotation(ModifyClass.class);
            if (modifyClass == null) {
                logger.log("Class " + clazz.getName() + " does not have ModifyClass annotation");
                continue;
            }

            String className = mapping.getClassName(modifyClass.className());
            if (className == null) {
                logger.log("Class " + modifyClass.className() + " not found in mapping");
            }

            if (transformers.containsKey(className)) {
                logger.log("Class " + className + " already has a transformer");
                continue;
            }

            BytekinClassTransformer transformer = new BytekinClassTransformer(logger, mapping, clazz, className);
            transformers.put(className, transformer);
        }
    }

    public BytekinTransformer(IMappingProvider mapping, Class<?>... classes) {
        this(new StdLogger(), mapping, classes);
    }

    public BytekinTransformer(ILogger logger, Class<?>... classes) {
        this(logger, new EmptyMappingProvider(), classes);
    }

    public BytekinTransformer(Class<?>... classes) {
        this(new StdLogger(), new EmptyMappingProvider(), classes);
    }

    public void addInject(String className, String methodName, String methodDesc, At at, String callMethodOwner, String callMethodName) {
        BytekinClassTransformer transformer = this.transformers.computeIfAbsent(
                this.mapping.getClassName(className),
                k -> new BytekinClassTransformer());

        transformer.addTransformer(
                new MethodData(this.mapping.getMethodName(className, methodName, methodDesc),
                        this.mapping.getMethodDesc(className, methodName, methodDesc)),
                new InjectMethodTransformer(logger, mapping, className, methodName, methodDesc, at, callMethodOwner, callMethodName)
        );
    }

    public void addInvoke(String className, String methodName, String methodDesc, Shift shift, String invokeMethodOwner, String invokeMethodName, String invokeMethodDesc, String callMethodOwner, String callMethodName) {
        BytekinClassTransformer transformer = this.transformers.computeIfAbsent(
                this.mapping.getClassName(className),
                k -> new BytekinClassTransformer());

        transformer.addTransformer(
                new MethodData(this.mapping.getMethodName(className, methodName, methodDesc),
                        this.mapping.getMethodDesc(className, methodName, methodDesc)),
                new InvokeMethodTransformer(logger, mapping, shift, className, methodName, methodDesc, invokeMethodOwner, invokeMethodName, invokeMethodDesc, callMethodOwner, callMethodName)
        );
    }

    public byte[] transform(String className, byte[] bytes, int api) {
        BytekinClassTransformer transformer = transformers.get(className);
        if (transformer == null) {
            return bytes;
        }

        return transformer.transform(bytes, api);
    }

}

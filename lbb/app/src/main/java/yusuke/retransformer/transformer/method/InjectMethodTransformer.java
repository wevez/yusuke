package yusuke.retransformer.transformer.method;

import yusuke.retransformer.injection.At;
import yusuke.client.CallbackInfo;
import yusuke.retransformer.injection.Inject;
import yusuke.retransformer.logging.ILogger;
import yusuke.retransformer.mapping.IMappingProvider;
import yusuke.retransformer.target.TypeData;
import yusuke.retransformer.transformer.api.IBytekinMethodTransformer;
import yusuke.retransformer.util.BytecodeManipulator;
import yusuke.retransformer.util.DescriptorParser;
import yusuke.retransformer.transformer.visitor.BytekinMethodVisitor;
import yusuke.asm.Label;
import yusuke.asm.MethodVisitor;
import yusuke.asm.Opcodes;

import java.lang.reflect.Method;
import java.util.List;

public class InjectMethodTransformer implements IBytekinMethodTransformer {

    private final String targetMethodOwner;
    private final String targetMethodName;
    private final String targetMethodDesc;

    private final String callMethodOwner;
    private final String callMethodName;

    private final At at;

    private boolean isStatic;

    private String getCallMethodDesc(String targetMethodOwner, String targetDesc, boolean isStatic) {
        StringBuilder builder = new StringBuilder();

        builder.append("(");

        if (!isStatic) {
            builder.append("L");
            builder.append(targetMethodOwner);
            builder.append(";");
        }

        builder.append(targetDesc, 1, targetDesc.indexOf(")"));

        builder.append(")");

        builder.append(CallbackInfo.CALLBACK_DESC);

        return builder.toString();
    }

    public InjectMethodTransformer(ILogger logger, IMappingProvider mapping, Class<?> clazz, Method method, Inject inject, String className) {
        this.targetMethodName = mapping.getMethodName(clazz.getName(), inject.methodName(), inject.methodDesc());
        this.targetMethodDesc = mapping.getMethodDesc(clazz.getName(), inject.methodName(), inject.methodDesc());

        this.targetMethodOwner = mapping.getClassName(className.replaceAll("\\.", "/"));
        this.callMethodOwner = method.getDeclaringClass().getName().replace(".", "/");
        this.callMethodName = method.getName();

        this.at = inject.at();
    }

    public InjectMethodTransformer(ILogger logger, IMappingProvider mapping, String className, String methodName, String methodDesc, At at, String callMethodOwner, String callMethodName) {
        this.targetMethodName = mapping.getMethodName(className, methodName, methodDesc);
        this.targetMethodDesc = mapping.getMethodDesc(className, methodName, methodDesc);

        this.targetMethodOwner = mapping.getClassName(className.replaceAll("\\.", "/"));
        this.callMethodOwner = callMethodOwner.replaceAll("\\.", "/");
        this.callMethodName = callMethodName;

        this.at = at;
    }

    private void invokeMethod(MethodVisitor mv) {
        // if target method is not static, load self reference to stack
        if (!isStatic) {
            mv.visitVarInsn(Opcodes.ALOAD, 0);
        }

        // load all parameters that target method has to stack
        int offset = isStatic ? 0 : 1;
        List<TypeData> types = DescriptorParser.parseParameterTypes(targetMethodDesc);
        for (int i = 0; i < types.size(); i++) {
            BytecodeManipulator.load(mv, types.get(i).getCategory(), i + offset);
        }

        int callbackInfoIndex = 1000;//(isStatic ? 0 : 1) + types.size();

        // invoke the method
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, callMethodOwner, callMethodName, getCallMethodDesc(targetMethodOwner, targetMethodDesc, isStatic), false);

        // assign the CallbackInfo to variable
        mv.visitVarInsn(Opcodes.ASTORE, callbackInfoIndex);

        // load CallbackInfo#cancelled to stack
        mv.visitVarInsn(Opcodes.ALOAD, callbackInfoIndex);
        mv.visitFieldInsn(Opcodes.GETFIELD, CallbackInfo.CALLBACK_OWNER, CallbackInfo.FIELD_CANCELLED, "Z");

        // create a label for the jump
        Label cancelledLabel = new Label();

        // if CallbackInfo#cancelled is true, jump to the label
        mv.visitJumpInsn(Opcodes.IFEQ, cancelledLabel);

        // load CallbackInfo#returnValue to stack
        mv.visitVarInsn(Opcodes.ALOAD, callbackInfoIndex);
        mv.visitFieldInsn(Opcodes.GETFIELD, CallbackInfo.CALLBACK_OWNER, CallbackInfo.FIELD_RETURN_VALUE, "Ljava/lang/Object;");

        // cast the return value to the target method return type
        TypeData returnType = DescriptorParser.parseReturnType(targetMethodDesc);
        BytecodeManipulator.cast(mv, returnType);
        BytecodeManipulator.doReturn(mv, returnType);

        // mark the label
        mv.visitLabel(cancelledLabel);
    }

    @Override
    public void beforeCode(MethodVisitor mv, BytekinMethodVisitor visitor) {
        if (at != At.HEAD) {
            return;
        }

        isStatic = (visitor.getAccess() & Opcodes.ACC_STATIC) != 0;
        invokeMethod(mv);

        IBytekinMethodTransformer.super.beforeCode(mv, visitor);
    }

    @Override
    public void beforeInsn(MethodVisitor mv, BytekinMethodVisitor visitor, int opcode) {
        if (at != At.RETURN) {
            return;
        }

        if (Opcodes.IRETURN <= opcode && opcode <= Opcodes.RETURN) {
            invokeMethod(mv);
        }

        IBytekinMethodTransformer.super.beforeInsn(mv, visitor, opcode);
    }

}

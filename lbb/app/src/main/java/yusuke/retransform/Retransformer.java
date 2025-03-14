package yusuke.retransform;

import yusuke.asm.*;
import yusuke.retransformer.injection.At;
import yusuke.retransformer.injection.Shift;
import yusuke.retransformer.mapping.impl.TinyMappingProvider;
import yusuke.retransformer.transformer.BytekinTransformer;

import java.io.FileWriter;
import java.io.IOException;

public class Retransformer {
    public static final String HOOK_METHOD_OWNER = "yusuke/mixin/Hooked";
    private static boolean initialized = false;
    private static String windowTitle;
    public static String mappingRaw = null;

    private static TinyMappingProvider mapping;

    private static BytekinTransformer transformer;

    public static void init(String windowTitle) {
        if (!initialized) {
            initialized = true;
            Retransformer.windowTitle = windowTitle;
            mapping = new TinyMappingProvider(mappingRaw);

            transformer = new BytekinTransformer(mapping);
            transformer.addInject(
                    "net/minecraft/client/entity/EntityPlayerSP",
                    "onUpdateWalkingPlayer",
                    "()V",
                    At.HEAD,
                    HOOK_METHOD_OWNER,
                    "onUpdatePre"
            );
            transformer.addInject(
                    "net/minecraft/client/entity/EntityPlayerSP",
                    "onUpdateWalkingPlayer",
                    "()V",
                    At.RETURN,
                    HOOK_METHOD_OWNER,
                    "onUpdatePost"
            );
            transformer.addInvoke(
                    "net/minecraft/client/Minecraft",
                    windowTitle.contains("Bad") ? "runInputTick" : "runTick", // TODO: Lunarだとまた違うかも?
                    "()V",
                    Shift.AFTER,
                    "net/minecraft/client/settings/KeyBinding",
                    "setKeyBindState",
                    "(IZ)V",
                    HOOK_METHOD_OWNER,
                    "onKeyPress"
            );
        }
    }

    /**
     * bytecodeを受け取り、それをASMを用いて改造し、改造されたbytecodeを返します。
     *
     * @param classBytes bytecode
     * @param className class name
     * @return 改造されたbytecode
     */
    public static byte[] retransform(byte[] classBytes, String className) {
        try {

//            try {
//                byte[] data = transformer.transform(className, classBytes, Opcodes.ASM9);
//                try (FileOutputStream fos = new FileOutputStream("C:\\Users\\tenam\\OneDrive\\Desktop\\" + className.replaceAll("/", "_") + ".class")) {
//                    fos.write(data);
//                    System.out.println("ファイルに書き込みが完了しました。");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            } catch (Exception ignore) {}

            return transformer.transform(className, classBytes, Opcodes.ASM9);
        } catch (Exception e) {
            try {
                FileWriter writer = new FileWriter("C:\\Users\\tenam\\OneDrive\\Desktop\\error.txt");
                writer.write(e.toString());
                writer.close();
            } catch (IOException e1) {
            }
        }

        return classBytes;
    }
}

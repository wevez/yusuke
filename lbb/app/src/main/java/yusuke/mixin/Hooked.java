package yusuke.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import yusuke.client.Yusuke;
import yusuke.client.CallbackInfo;
import yusuke.client.event.impl.*;

public class Hooked {

    public static CallbackInfo onUpdatePre(EntityPlayerSP self) {
        Yusuke.init();
        return CallbackInfo.empty();
    }

    public static CallbackInfo onUpdatePost(EntityPlayerSP self) {
        Yusuke.init();
        Yusuke.getEventBus().handle(new EventUpdatePost());
        return CallbackInfo.empty();
    }

    public static CallbackInfo onKeyPress(Minecraft mc, int key, boolean state) {
        Yusuke.init();
        Yusuke.getEventBus().handle(new EventKeyPress(key, state));
        return new CallbackInfo(
                false,
                null,
                new Object[] { key, state }
        );
    }

}

package yusuke.client.module.impl.combat;

import yusuke.client.event.Listener;
import yusuke.client.event.annotations.EventLink;
import yusuke.client.event.impl.EventUpdatePost;
import yusuke.client.module.Module;
import yusuke.client.module.ModuleCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class AimAssist extends Module {

    public AimAssist() {
        super("AimAssist", "AimAssist", ModuleCategory.Combat);
    }

    @EventLink
    public final Listener<EventUpdatePost> onUpdatePost = event -> {
        Minecraft.getMinecraft().thePlayer.motionY = 0;
    };

}

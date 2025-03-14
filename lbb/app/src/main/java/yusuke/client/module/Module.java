package yusuke.client.module;

import com.google.common.collect.Lists;
import yusuke.client.Yusuke;
import yusuke.client.bindable.Bindable;
import yusuke.client.module.setting.ModuleSetting;
import yusuke.client.util.animation.AnimationUtil;
import yusuke.client.util.animation.LinearAnimation;

import java.util.List;

public class Module implements Bindable {

    public AnimationUtil toggleAnimation = new LinearAnimation();
    public AnimationUtil settingAnimation = new LinearAnimation();

    private final String name, description;

    private final ModuleCategory category;

    protected final List<ModuleSetting> settingList;

    private boolean toggled;

    private int keyCode;

    protected String suffix = "";

    public final String getSuffix() {
        return suffix;
    }

    public Module(String name, String description, ModuleCategory category) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.settingList = Lists.newArrayList();
        this.keyCode = 0;
    }

    public void init() {}

    public final int getKeyCode() {
        return keyCode;
    }

    public final void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }

    protected void onEnable() {
    }

    protected void onDisable() {
    }

    public final void toggle() {
        this.toggled = !this.toggled;
        if (this.toggled) {
            Yusuke.getEventBus().register(this);
            this.onEnable();
        } else {
            Yusuke.getEventBus().unregister(this);
            this.onDisable();
        }
    }

    @Override
    public int getKey() {
        return keyCode;
    }

    @Override
    public void setKey(int key) {
        this.keyCode = key;
    }

    @Override
    public void onKey() {
        this.toggle();
    }

    public final String getName() {
        return name;
    }

    public final String getDescription() {
        return description;
    }

    public final ModuleCategory getCategory() {
        return category;
    }

    public final List<ModuleSetting> getSettingList() {
        return settingList;
    }

    public final boolean isToggled() {
        return this.toggled;
    }
}

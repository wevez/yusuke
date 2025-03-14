package yusuke.client.bindable;


import net.minecraft.client.Minecraft;
import yusuke.client.Yusuke;
import yusuke.client.event.Listener;
import yusuke.client.event.Priorities;
import yusuke.client.event.annotations.EventLink;
import yusuke.client.event.impl.EventKeyPress;
import yusuke.gui.click.ClickGui;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BindableManager {
    
    public void init() {
        // Has to be a listener to handle the key presses
        Yusuke.getEventBus().register(this);
    }

    public List<Bindable> getBinds() {
        List<Bindable> bindableList = new ArrayList<>();
// TODO
        bindableList.addAll(Yusuke.getModuleManager().getModules());
//        bindableList.addAll(Yusuke.getConfigManager());
        
        return bindableList;
    }

    private final Set<Integer> pressedKeys = new java.util.HashSet<>();

    private static final ClickGui CLICK_GUI = new ClickGui();

    @EventLink(value = Priorities.VERY_LOW)
    public final Listener<EventKeyPress> onKey = event -> {
        if (!event.pressed) pressedKeys.remove(event.keyCode);
        if (Minecraft.getMinecraft().currentScreen != null || event.isCancelled() || !event.pressed) return;
        if (pressedKeys.contains(event.keyCode)) return;
        pressedKeys.add(event.keyCode);
        getBinds().stream()
                .filter(bind -> bind.getKey() == event.keyCode)
                .forEach(Bindable::onKey);
        if (event.keyCode == 25) {
            Minecraft.getMinecraft().displayGuiScreen(CLICK_GUI);
        }
    };
}

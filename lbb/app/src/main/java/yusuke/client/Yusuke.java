package yusuke.client;

import lombok.Getter;
import yusuke.client.bindable.BindableManager;
import yusuke.client.event.Event;
import yusuke.client.event.bus.impl.EventBus;
import yusuke.client.module.ModuleManager;

import java.awt.*;

public class Yusuke {
    private static boolean initialized = false;

    public static String NAME = "Mania";
    public static final String VERSION = "1.0.0";

    public static Robot robot;

    @Getter
    private static EventBus<Event> eventBus;
    @Getter
    private static BindableManager bindableManager;
    @Getter
    private static ModuleManager moduleManager;

    public static void init() {
        if (!initialized) {
            initialized = true;

            eventBus = new EventBus<>();
            moduleManager = new ModuleManager();
            moduleManager.init();
            bindableManager = new BindableManager();
            bindableManager.init();

            try {
                robot = new Robot();
            } catch (Exception e) {
            }
        }
    }
}

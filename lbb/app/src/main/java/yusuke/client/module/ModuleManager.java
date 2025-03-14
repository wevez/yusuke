package yusuke.client.module;

import lombok.Getter;
import yusuke.client.module.impl.combat.AimAssist;

import java.util.Arrays;
import java.util.List;

@Getter
public class ModuleManager {

    private final List<Module> modules = Arrays.asList(
            new AimAssist()
    );

    public void init() {
        modules.forEach(Module::init);
    }
}

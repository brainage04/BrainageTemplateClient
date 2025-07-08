package io.github.brainage04.brainagetemplateclient.key.core;

import io.github.brainage04.brainagetemplateclient.BrainageTemplateClient;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class ModKeys {
    public static final KeyBinding testKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.%s.testKey".formatted(BrainageTemplateClient.MOD_ID),
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_R,
            "key.category.%s".formatted(BrainageTemplateClient.MOD_ID)
    ));

    public static void initialize() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (testKey.isPressed()) {
                // used for instant/discrete actions such as toggles
            }

            while (testKey.wasPressed()) {
                // used for continuous actions such as mining blocks
            }
        });
    }
}

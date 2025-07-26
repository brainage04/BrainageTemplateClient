package io.github.brainage04.brainagetemplateclient.command.core;

import io.github.brainage04.brainagetemplateclient.command.TemplateCommand;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;

public class ModCommands {
    public static void initialize() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            TemplateCommand.initialize(dispatcher);
        });
    }
}

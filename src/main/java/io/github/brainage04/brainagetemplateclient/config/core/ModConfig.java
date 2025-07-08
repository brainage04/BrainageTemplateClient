package io.github.brainage04.brainagetemplateclient.config.core;

import io.github.brainage04.brainagetemplateclient.BrainageTemplateClient;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

// final fields will crash the game when saving
@SuppressWarnings("CanBeFinal")
@Config(name = BrainageTemplateClient.MOD_ID)
public class ModConfig implements ConfigData {
    public static boolean test = true;
}

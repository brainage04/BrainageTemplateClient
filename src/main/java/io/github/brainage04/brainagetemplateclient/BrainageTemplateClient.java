package io.github.brainage04.brainagetemplateclient;

import io.github.brainage04.brainagetemplateclient.command.core.ModCommands;
import io.github.brainage04.brainagetemplateclient.config.core.ModConfig;
import io.github.brainage04.brainagetemplateclient.key.core.ModKeys;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrainageTemplateClient implements ClientModInitializer {
	public static final String MOD_ID = "brainagetemplateclient";
	public static final String MOD_NAME = "BrainageTemplateClient";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitializeClient() {
		LOGGER.info("{} initialising...", MOD_NAME);

		AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);
		ModCommands.initialize();
		ModKeys.initialize();

		LOGGER.info("{} initialised.", MOD_NAME);
	}
}
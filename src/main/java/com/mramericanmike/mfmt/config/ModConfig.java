package com.mramericanmike.mfmt.config;

import com.mramericanmike.mfmt.MinecraftFabricModTemplate;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class ModConfig {

	private final Path CONIFGS_PATH = FabricLoader.getInstance().getConfigDir().resolve("mfmt.properties");

	private final String TEST1_KEY = "test1";
	private final String TEST2_KEY = "test2";
	public boolean test1 = true;
	public boolean test2 = true;

	public void register() {
		Properties properties = new Properties();
		if (!Files.exists(CONIFGS_PATH)) {
			try {
				Files.createFile(CONIFGS_PATH);
				saveProperties(properties);
			} catch (IOException e) {
				MinecraftFabricModTemplate.LOGGER.error("Failed to create configuration file!");
				e.printStackTrace();
				return;
			}
		} else {
			try {
				properties.load(Files.newInputStream(CONIFGS_PATH));
			} catch (IOException e) {
				MinecraftFabricModTemplate.LOGGER.error("Failed to read configuration file!");
				e.printStackTrace();
			}
		}
		readProperties(properties);
		saveProperties(properties);
	}

	private void saveProperties(Properties properties) {
		properties.setProperty(TEST1_KEY, Boolean.toString(this.test1));
		properties.setProperty(TEST2_KEY, Boolean.toString(this.test2));
		try {
			properties.store(Files.newOutputStream(CONIFGS_PATH), "Configuration file");
		} catch (IOException e) {
			MinecraftFabricModTemplate.LOGGER.error("Failed to write to configuration file!");
			e.printStackTrace();
		}
	}

	private void readProperties(Properties properties) {
		this.test1 = defaultedBool(properties.getProperty(TEST1_KEY), this.test1);
		this.test2 = defaultedBool(properties.getProperty(TEST2_KEY), this.test2);
	}

	private boolean bool(String bool) {
		return bool != null && bool.equalsIgnoreCase("true");
	}

	private boolean defaultedBool(String bool, boolean defaultValue) {
		return bool == null ? defaultValue : bool(bool);
	}
}

package com.mramericanmike.mfmt.config;

import com.mramericanmike.mfmt.MinecraftFabricModTemplate;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class ModConfig {

	private static final Path CONIFGS_PATH = FabricLoader.getInstance().getConfigDir().resolve("mfmt.properties");
	private static final String TEST1_KEY = "test1";
	private static final String TEST2_KEY = "test2";
	public static boolean test1 = true;
	public static boolean test2 = true;

	public static void register() {
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

	private static void saveProperties(Properties properties) {
		properties.setProperty(TEST1_KEY, Boolean.toString(test1));
		properties.setProperty(TEST2_KEY, Boolean.toString(test2));
		try {
			properties.store(Files.newOutputStream(CONIFGS_PATH), "Configuration file");
		} catch (IOException e) {
			MinecraftFabricModTemplate.LOGGER.error("Failed to write to configuration file!");
			e.printStackTrace();
		}
	}

	private static void readProperties(Properties properties) {
		test1 = defaultedBool(properties.getProperty(TEST1_KEY), test1);
		test2 = defaultedBool(properties.getProperty(TEST2_KEY), test2);
	}

	private static boolean bool(String bool) {
		return bool != null && bool.equalsIgnoreCase("true");
	}

	private static boolean defaultedBool(String bool, boolean defaultValue) {
		return bool == null ? defaultValue : bool(bool);
	}
}

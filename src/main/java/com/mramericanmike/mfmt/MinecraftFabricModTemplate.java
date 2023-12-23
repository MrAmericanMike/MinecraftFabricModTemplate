package com.mramericanmike.mfmt;

import com.mramericanmike.mfmt.blocks.ModBlocks;
import com.mramericanmike.mfmt.config.ModConfig;
import com.mramericanmike.mfmt.creativetab.ModCreativeTab;
import com.mramericanmike.mfmt.items.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinecraftFabricModTemplate implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger(ModInfo.MOD_ID);
	public static final ModConfig CONFIG = new ModConfig();

	@Override
	public void onInitialize() {

		LOGGER.info("MinecraftFabricModTemplate");
		CONFIG.register();
		ModItems.register();
		ModBlocks.register();
		ModCreativeTab.register();
	}
}
package com.mramericanmike.mfmt;

import com.mramericanmike.mfmt.blocks.ModBlocks;
import com.mramericanmike.mfmt.items.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinecraftFabricModTemplate implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger(ModInfo.MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("MinecraftFabricModTemplate");
		ModItems.register();
		ModBlocks.register();

	}

}

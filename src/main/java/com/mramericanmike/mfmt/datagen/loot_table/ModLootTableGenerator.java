package com.mramericanmike.mfmt.datagen.loot_table;

import com.mramericanmike.mfmt.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
	public ModLootTableGenerator(FabricDataOutput dataOutput) {
		super(dataOutput);
	}

	@Override
	public void generate() {
		addDrop(ModBlocks.TABLE);
	}

}

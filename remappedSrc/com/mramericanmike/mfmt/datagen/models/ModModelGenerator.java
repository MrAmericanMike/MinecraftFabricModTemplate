package com.mramericanmike.mfmt.datagen.models;

import com.mramericanmike.mfmt.ModInfo;
import com.mramericanmike.mfmt.blocks.ModBlocks;
import com.mramericanmike.mfmt.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.util.Identifier;

public class ModModelGenerator extends FabricModelProvider {

	public ModModelGenerator(FabricDataGenerator dataGenerator) {
		super(dataGenerator);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
		blockStateModelGenerator.registerParentedItemModel(ModBlocks.TABLE, new Identifier(ModInfo.MOD_ID, "block/table"));
		blockStateModelGenerator.registerStateWithModelReference(ModBlocks.TABLE, ModBlocks.TABLE);
	}

	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		itemModelGenerator.register(ModItems.EMERALD_WAND, Models.GENERATED);
	}
}

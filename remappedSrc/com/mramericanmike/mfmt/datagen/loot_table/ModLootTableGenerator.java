package com.mramericanmike.mfmt.datagen.loot_table;

import com.mramericanmike.mfmt.ModInfo;
import com.mramericanmike.mfmt.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.data.server.loottable.VanillaBlockLootTableGenerator;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class ModLootTableGenerator extends SimpleFabricLootTableProvider {
	public ModLootTableGenerator(FabricDataGenerator dataGenerator) {
		super(dataGenerator, LootContextTypes.BLOCK);
	}

	@Override
	public void accept(BiConsumer<Identifier, LootTable.Builder> identifierBuilderBiConsumer) {
		identifierBuilderBiConsumer.accept(new Identifier(ModInfo.MOD_ID, "blocks/table"), VanillaBlockLootTableGenerator.drops(ModBlocks.TABLE));
	}
}

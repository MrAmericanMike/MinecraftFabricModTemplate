package com.mramericanmike.mfmt.datagen.tags;

import com.mramericanmike.mfmt.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTagGenerator extends FabricTagProvider<Block> {
	public ModTagGenerator(FabricDataGenerator dataGenerator) {
		super(dataGenerator, Registry.BLOCK);
	}

	private static final TagKey<Block> PICKAXE = TagKey.of(Registry.BLOCK_KEY, new Identifier("minecraft:mineable/pickaxe"));

	@Override
	protected void generateTags() {
		getOrCreateTagBuilder(PICKAXE)
				.add(ModBlocks.VOID)
				.add(ModBlocks.TABLE);
	}
}

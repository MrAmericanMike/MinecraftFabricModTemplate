package com.mramericanmike.mfmt.datagen.tags;

import com.mramericanmike.mfmt.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModTagGenerator extends FabricTagProvider<Block> {
	private static final TagKey<Block> PICKAXE = TagKey.of(RegistryKeys.BLOCK, new Identifier("minecraft:mineable/pickaxe"));

	public ModTagGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(dataOutput, RegistryKeys.BLOCK, registriesFuture);
	}

	@Override
	protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
		getOrCreateTagBuilder(PICKAXE)
				.add(ModBlocks.VOID)
				.add(ModBlocks.TABLE);
	}
}

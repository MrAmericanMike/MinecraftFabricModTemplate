package com.mramericanmike.mfmt.blocks;

import com.mramericanmike.mfmt.ModInfo;
import com.mramericanmike.mfmt.creativetab.ModCreativeTab;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

	public static final Block VOID = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.METAL).strength(4.0f).requiresTool());
	public static final Block TABLE = new TableBlock();

	public static void register() {
		registerBlockAndItemToCreativeTab(VOID, "void");
		registerBlockAndItemToCreativeTab(TABLE, "table");
	}

	private static void registerBlockAndItemToCreativeTab(Block block, String id) {
		registerBlock(block, id);
		registerBlockItemToCreativeTab(block, id);
	}

	private static void registerBlockAndItem(Block block, String id) {
		registerBlock(block, id);
		registerBlockItem(block, id);
	}

	private static void registerBlock(Block block, String id) {
		Registry.register(Registries.BLOCK, new Identifier(ModInfo.MOD_ID, id), block);
	}

	private static void registerBlockItemToCreativeTab(Block block, String id) {
		Registry.register(Registries.ITEM, new Identifier(ModInfo.MOD_ID, id), new BlockItem(block, new FabricItemSettings()));
		ModCreativeTab.add(block.asItem());
	}

	private static void registerBlockItem(Block block, String id) {
		Registry.register(Registries.ITEM, new Identifier(ModInfo.MOD_ID, id), new BlockItem(block, new FabricItemSettings()));
	}
}

package com.mramericanmike.mfmt.blocks;

import com.mramericanmike.mfmt.creativetab.ModCreativeTab;
import com.mramericanmike.mfmt.ModInfo;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

	public static final Block VOID = new Block(FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.METAL).strength(4.0f).requiresTool());
	public static final Block TABLE = new TableBlock();

	public static void register(){
		registerBlockAndItem(VOID, "void", ModCreativeTab.TAB);
		registerBlockAndItem(TABLE, "table", ModCreativeTab.TAB);
	}

	private static void registerBlockAndItem(Block block, String id, ItemGroup group){
		registerBlock(block, id);
		registerBlockItem(block, id, group);
	}

	private static void registerBlockAndItem(Block block, String id){
		registerBlock(block, id);
		registerBlockItem(block, id);
	}

	private static void registerBlock(Block block, String id){
		Registry.register(Registry.BLOCK, new Identifier(ModInfo.MOD_ID, id), block);
	}

	private static void registerBlockItem(Block block, String id, ItemGroup group){
		Registry.register(Registry.ITEM, new Identifier(ModInfo.MOD_ID, id), new BlockItem(block, new FabricItemSettings().group(group)));
	}

	private static void registerBlockItem(Block block, String id){
		Registry.register(Registry.ITEM, new Identifier(ModInfo.MOD_ID, id), new BlockItem(block, new FabricItemSettings()));
	}
}

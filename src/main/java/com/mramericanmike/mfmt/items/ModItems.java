package com.mramericanmike.mfmt.items;

import com.mramericanmike.mfmt.ModInfo;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

	// If the item doesn't need anything special, we can create it using the Item class
	// public static final Item WAND = new Item(new FabricItemSettings().group(ModCreativeTab.TAB).maxCount(1));

	// If the item has custom functionality, we create it in our own class
	public static final Item WAND = new WandItem();
	public static final Item EMERALD_WAND = new EmeraldWandItem();


	public static void register(){
		Registry.register(Registry.ITEM, new Identifier(ModInfo.MOD_ID, "wand"), WAND);
		Registry.register(Registry.ITEM, new Identifier(ModInfo.MOD_ID, "emerald_wand"), EMERALD_WAND);
	}

}

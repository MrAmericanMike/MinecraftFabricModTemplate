package com.mramericanmike.mfmt.creativetab;

import com.mramericanmike.mfmt.ModInfo;
import com.mramericanmike.mfmt.items.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModCreativeTab {
	public static final ItemGroup TAB = FabricItemGroup
		.builder(new Identifier(ModInfo.MOD_ID, "creativetab"))
		.icon(() -> new ItemStack(ModItems.WAND))
		.build();
	public static void add(ItemConvertible item){
		ItemGroupEvents.modifyEntriesEvent(TAB).register(content -> {
			content.add(item);
		});
	}
}

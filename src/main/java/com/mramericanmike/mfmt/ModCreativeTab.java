package com.mramericanmike.mfmt;

import com.mramericanmike.mfmt.items.ModItems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModCreativeTab {
	public static final ItemGroup TAB = FabricItemGroupBuilder
			.create(new Identifier(ModInfo.MOD_ID, "creativetab"))
			.icon(() -> new ItemStack(ModItems.WAND))
			.build();
}

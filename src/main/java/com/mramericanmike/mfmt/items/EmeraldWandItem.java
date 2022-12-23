package com.mramericanmike.mfmt.items;

import com.mramericanmike.mfmt.creativetab.ModCreativeTab;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EmeraldWandItem extends Item {
	public EmeraldWandItem() {
		super(new FabricItemSettings().maxCount(1));
		ModCreativeTab.add(this);
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add( Text.translatable("item.mfmt.emerald_wand.tooltip"));
	}
}

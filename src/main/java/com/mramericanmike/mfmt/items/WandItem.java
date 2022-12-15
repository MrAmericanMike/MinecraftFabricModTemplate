package com.mramericanmike.mfmt.items;

import com.mramericanmike.mfmt.ModCreativeTab;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WandItem extends Item {
	public WandItem() {
		super(new FabricItemSettings().group(ModCreativeTab.TAB).maxCount(1));
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add( Text.translatable("item.mfmt.wand.tooltip"));
	}
}

package com.mramericanmike.mfmt.items;

import com.mramericanmike.mfmt.creativetab.ModCreativeTab;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
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

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		World world = context.getWorld();
		BlockPos blockPos = context.getBlockPos();
		Block block = world.getBlockState(blockPos).getBlock();
		if(block.equals(Blocks.SAND)){
			if(world.isClient) {
				world.addParticle(ParticleTypes.FLAME, blockPos.getX() + 0.5d, blockPos.getY() + 0.5d, blockPos.getZ() + 0.5d, 0, 0, 0);
				world.playSound(blockPos.getX() + 0.5d, blockPos.getY() + 0.5d, blockPos.getZ() + 0.5d, SoundEvents.BLOCK_CAMPFIRE_CRACKLE, SoundCategory.BLOCKS, 1F, 1F, true);
			}
			else {
				world.removeBlock(blockPos, false);
				world.setBlockState(blockPos, Blocks.GLASS.getDefaultState());
			}
		}

		return ActionResult.SUCCESS;
	}
}

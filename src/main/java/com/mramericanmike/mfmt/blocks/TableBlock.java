package com.mramericanmike.mfmt.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class TableBlock extends Block {

	protected static final VoxelShape SHAPE;

	static {
		SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 13.0, 16.0);
	}

	public TableBlock() {
		super(FabricBlockSettings
				.of(Material.METAL)
				.sounds(BlockSoundGroup.METAL)
				.strength(5.0F)
				.requiresTool()
				.mapColor(MapColor.IRON_GRAY)
				.nonOpaque()
		);
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return SHAPE;
	}

	@Override
	public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
		return (!world.getBlockState(pos.down()).isOf(this) && world.getBlockState(pos.down()).isSolidBlock(world, pos.down()));
	}

	@Override
	public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
		super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
		if (!world.isClient) {
			world.scheduleBlockTick(pos, this, 1);
		}
	}

	@Override
	public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
		if (!world.isClient) {
			world.scheduleBlockTick(pos, this, 1);
		}
	}

	public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		if (!canPlaceAt(state, world, pos)) {
			world.breakBlock(pos, true);
		}
	}
}

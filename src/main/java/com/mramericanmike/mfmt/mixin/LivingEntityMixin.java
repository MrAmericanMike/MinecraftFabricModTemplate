package com.mramericanmike.mfmt.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
	@Inject(method = "isClimbing", at = @At("TAIL"), cancellable = true)
	public void isClimbing(CallbackInfoReturnable<Boolean> cir){
		LivingEntity livingEntity = (LivingEntity) (Object) this;
		BlockState blockState = livingEntity.getWorld().getBlockState(livingEntity.getBlockPos());
		if (blockState.getBlock() instanceof TrapdoorBlock && this.canEnterTrapdoor(livingEntity.getBlockPos(), blockState, livingEntity.getWorld())) {
			cir.setReturnValue(true);
		}

//		CanClimbTrapdoorCallback.EVENT.invoker().evaluate(livingEntity.getBlockPos(), livingEntity.getWorld());

		//		cir.getReturnValue();
	}

	private boolean canEnterTrapdoor(BlockPos pos, BlockState state, World world) {
		if ((Boolean)state.get(TrapdoorBlock.OPEN)) {
			BlockState blockState = world.getBlockState(pos.down());
			System.out.println("HERE 2: " + blockState.isOf(Blocks.VINE));
			return blockState.isOf(Blocks.VINE);
		}
		return false;
	}
}

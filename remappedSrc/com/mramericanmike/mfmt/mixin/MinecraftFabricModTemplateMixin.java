package com.mramericanmike.mfmt.mixin;

import com.mramericanmike.mfmt.events.SheepShearCallback;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class MinecraftFabricModTemplateMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		com.mramericanmike.mfmt.MinecraftFabricModTemplate.LOGGER.info("This line is printed by Minecraft Fabric Mod Template mixin!");
	}
}

@Mixin(SheepEntity.class)
public class SheepShearMixin {

	@Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/passive/SheepEntity;dropItems()V"), method = "interactMob", cancellable = true)
	private void onShear(final PlayerEntity player, final Hand hand, final CallbackInfoReturnable<Boolean> info) {
		ActionResult result = SheepShearCallback.EVENT.invoker().interact(player, (SheepEntity) (Object) this);

		if(result == ActionResult.FAIL) {
			info.cancel();
		}
	}
}

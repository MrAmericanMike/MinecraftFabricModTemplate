package com.mramericanmike.mfmt;

import com.mramericanmike.mfmt.blocks.ModBlocks;
import com.mramericanmike.mfmt.items.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinecraftFabricModTemplate implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger(ModInfo.MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("MinecraftFabricModTemplate");
		ModItems.register();
		ModBlocks.register();

//		AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) ->
//		{
//			BlockState state = world.getBlockState(pos);
//            /* Manual spectator check is necessary because AttackBlockCallbacks
//               fire before the spectator check */
//			if (state.isToolRequired() && !player.isSpectator() &&
//					player.getMainHandStack().isEmpty())
//			{
//				player.damage(DamageSource.GENERIC, 1.0F);
//			}
//			return ActionResult.PASS;
//		});
	}
}

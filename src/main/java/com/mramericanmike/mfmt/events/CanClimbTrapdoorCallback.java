package com.mramericanmike.mfmt.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface CanClimbTrapdoorCallback {
	Event<CanClimbTrapdoorCallback> EVENT = EventFactory.createArrayBacked(CanClimbTrapdoorCallback.class,
			(listeners) -> (position, world) -> {
				for (CanClimbTrapdoorCallback listener : listeners) {
					return listener.evaluate(position, world);
				}
				return false;
			});

	boolean evaluate(BlockPos position, World world);

}

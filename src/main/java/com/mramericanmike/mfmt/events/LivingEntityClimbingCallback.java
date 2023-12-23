package com.mramericanmike.mfmt.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.LivingEntity;

public interface LivingEntityClimbingCallback {
	Event<LivingEntityClimbingCallback> EVENT = EventFactory.createArrayBacked(LivingEntityClimbingCallback.class,
			(listeners) -> (livingEntity) -> {
				for (LivingEntityClimbingCallback listener : listeners) {
					return listener.isClimbing(livingEntity);
				}
				return false;
			});

	boolean isClimbing(LivingEntity livingEntity);
}

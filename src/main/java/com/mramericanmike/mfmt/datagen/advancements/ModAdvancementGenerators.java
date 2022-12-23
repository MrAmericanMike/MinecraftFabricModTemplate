package com.mramericanmike.mfmt.datagen.advancements;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.util.Util;
import org.apache.commons.compress.utils.Lists;

import java.util.List;
import java.util.function.Consumer;

public class ModAdvancementGenerators extends FabricAdvancementProvider {

	private final List<Consumer<Consumer<Advancement>>> generators = Util.make(Lists.newArrayList(), list -> {
		list.add(new CustomAdvancementsGenerator());
	});

	public ModAdvancementGenerators(FabricDataOutput dataOutput) {
		super(dataOutput);
	}

	@Override
	public void generateAdvancement(Consumer<Advancement> consumer) {
		generators.forEach((generator) -> generator.accept(consumer));
	}
}

package com.mramericanmike.mfmt.datagen;

import com.mramericanmike.mfmt.datagen.advancements.ModAdvancementGenerators;
import com.mramericanmike.mfmt.datagen.lang.ModEnglishLangProvider;
import com.mramericanmike.mfmt.datagen.models.ModModelGenerator;
import com.mramericanmike.mfmt.datagen.recipes.ModRecipeGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ModDatagen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		fabricDataGenerator.addProvider(ModModelGenerator::new);
		fabricDataGenerator.addProvider(ModEnglishLangProvider::new);
		fabricDataGenerator.addProvider(ModAdvancementGenerators::new);
		fabricDataGenerator.addProvider(ModRecipeGenerator::new);
	}
}

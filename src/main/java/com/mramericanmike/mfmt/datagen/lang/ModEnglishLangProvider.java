package com.mramericanmike.mfmt.datagen.lang;

import com.mramericanmike.mfmt.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import java.nio.file.Path;

public class ModEnglishLangProvider extends FabricLanguageProvider {
	public ModEnglishLangProvider(FabricDataGenerator dataGenerator) {
		super(dataGenerator, "en_us");
	}

	@Override
	public void generateTranslations(TranslationBuilder translationBuilder) {
		translationBuilder.add(ModItems.EMERALD_WAND, "Emerald Wand");
		translationBuilder.add("item.mfmt.emerald_wand.tooltip", "It's EmeraldWandtastick");

		// Load an existing language file. This allows combining manual added values with code generated ones
		try {
			Path existingFilePath = dataGenerator.getModContainer().findPath("assets/mfmt/lang/en_us.manual.json").orElse(null);
			translationBuilder.add(existingFilePath);
		} catch (Exception e) {
			throw new RuntimeException("Failed to add existing language file!", e);
		}
	}
}

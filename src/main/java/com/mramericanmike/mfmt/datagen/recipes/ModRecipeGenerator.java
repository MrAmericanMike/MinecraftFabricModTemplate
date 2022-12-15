package com.mramericanmike.mfmt.datagen.recipes;

import com.mramericanmike.mfmt.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.RecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;

import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
	public ModRecipeGenerator(FabricDataGenerator dataGenerator) {
		super(dataGenerator);
	}

	@Override
	protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
		// NOTICE on input we must use ' singlequote as it takes a char and not a string
		ShapedRecipeJsonBuilder.create(ModItems.EMERALD_WAND, 1)
				.pattern("  W")
				.pattern( " E ")
				.pattern("W  ")
				.input('W', ModItems.WAND)
				.input('E', Items.EMERALD)
				.criterion(RecipeProvider.hasItem(ModItems.WAND), RecipeProvider.conditionsFromItem(ModItems.WAND))
				.criterion(RecipeProvider.hasItem(Items.EMERALD), RecipeProvider.conditionsFromItem(Items.EMERALD))
				.offerTo(exporter);
	}
}

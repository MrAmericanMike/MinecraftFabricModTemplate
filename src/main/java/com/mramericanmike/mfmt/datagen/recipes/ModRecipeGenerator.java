package com.mramericanmike.mfmt.datagen.recipes;

import com.mramericanmike.mfmt.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
	public ModRecipeGenerator(FabricDataOutput dataOutput) {
		super(dataOutput);
	}

	@Override
	public void generate(Consumer<RecipeJsonProvider> exporter) {
		// NOTICE on input we must use ' singlequote as it takes a char and not a string
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EMERALD_WAND, 1)
				.pattern("  W")
				.pattern(" E ")
				.pattern("W  ")
				.input('W', ModItems.WAND)
				.input('E', Items.EMERALD)
				.criterion(FabricRecipeProvider.hasItem(ModItems.WAND), FabricRecipeProvider.conditionsFromItem(ModItems.WAND))
				.offerTo(exporter);
	}
}

package com.mramericanmike.mfmt.datagen.advancements;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class CustomAdvancementsGenerator implements Consumer<Consumer<Advancement>> {
	@Override
	public void accept(Consumer<Advancement> advancementConsumer) {

		Advancement emeraldWand = Advancement.Builder.create()
				.parent(Advancement.Builder.create().build(new Identifier("minecraft:recipes/root")))
				.criterion("has_emerald", InventoryChangedCriterion.Conditions.items(Items.EMERALD))
				.criterion("has_the_recipe", RecipeUnlockedCriterion.create(new Identifier("mfmt:emerald_wand")))
				.rewards(AdvancementRewards.Builder.recipe(new Identifier("mfmt:emerald_wand")))
				.build(advancementConsumer, "recipes/emerald_wand");
	}
}

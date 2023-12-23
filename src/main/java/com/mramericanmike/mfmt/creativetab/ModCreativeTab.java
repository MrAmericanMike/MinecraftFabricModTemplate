package com.mramericanmike.mfmt.creativetab;

import com.mramericanmike.mfmt.ModInfo;
import com.mramericanmike.mfmt.items.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModCreativeTab {

	public static final ItemGroup TAB = FabricItemGroup
			.builder()
			.icon(() -> new ItemStack(ModItems.WAND))
			.displayName(Text.translatable("itemGroup.mfmt.creativetab"))
			.build();

	public static void register() {
		Registry.register(Registries.ITEM_GROUP, new Identifier(ModInfo.MOD_ID, "creativetab"), TAB);
	}

	public static void add(Item item) {
		RegistryKey<ItemGroup> TAB_REGISTRY_KEY = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(ModInfo.MOD_ID, "creativetab"));
		ItemGroupEvents.modifyEntriesEvent(TAB_REGISTRY_KEY).register(content -> {
			content.add(item);
		});
	}
}

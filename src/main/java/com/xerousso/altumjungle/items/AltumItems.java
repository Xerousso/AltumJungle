package com.xerousso.altumjungle.items;

import com.xerousso.altumjungle.AltumJungle;
import com.xerousso.altumjungle.blocks.AltumBlocks;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class AltumItems {

    public static final ItemGroup ALTUM_JUNGLE_GROUP = createItemGroup("altum_jungle", () -> new ItemStack(AltumBlocks.OVERGROWN_STONE.asItem()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(AltumJungle.MOD_ID, name), item);
    }

    private static ItemGroup createItemGroup(String name, Supplier<ItemStack> icon) {
        return FabricItemGroupBuilder.build(new Identifier(AltumJungle.MOD_ID, name), icon);
    }

    public static void init() {}

}

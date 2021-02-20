package com.xerousso.altumjungle.items;

import com.xerousso.altumjungle.AltumJungle;
import com.xerousso.altumjungle.blocks.AltumBlocks;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class AltumItems {

    public static final ItemGroup ALTUM_JUNGLE_GROUP = createItemGroup("altum_jungle", () -> new ItemStack(AltumBlocks.OVERGROWN_STONE.asItem()));
    public static final ToolMaterial ALTUMINIUM_TOOL_MATERIAL = new AltuminiumToolMaterial();

    public static final Item JADE = registerItem("jade", new Item(new FabricItemSettings().group(ALTUM_JUNGLE_GROUP)));
    public static final Item ALTUMINIUM_INGOT = registerItem("altuminium_ingot", new Item(new FabricItemSettings().group(ALTUM_JUNGLE_GROUP)));

    public static final Item ALTUMINIUM_SWORD = registerItem("altuminium_sword", new SwordItem(ALTUMINIUM_TOOL_MATERIAL, 3,
            -2.4f, new FabricItemSettings().group(ALTUM_JUNGLE_GROUP)));
    public static final Item ALTUMINIUM_SHOVEL = registerItem("altuminium_shovel", new ShovelItem(ALTUMINIUM_TOOL_MATERIAL, 1.5f,
            -3, new FabricItemSettings().group(ALTUM_JUNGLE_GROUP)));
    public static final Item ALTUMINIUM_PICKAXE = registerItem("altuminium_pickaxe", new AltumPickaxeItem(ALTUMINIUM_TOOL_MATERIAL, 1,
            -2.8f, new FabricItemSettings().group(ALTUM_JUNGLE_GROUP)));
    public static final Item ALTUMINIUM_AXE = registerItem("altuminium_axe", new AltumAxeItem(ALTUMINIUM_TOOL_MATERIAL, 5,
            -3, new FabricItemSettings().group(ALTUM_JUNGLE_GROUP)));
    public static final Item ALTUMINIUM_HOE = registerItem("altuminium_hoe", new AltumHoeItem(ALTUMINIUM_TOOL_MATERIAL, -4,
            0, new FabricItemSettings().group(ALTUM_JUNGLE_GROUP)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(AltumJungle.MOD_ID, name), item);
    }

    private static ItemGroup createItemGroup(String name, Supplier<ItemStack> icon) {
        return FabricItemGroupBuilder.build(new Identifier(AltumJungle.MOD_ID, name), icon);
    }

    public static void init() {}

}

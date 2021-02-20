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
    public static final ToolMaterial JADE_TOOL_MATERIAL = new JadeToolMaterial();

    public static final Item JADE = registerItem("jade", new Item(new FabricItemSettings().group(ALTUM_JUNGLE_GROUP)));

    public static final Item JADE_SWORD = registerItem("jade_sword", new SwordItem(JADE_TOOL_MATERIAL, 3,
            -2.4f, new FabricItemSettings().group(ALTUM_JUNGLE_GROUP)));
    public static final Item JADE_SHOVEL = registerItem("jade_shovel", new ShovelItem(JADE_TOOL_MATERIAL, 1.5f,
            -3, new FabricItemSettings().group(ALTUM_JUNGLE_GROUP)));
    public static final Item JADE_PICKAXE = registerItem("jade_pickaxe", new AltumPickaxeItem(JADE_TOOL_MATERIAL, 1,
            -2.8f, new FabricItemSettings().group(ALTUM_JUNGLE_GROUP)));
    public static final Item JADE_AXE = registerItem("jade_axe", new AltumAxeItem(JADE_TOOL_MATERIAL, 5,
            -3, new FabricItemSettings().group(ALTUM_JUNGLE_GROUP)));
    public static final Item JADE_HOE = registerItem("jade_hoe", new AltumHoeItem(JADE_TOOL_MATERIAL, -3,
            0, new FabricItemSettings().group(ALTUM_JUNGLE_GROUP)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(AltumJungle.MOD_ID, name), item);
    }

    private static ItemGroup createItemGroup(String name, Supplier<ItemStack> icon) {
        return FabricItemGroupBuilder.build(new Identifier(AltumJungle.MOD_ID, name), icon);
    }

    public static void init() {}

}

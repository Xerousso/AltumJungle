package com.xerousso.altumjungle.blocks;

import com.xerousso.altumjungle.AltumJungle;
import com.xerousso.altumjungle.blocks.environment.AltumGrassBlock;
import com.xerousso.altumjungle.items.AltumItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AltumBlocks {

    public static final Block OVERGROWN_STONE = registerBlockWithGroup("overgrown_stone", new AltumGrassBlock(
            FabricBlockSettings.of(Material.STONE, MapColor.PALE_GREEN).ticksRandomly().strength(1.8f, 7f).sounds(BlockSoundGroup.STONE), Blocks.STONE),
            AltumItems.ALTUM_JUNGLE_GROUP);

    private static Block registerBlock(String name, Block block) {
        Registry.register(Registry.ITEM, new Identifier(AltumJungle.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
        return Registry.register(Registry.BLOCK, new Identifier(AltumJungle.MOD_ID, name), block);
    }

    private static Block registerBlockWithGroup(String name, Block block, ItemGroup group) {
        Registry.register(Registry.ITEM, new Identifier(AltumJungle.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(group)));
        return Registry.register(Registry.BLOCK, new Identifier(AltumJungle.MOD_ID, name), block);
    }

    private static Block registerBlockWithSettings(String name, Block block, Item.Settings settings) {
        Registry.register(Registry.ITEM, new Identifier(AltumJungle.MOD_ID, name), new BlockItem(block, settings));
        return Registry.register(Registry.BLOCK, new Identifier(AltumJungle.MOD_ID, name), block);
    }

    public static void init() {}

}

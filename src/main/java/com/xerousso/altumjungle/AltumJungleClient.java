package com.xerousso.altumjungle;

import com.xerousso.altumjungle.blocks.AltumBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.Item;
import net.minecraft.world.level.ColorResolver;

public class AltumJungleClient implements ClientModInitializer {

    public static final int GRASS_COLOR = GrassColors.getColor(0.5D, 1.0D);

    @Override
    public void onInitializeClient() {
        applyRenderLayers();
        registerColorProviders();
    }

    private static void registerColorProviders() {
        registerBlockColorProviderWithColorResolver(AltumBlocks.OVERGROWN_STONE, BiomeColors.GRASS_COLOR);
        registerItemColorProvider(AltumBlocks.OVERGROWN_STONE.asItem(), (stack, tintIndex) -> GRASS_COLOR);
    }

    private static void applyRenderLayers() {
        applyRenderLayer(AltumBlocks.OVERGROWN_STONE, RenderLayer.getCutout());
    }


    private static void registerBlockColorProvider(Block block, BlockColorProvider provider) {
        ColorProviderRegistry.BLOCK.register(provider, block);
    }

    private static void registerBlockColorProviderWithColorResolver(Block block, ColorResolver resolver) {
        registerBlockColorProvider(block, (state, world, pos, tintIndex) -> world.getColor(pos, resolver));
    }

    private static void registerItemColorProvider(Item item, ItemColorProvider provider) {
        ColorProviderRegistry.ITEM.register(provider, item);
    }

    private static void applyRenderLayer(Block block, RenderLayer layer) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, layer);
    }

}

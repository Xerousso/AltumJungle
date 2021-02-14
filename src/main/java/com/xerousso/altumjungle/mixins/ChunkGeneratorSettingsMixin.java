package com.xerousso.altumjungle.mixins;

import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ChunkGeneratorSettings.class)
public class ChunkGeneratorSettingsMixin {

    @ModifyConstant(method = "createSurfaceSettings", constant = @Constant(intValue = -64))
    private static int changeOverworldChunkGeneratorSurfaceSettingsMinimumY(int value) {
        return -192;
    }

    @ModifyConstant(method = "createSurfaceSettings", constant = @Constant(intValue = 384))
    private static int changeOverworldChunkGeneratorSurfaceSettingsHeight(int value) {
        return 512;
    }

    @ModifyConstant(method = "createUndergroundSettings", constant = @Constant(intValue = -64))
    private static int changeOverworldChunkGeneratorUndergroundSettingsMinimumY(int value) {
        return -192;
    }

    @ModifyConstant(method = "createUndergroundSettings", constant = @Constant(intValue = 384))
    private static int changeOverworldChunkGeneratorUndergroundSettingsHeight(int value) {
        return 512;
    }

}

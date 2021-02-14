package com.xerousso.altumjungle.mixins;

import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(DimensionType.class)
public class DimensionTypeMixin {

    @ModifyConstant(method = "<clinit>", constant = @Constant(intValue = -64))
    private static int changeOverworldMinimumY(int value) {
        return -192;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(intValue = 384))
    private static int changeOverworldHeight(int value) {
        return 512;
    }

}

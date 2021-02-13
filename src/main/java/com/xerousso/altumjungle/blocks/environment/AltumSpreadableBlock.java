package com.xerousso.altumjungle.blocks.environment;

import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;

import java.util.Random;

public class AltumSpreadableBlock extends SnowyBlock {

    private Block replacementBlock;

    protected AltumSpreadableBlock(Settings settings, Block replacementBlock) {
        super(settings);

        this.replacementBlock = replacementBlock;
    }

    private static boolean canSurvive(BlockState state, WorldView world, BlockPos pos) {
        BlockPos abovePosition = pos.up();
        BlockState aboveState = world.getBlockState(abovePosition);

        if (aboveState.isOf(Blocks.SNOW) && aboveState.get(SnowBlock.LAYERS) == 1) return true;
        else if (aboveState.getFluidState().getLevel() == 8) return false;
        else return ChunkLightProvider.getRealisticOpacity(world, state, pos, aboveState, abovePosition, Direction.UP,
                    aboveState.getOpacity(world, abovePosition)) < world.getMaxLightLevel();
    }

    private static boolean canSpread(BlockState state, WorldView world, BlockPos pos) {
        return canSurvive(state, world, pos) && !world.getFluidState(pos.up()).isIn(FluidTags.WATER);
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!canSurvive(state, world, pos)) world.setBlockState(pos, replacementBlock.getDefaultState());
        else {
            if (world.getLightLevel(pos.up()) >= 9) {
                BlockState spreadableBlockState = this.getDefaultState();

                for(int i = 0; i < 4; ++i) {
                    BlockPos targetPosition = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);

                    if (world.getBlockState(targetPosition).isOf(replacementBlock) && canSpread(spreadableBlockState, world, targetPosition))
                        world.setBlockState(targetPosition, spreadableBlockState.with(SNOWY, world.getBlockState(targetPosition.up()).isOf(Blocks.SNOW)));
                }
            }
        }
    }

}

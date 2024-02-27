package com.movtery.leafpile.mixin;

import com.movtery.leafpile.ModProperties;
import net.minecraft.block.*;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.movtery.leafpile.LeafPile.getConfig;
import static com.movtery.leafpile.block.BlockMatching.getLeavesMatchDeadLeafPile;
import static com.movtery.leafpile.block.BlockMatching.getLeavesMatchingLeafPileBlock;

@Mixin(LeavesBlock.class)
public abstract class LeavesBlockMixin extends Block
        implements Waterloggable {
    @Unique
    private static final DirectionProperty LEAF_PILE_FACING = Properties.HORIZONTAL_FACING;
    @Unique
    private static final IntProperty LEAF_PILE_FALLEN_LEAVES_AMOUNT = ModProperties.FALLEN_LEAVES_AMOUNT;

    @Unique
    private static final BooleanProperty LEAF_PILE_WATERLOGGED = Properties.WATERLOGGED;

    @Unique
    private static final IntProperty WATER_LEVEL = Properties.LEVEL_15;
    @Shadow
    @Final
    public static IntProperty DISTANCE;
    @Shadow
    @Final
    public static BooleanProperty PERSISTENT;
    @Unique
    java.util.Random r = new java.util.Random();

    public LeavesBlockMixin(Settings settings) {
        super(settings);
    }

    @Shadow
    protected abstract boolean shouldDecay(BlockState state);

    @Inject(method = "hasRandomTicks", at = @At("HEAD"), cancellable = true)
    private void hasRandomTicks(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(!state.get(PERSISTENT));
    }

    @Inject(method = "randomTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/LeavesBlock;shouldDecay(Lnet/minecraft/block/BlockState;)Z"), cancellable = true)
    private void shouldDecay(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        ci.cancel();

        if (state.get(DISTANCE) == 7 && this.shouldDecay(state)) {
            spawnLeafPileBlock(world, pos, state, 190);
            LeavesBlock.dropStacks(state, world, pos);
            world.removeBlock(pos, false);
        }
    }

    @Inject(method = "randomTick", at = @At("HEAD"))
    private void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        spawnLeafPileBlock(world, pos, state, 5);
    }

    // 生成落叶
    @Unique
    private void spawnLeafPileBlock(World world, BlockPos pos, BlockState state, int rand) {
        BlockState matchingBlock = deadLeafPileJudgment(state, 80);
        if (matchingBlock == null) return;

        BlockPos tempPos = new BlockPos(pos);
        if (world.getBlockState(tempPos.down()).isOf(Blocks.AIR) && (r.nextInt(0, 200) < rand)) { // 树叶下方必须为空气 & 概率不满足则不生成落叶
            tempPos = tempPos.add(r.nextInt(-2, 2), -1, r.nextInt(-2, 2));
            for (int i = 0; ; i++) { // 以此坐标为最高点向下寻找12格内最高的非空气方块(非水方块)
                if (!world.getBlockState(tempPos.add(0, -i, 0)).isOf(Blocks.AIR) && !world.getBlockState(tempPos.add(0, -i, 0)).isOf(Blocks.WATER)) {
                    tempPos = tempPos.add(0, -i, 0);
                    break;
                } else if (i == 11) {
                    return;
                }
            }
            if (getConfig().getOptions().leafPile_doNotPlaceOnTop.contains(Registries.BLOCK.getId(world.getBlockState(tempPos).getBlock()).toString())) return;
            BlockState tempBlockState = world.getBlockState(tempPos.add(0, 1, 0));

            // 预生成位置处必须为空气方块 & 预生成位置下方方块必须为固体方块
            if (tempBlockState.isOf(Blocks.AIR) && world.getBlockState(tempPos).isSolidBlock(world, tempPos)) {
                world.setBlockState(tempPos.up(), matchingBlock.with(LEAF_PILE_FALLEN_LEAVES_AMOUNT, r.nextInt(1, 4)).with(LEAF_PILE_FACING, getRandomDirections(r.nextInt(1, 4))));
            } else if (tempBlockState.isOf(Blocks.WATER) && (tempBlockState.get(WATER_LEVEL) == 0) && world.getBlockState(tempPos).isSolidBlock(world, tempPos)) { // 如果有水，则在水中生成落叶 & 水的等级必须为0 & 水的下方必须为固体方块
                world.setBlockState(tempPos.up(), matchingBlock.with(LEAF_PILE_WATERLOGGED, true).with(LEAF_PILE_FALLEN_LEAVES_AMOUNT, r.nextInt(1, 4)).with(LEAF_PILE_FACING, getRandomDirections(r.nextInt(1, 4))));
            }
        }
    }

    @Unique
    private Direction getRandomDirections(int rand) {
        return switch (rand) {
            case (1) -> Direction.EAST;
            case (2) -> Direction.SOUTH;
            case (3) -> Direction.WEST;
            default -> Direction.NORTH;
        };
    }

    @Unique
    private BlockState deadLeafPileJudgment(BlockState state, int rand) {
        Block block;
        if (r.nextInt(0, 100) < rand) {
            block = getLeavesMatchingLeafPileBlock(state.getBlock());
        } else {
            block = getLeavesMatchDeadLeafPile(state.getBlock());
        }
        return block.getDefaultState();
    }
}

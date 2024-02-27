package com.movtery.leafpile.block;

import com.movtery.leafpile.ModProperties;
import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.BiFunction;

import static com.movtery.leafpile.LeafPile.getConfig;
import static com.movtery.leafpile.block.BlockMatching.getDeadLeafPileBlock;
import static com.movtery.leafpile.block.BlockMatching.getLeafPileBlockMatchLeaves;

public class LeafPileBlock
        extends PlantBlock
        implements Fertilizable, Waterloggable {

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final IntProperty FALLEN_LEAVES_AMOUNT = ModProperties.FALLEN_LEAVES_AMOUNT;
    public static final BooleanProperty NEVER_DEAD = ModProperties.NEVER_DEAD;
    public static final BooleanProperty PERSISTENT = Properties.PERSISTENT;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    private static final BiFunction<Direction, Integer, VoxelShape> FACING_AND_AMOUNT_TO_SHAPE = Util.memoize((facing, flowerAmount) -> {
        VoxelShape[] voxelShapes = new VoxelShape[]{Block.createCuboidShape(8.0, 0.0, 8.0, 16.0, 1.0, 16.0), Block.createCuboidShape(8.0, 0.0, 0.0, 16.0, 1.0, 8.0), Block.createCuboidShape(0.0, 0.0, 0.0, 8.0, 1.0, 8.0), Block.createCuboidShape(0.0, 0.0, 8.0, 8.0, 1.0, 16.0)};
        VoxelShape voxelShape = VoxelShapes.empty();
        for (int i = 0; i < flowerAmount; ++i) {
            int j = Math.floorMod(i - facing.getHorizontal(), 4);
            voxelShape = VoxelShapes.union(voxelShape, voxelShapes[j]);
        }
        return voxelShape.asCuboid();
    });

    public LeafPileBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(FALLEN_LEAVES_AMOUNT, 1).with(NEVER_DEAD, false).with(PERSISTENT, false).with(WATERLOGGED, false));
    }

    private static boolean isLeafNearby(WorldView world, BlockPos pos, BlockState state) {
        for (BlockPos blockPos : BlockPos.iterate(pos.add(-2, 1, -2), pos.add(2, 12, 2))) {
            if (!world.getBlockState(blockPos).isOf(getLeafPileBlockMatchLeaves(state.getBlock()))) continue;
            return true;
        }

        return false;
    }

    private static boolean isWaterNearby(WorldView world, BlockPos pos, java.util.Random r, int rand) {
        for (BlockPos blockPos : BlockPos.iterate(pos.add(-3, -1, -3), pos.add(3, 1, 3))) {
            if (!world.isWater(blockPos)) continue;
            if (r.nextInt(0, 1000) < rand) return true;
            break;
        }

        return false;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, FALLEN_LEAVES_AMOUNT, NEVER_DEAD, PERSISTENT, WATERLOGGED);
    }

    @Override
    protected boolean canPlantOnTop(BlockState state, BlockView world, BlockPos pos) {
        if (state.isOf(this) || getConfig().getOptions().leafPile_doNotPlaceOnTop.contains(Registries.BLOCK.getId(state.getBlock()).toString()))
            return false;
        return state.isSolidBlock(world, pos);
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
//        if (!context.shouldCancelInteraction() && context.getStack().isOf(this.asItem()) && state.get(FALLEN_LEAVES_AMOUNT) < 5) {
//            return true;
//        }
//        return super.canReplace(state, context);
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        int i = state.get(FALLEN_LEAVES_AMOUNT);
        if (i < 5) {
            world.setBlockState(pos, state.with(FALLEN_LEAVES_AMOUNT, i + 1), Block.NOTIFY_LISTENERS);
        } else {
            FlowerbedBlock.dropStack(world, pos, new ItemStack(this));
        }
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return FACING_AND_AMOUNT_TO_SHAPE.apply(state.get(FACING), state.get(FALLEN_LEAVES_AMOUNT));
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos());
        if (blockState.isOf(this)) {
            return blockState.with(FALLEN_LEAVES_AMOUNT, Math.min(5, blockState.get(FALLEN_LEAVES_AMOUNT) + 1));
        }
        return this.getDefaultState()
                .with(NEVER_DEAD, Objects.requireNonNull(ctx.getPlayer()).isSneaking())
                .with(PERSISTENT, true)
                .with(FACING, ctx.getHorizontalPlayerFacing().getOpposite())
                .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return false;
    }

    public boolean isDeadLeafPileBlock(BlockState state) {
        return getDeadLeafPileBlock().contains(state.getBlock());
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        java.util.Random r = new java.util.Random(); // 自行生成随机数（可控范围）
        int i = state.get(FALLEN_LEAVES_AMOUNT);
        boolean isDeadLeafPileBlock = isDeadLeafPileBlock(state);
        if (!isDeadLeafPileBlock) { // 检测此方块是否不为 干枯的落叶
            if (i < 5 && isLeafNearby(world, pos, state) && r.nextInt(0, 200) < 5) { // 有对应树叶在附近，可增加落叶数量
                addFallenLeaves(pos, state, world, i);
            }

            if (!state.get(NEVER_DEAD) && !isWaterNearby(world, pos, r, 800) && r.nextInt(0, 200) < 3) { // 干枯逻辑
                world.setBlockState(pos, BlockMatching.getLeafPileMatchDeadLeafPile(state.getBlock()).getDefaultState().with(FALLEN_LEAVES_AMOUNT, i).with(PERSISTENT, state.get(PERSISTENT)).with(FACING, state.get(FACING)).with(WATERLOGGED, state.get(WATERLOGGED)));
            }
        } else if (i < 5 && isLeafNearby(world, pos, state) && r.nextInt(0, 200) < 2) { // (干枯的落叶) 有对应树叶在附近，可增加落叶数量
            addFallenLeaves(pos, state, world, i);
        }

        if (isDeadLeafPileBlock && !state.get(PERSISTENT) && r.nextInt(0, 200) < 5) { // 干枯的落叶消失
            world.removeBlock(pos, false);
        }
    }

    private void addFallenLeaves(BlockPos pos, BlockState state, World world, int amount) {
        world.setBlockState(pos, state.with(FALLEN_LEAVES_AMOUNT, amount + 1), Block.NOTIFY_LISTENERS);
    }
}

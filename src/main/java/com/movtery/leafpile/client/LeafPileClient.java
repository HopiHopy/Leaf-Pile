package com.movtery.leafpile.client;

import com.movtery.leafpile.client.color.ModColors;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.render.RenderLayer;

import static com.movtery.leafpile.block.ModBlocks.*;

public class LeafPileClient implements ClientModInitializer {
    private static void blockRenderLayerMap(Block block) {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), block);
    }

    @Override
    public void onInitializeClient() {
        // 透明渲染
        blockRenderLayerMap(OAK_LEAF_PILE);
        blockRenderLayerMap(SPRUCE_LEAF_PILE);
        blockRenderLayerMap(BIRCH_LEAF_PILE);
        blockRenderLayerMap(JUNGLE_LEAF_PILE);
        blockRenderLayerMap(ACACIA_LEAF_PILE);
        blockRenderLayerMap(DARK_OAK_LEAF_PILE);
        blockRenderLayerMap(MANGROVE_LEAF_PILE);
        blockRenderLayerMap(CHERRY_LEAF_PILE);
        blockRenderLayerMap(AZALEA_LEAF_PILE);
        blockRenderLayerMap(DEAD_OAK_LEAF_PILE);
        blockRenderLayerMap(DEAD_SPRUCE_LEAF_PILE);
        blockRenderLayerMap(DEAD_BIRCH_LEAF_PILE);
        blockRenderLayerMap(DEAD_JUNGLE_LEAF_PILE);
        blockRenderLayerMap(DEAD_ACACIA_LEAF_PILE);
        blockRenderLayerMap(DEAD_DARK_OAK_LEAF_PILE);
        blockRenderLayerMap(DEAD_MANGROVE_LEAF_PILE);
        blockRenderLayerMap(DEAD_CHERRY_LEAF_PILE);
        blockRenderLayerMap(DEAD_AZALEA_LEAF_PILE);

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (world == null || pos == null) {
                return FoliageColors.getDefaultColor();
            }
            return BiomeColors.getFoliageColor(world, pos);
        }, OAK_LEAF_PILE, JUNGLE_LEAF_PILE, ACACIA_LEAF_PILE, DARK_OAK_LEAF_PILE, MANGROVE_LEAF_PILE);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (world == null || pos == null) {
                return FoliageColors.getDefaultColor();
            }
            return ModColors.getDeadColor();
        }, DEAD_OAK_LEAF_PILE, DEAD_ACACIA_LEAF_PILE, DEAD_DARK_OAK_LEAF_PILE, DEAD_MANGROVE_LEAF_PILE);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> FoliageColors.getSpruceColor(), SPRUCE_LEAF_PILE);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> FoliageColors.getBirchColor(), BIRCH_LEAF_PILE);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> ModColors.getDeadSpruceColor(), DEAD_SPRUCE_LEAF_PILE);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> ModColors.getDeadBirchColor(), DEAD_BIRCH_LEAF_PILE);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> ModColors.getDeadJungleColor(), DEAD_JUNGLE_LEAF_PILE);
    }
}

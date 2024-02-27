package com.movtery.leafpile.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;

import static com.movtery.leafpile.ModRegistry.blockRegistry;
import static com.movtery.leafpile.ModRegistry.flammableBlockRegistry;

public class ModBlocks {
    public static final Block OAK_LEAF_PILE = new LeafPileBlock(createLeafPileBlock(BlockSoundGroup.GRASS));
    public static final Block SPRUCE_LEAF_PILE = new LeafPileBlock(createLeafPileBlock(BlockSoundGroup.GRASS));
    public static final Block BIRCH_LEAF_PILE = new LeafPileBlock(createLeafPileBlock(BlockSoundGroup.GRASS));
    public static final Block JUNGLE_LEAF_PILE = new LeafPileBlock(createLeafPileBlock(BlockSoundGroup.GRASS));
    public static final Block ACACIA_LEAF_PILE = new LeafPileBlock(createLeafPileBlock(BlockSoundGroup.GRASS));
    public static final Block DARK_OAK_LEAF_PILE = new LeafPileBlock(createLeafPileBlock(BlockSoundGroup.GRASS));
    public static final Block MANGROVE_LEAF_PILE = new LeafPileBlock(createLeafPileBlock(BlockSoundGroup.GRASS));
    public static final Block CHERRY_LEAF_PILE = new LeafPileBlock(createLeafPileBlock(BlockSoundGroup.CHERRY_LEAVES));
    public static final Block AZALEA_LEAF_PILE = new LeafPileBlock(createLeafPileBlock(BlockSoundGroup.AZALEA));
    public static final Block DEAD_OAK_LEAF_PILE = new LeafPileBlock(createLeafPileBlock(BlockSoundGroup.GRASS));
    public static final Block DEAD_SPRUCE_LEAF_PILE = new LeafPileBlock(createLeafPileBlock(BlockSoundGroup.GRASS));
    public static final Block DEAD_BIRCH_LEAF_PILE = new LeafPileBlock(createLeafPileBlock(BlockSoundGroup.GRASS));
    public static final Block DEAD_JUNGLE_LEAF_PILE = new LeafPileBlock(createLeafPileBlock(BlockSoundGroup.GRASS));
    public static final Block DEAD_ACACIA_LEAF_PILE = new LeafPileBlock(createLeafPileBlock(BlockSoundGroup.GRASS));
    public static final Block DEAD_DARK_OAK_LEAF_PILE = new LeafPileBlock(createLeafPileBlock(BlockSoundGroup.GRASS));
    public static final Block DEAD_MANGROVE_LEAF_PILE = new LeafPileBlock(createLeafPileBlock(BlockSoundGroup.GRASS));
    public static final Block DEAD_CHERRY_LEAF_PILE = new LeafPileBlock(createLeafPileBlock(BlockSoundGroup.CHERRY_LEAVES));
    public static final Block DEAD_AZALEA_LEAF_PILE = new LeafPileBlock(createLeafPileBlock(BlockSoundGroup.AZALEA));

    // Registry Blocks
    public static void registry() {
        blockRegistry("oak_leaf_pile", OAK_LEAF_PILE);
        blockRegistry("spruce_leaf_pile", SPRUCE_LEAF_PILE);
        blockRegistry("birch_leaf_pile", BIRCH_LEAF_PILE);
        blockRegistry("jungle_leaf_pile", JUNGLE_LEAF_PILE);
        blockRegistry("acacia_leaf_pile", ACACIA_LEAF_PILE);
        blockRegistry("dark_oak_leaf_pile", DARK_OAK_LEAF_PILE);
        blockRegistry("mangrove_leaf_pile", MANGROVE_LEAF_PILE);
        blockRegistry("cherry_leaf_pile", CHERRY_LEAF_PILE);
        blockRegistry("azalea_leaf_pile", AZALEA_LEAF_PILE);
        blockRegistry("dead_oak_leaf_pile", DEAD_OAK_LEAF_PILE);
        blockRegistry("dead_spruce_leaf_pile", DEAD_SPRUCE_LEAF_PILE);
        blockRegistry("dead_birch_leaf_pile", DEAD_BIRCH_LEAF_PILE);
        blockRegistry("dead_jungle_leaf_pile", DEAD_JUNGLE_LEAF_PILE);
        blockRegistry("dead_acacia_leaf_pile", DEAD_ACACIA_LEAF_PILE);
        blockRegistry("dead_dark_oak_leaf_pile", DEAD_DARK_OAK_LEAF_PILE);
        blockRegistry("dead_mangrove_leaf_pile", DEAD_MANGROVE_LEAF_PILE);
        blockRegistry("dead_cherry_leaf_pile", DEAD_CHERRY_LEAF_PILE);
        blockRegistry("dead_azalea_leaf_pile", DEAD_AZALEA_LEAF_PILE);

        flammableBlockRegistry(OAK_LEAF_PILE, 60, 100);
        flammableBlockRegistry(SPRUCE_LEAF_PILE, 60, 100);
        flammableBlockRegistry(BIRCH_LEAF_PILE, 60, 100);
        flammableBlockRegistry(JUNGLE_LEAF_PILE, 60, 100);
        flammableBlockRegistry(ACACIA_LEAF_PILE, 60, 100);
        flammableBlockRegistry(DARK_OAK_LEAF_PILE, 60, 100);
        flammableBlockRegistry(MANGROVE_LEAF_PILE, 60, 100);
        flammableBlockRegistry(CHERRY_LEAF_PILE, 60, 100);
        flammableBlockRegistry(AZALEA_LEAF_PILE, 60, 100);
        flammableBlockRegistry(DEAD_OAK_LEAF_PILE, 90, 140);
        flammableBlockRegistry(DEAD_SPRUCE_LEAF_PILE, 90, 140);
        flammableBlockRegistry(DEAD_BIRCH_LEAF_PILE, 90, 140);
        flammableBlockRegistry(DEAD_JUNGLE_LEAF_PILE, 90, 140);
        flammableBlockRegistry(DEAD_ACACIA_LEAF_PILE, 90, 140);
        flammableBlockRegistry(DEAD_DARK_OAK_LEAF_PILE, 90, 140);
        flammableBlockRegistry(DEAD_MANGROVE_LEAF_PILE, 90, 140);
        flammableBlockRegistry(DEAD_CHERRY_LEAF_PILE, 90, 140);
        flammableBlockRegistry(DEAD_AZALEA_LEAF_PILE, 90, 140);
    }

    private static FabricBlockSettings createLeafPileBlock(BlockSoundGroup group) {
        return FabricBlockSettings.create().mapColor(MapColor.DARK_GREEN).noCollision().nonOpaque().sounds(group).pistonBehavior(PistonBehavior.DESTROY);
    }
}

package com.movtery.leafpile.block;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.movtery.leafpile.block.ModBlocks.*;

public class BlockMatching {
    private static final ArrayList<Block> DEAD_LEAF_PILE_BLOCK = new ArrayList<>();
    private static final Map<Block, Block> LEAF_PILE_MATCH_LEAVES = new HashMap<>();
    private static final Map<Block, Block> LEAVES_MATCH_LEAF_PILE = new HashMap<>();
    private static final Map<Block, Block> LEAF_PILE_MATCH_DEAD_LEAF_PILE = new HashMap<>();
    private static final Map<Block, Block> LEAVES_MATCH_DEAD_LEAF_PILE = new HashMap<>();

    public static Block getLeafPileBlockMatchLeaves(Block block) {
        return LEAF_PILE_MATCH_LEAVES.get(block);
    }

    public static void setLeafPileBlockMatchLeavesMap(Block keyBlock, Block valueBlock) {
        LEAF_PILE_MATCH_LEAVES.put(keyBlock, valueBlock);
    }

    public static Block getLeavesMatchingLeafPileBlock(Block block) {
        return LEAVES_MATCH_LEAF_PILE.get(block);
    }

    public static void setLeavesMatchingLeafPileBlockMap(Block keyBlock, Block valueBlock) {
        LEAVES_MATCH_LEAF_PILE.put(keyBlock, valueBlock);
    }

    public static Block getLeafPileMatchDeadLeafPile(Block block) {
        return LEAF_PILE_MATCH_DEAD_LEAF_PILE.get(block);
    }

    public static void setLeafPileMatchDeadLeafPileMap(Block keyBlock, Block valueBlock) {
        LEAF_PILE_MATCH_DEAD_LEAF_PILE.put(keyBlock, valueBlock);
    }

    public static Block getLeavesMatchDeadLeafPile(Block block) {
        return LEAVES_MATCH_DEAD_LEAF_PILE.get(block);
    }

    public static void setLeavesMatchDeadLeafPileMap(Block keyBlock, Block valueBlock) {
        LEAVES_MATCH_DEAD_LEAF_PILE.put(keyBlock, valueBlock);
    }

    public static ArrayList<Block> getDeadLeafPileBlock() {
        return DEAD_LEAF_PILE_BLOCK;
    }

    public static void setDeadLeafPileBlock(Block witheredLeafPileBlock) {
        BlockMatching.DEAD_LEAF_PILE_BLOCK.add(witheredLeafPileBlock);
    }

    public static void registry() {
        setLeafPileBlockMatchLeavesMap(OAK_LEAF_PILE, Blocks.OAK_LEAVES);
        setLeafPileBlockMatchLeavesMap(SPRUCE_LEAF_PILE, Blocks.SPRUCE_LEAVES);
        setLeafPileBlockMatchLeavesMap(BIRCH_LEAF_PILE, Blocks.BIRCH_LEAVES);
        setLeafPileBlockMatchLeavesMap(JUNGLE_LEAF_PILE, Blocks.JUNGLE_LEAVES);
        setLeafPileBlockMatchLeavesMap(ACACIA_LEAF_PILE, Blocks.ACACIA_LEAVES);
        setLeafPileBlockMatchLeavesMap(DARK_OAK_LEAF_PILE, Blocks.DARK_OAK_LEAVES);
        setLeafPileBlockMatchLeavesMap(MANGROVE_LEAF_PILE, Blocks.MANGROVE_LEAVES);
        setLeafPileBlockMatchLeavesMap(CHERRY_LEAF_PILE, Blocks.CHERRY_LEAVES);
        setLeafPileBlockMatchLeavesMap(AZALEA_LEAF_PILE, Blocks.AZALEA_LEAVES);
        setLeafPileBlockMatchLeavesMap(DEAD_OAK_LEAF_PILE, Blocks.OAK_LEAVES);
        setLeafPileBlockMatchLeavesMap(DEAD_SPRUCE_LEAF_PILE, Blocks.SPRUCE_LEAVES);
        setLeafPileBlockMatchLeavesMap(DEAD_BIRCH_LEAF_PILE, Blocks.BIRCH_LEAVES);
        setLeafPileBlockMatchLeavesMap(DEAD_JUNGLE_LEAF_PILE, Blocks.JUNGLE_LEAVES);
        setLeafPileBlockMatchLeavesMap(DEAD_ACACIA_LEAF_PILE, Blocks.ACACIA_LEAVES);
        setLeafPileBlockMatchLeavesMap(DEAD_DARK_OAK_LEAF_PILE, Blocks.DARK_OAK_LEAVES);
        setLeafPileBlockMatchLeavesMap(DEAD_MANGROVE_LEAF_PILE, Blocks.MANGROVE_LEAVES);
        setLeafPileBlockMatchLeavesMap(DEAD_CHERRY_LEAF_PILE, Blocks.CHERRY_LEAVES);
        setLeafPileBlockMatchLeavesMap(DEAD_AZALEA_LEAF_PILE, Blocks.AZALEA_LEAVES);

        setLeavesMatchingLeafPileBlockMap(Blocks.OAK_LEAVES, OAK_LEAF_PILE);
        setLeavesMatchingLeafPileBlockMap(Blocks.SPRUCE_LEAVES, SPRUCE_LEAF_PILE);
        setLeavesMatchingLeafPileBlockMap(Blocks.BIRCH_LEAVES, BIRCH_LEAF_PILE);
        setLeavesMatchingLeafPileBlockMap(Blocks.JUNGLE_LEAVES, JUNGLE_LEAF_PILE);
        setLeavesMatchingLeafPileBlockMap(Blocks.ACACIA_LEAVES, ACACIA_LEAF_PILE);
        setLeavesMatchingLeafPileBlockMap(Blocks.DARK_OAK_LEAVES, DARK_OAK_LEAF_PILE);
        setLeavesMatchingLeafPileBlockMap(Blocks.MANGROVE_LEAVES, MANGROVE_LEAF_PILE);
        setLeavesMatchingLeafPileBlockMap(Blocks.CHERRY_LEAVES, CHERRY_LEAF_PILE);
        setLeavesMatchingLeafPileBlockMap(Blocks.AZALEA_LEAVES, AZALEA_LEAF_PILE);
        setLeavesMatchingLeafPileBlockMap(Blocks.FLOWERING_AZALEA_LEAVES, AZALEA_LEAF_PILE);

        setLeafPileMatchDeadLeafPileMap(OAK_LEAF_PILE, DEAD_OAK_LEAF_PILE);
        setLeafPileMatchDeadLeafPileMap(SPRUCE_LEAF_PILE, DEAD_SPRUCE_LEAF_PILE);
        setLeafPileMatchDeadLeafPileMap(BIRCH_LEAF_PILE, DEAD_BIRCH_LEAF_PILE);
        setLeafPileMatchDeadLeafPileMap(JUNGLE_LEAF_PILE, DEAD_JUNGLE_LEAF_PILE);
        setLeafPileMatchDeadLeafPileMap(ACACIA_LEAF_PILE, DEAD_ACACIA_LEAF_PILE);
        setLeafPileMatchDeadLeafPileMap(DARK_OAK_LEAF_PILE, DEAD_DARK_OAK_LEAF_PILE);
        setLeafPileMatchDeadLeafPileMap(MANGROVE_LEAF_PILE, DEAD_MANGROVE_LEAF_PILE);
        setLeafPileMatchDeadLeafPileMap(CHERRY_LEAF_PILE, DEAD_CHERRY_LEAF_PILE);
        setLeafPileMatchDeadLeafPileMap(AZALEA_LEAF_PILE, DEAD_AZALEA_LEAF_PILE);

        setLeavesMatchDeadLeafPileMap(Blocks.OAK_LEAVES, DEAD_OAK_LEAF_PILE);
        setLeavesMatchDeadLeafPileMap(Blocks.SPRUCE_LEAVES, DEAD_SPRUCE_LEAF_PILE);
        setLeavesMatchDeadLeafPileMap(Blocks.BIRCH_LEAVES, DEAD_BIRCH_LEAF_PILE);
        setLeavesMatchDeadLeafPileMap(Blocks.JUNGLE_LEAVES, DEAD_JUNGLE_LEAF_PILE);
        setLeavesMatchDeadLeafPileMap(Blocks.ACACIA_LEAVES, DEAD_ACACIA_LEAF_PILE);
        setLeavesMatchDeadLeafPileMap(Blocks.DARK_OAK_LEAVES, DEAD_DARK_OAK_LEAF_PILE);
        setLeavesMatchDeadLeafPileMap(Blocks.MANGROVE_LEAVES, DEAD_MANGROVE_LEAF_PILE);
        setLeavesMatchDeadLeafPileMap(Blocks.CHERRY_LEAVES, DEAD_CHERRY_LEAF_PILE);
        setLeavesMatchDeadLeafPileMap(Blocks.AZALEA_LEAVES, DEAD_AZALEA_LEAF_PILE);
        setLeavesMatchDeadLeafPileMap(Blocks.FLOWERING_AZALEA_LEAVES, DEAD_AZALEA_LEAF_PILE);

        setDeadLeafPileBlock(DEAD_OAK_LEAF_PILE);
        setDeadLeafPileBlock(DEAD_SPRUCE_LEAF_PILE);
        setDeadLeafPileBlock(DEAD_BIRCH_LEAF_PILE);
        setDeadLeafPileBlock(DEAD_JUNGLE_LEAF_PILE);
        setDeadLeafPileBlock(DEAD_ACACIA_LEAF_PILE);
        setDeadLeafPileBlock(DEAD_DARK_OAK_LEAF_PILE);
        setDeadLeafPileBlock(DEAD_MANGROVE_LEAF_PILE);
        setDeadLeafPileBlock(DEAD_CHERRY_LEAF_PILE);
        setDeadLeafPileBlock(DEAD_AZALEA_LEAF_PILE);
    }
}

package com.movtery.leafpile.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

import static com.movtery.leafpile.ModRegistry.compostingChanceRegistry;
import static com.movtery.leafpile.ModRegistry.itemRegistry;
import static com.movtery.leafpile.block.ModBlocks.*;

public class ModItems {
    // Items
    public static final Item LEAF = new Item(new FabricItemSettings());
    public static final Item DEAD_LEAF = new Item(new FabricItemSettings());

    // BlockItems
    public static final Item OAK_LEAF_PILE_ITEM = new BlockItem(OAK_LEAF_PILE, new FabricItemSettings());
    public static final Item SPRUCE_LEAF_PILE_ITEM = new BlockItem(SPRUCE_LEAF_PILE, new FabricItemSettings());
    public static final Item BIRCH_LEAF_PILE_ITEM = new BlockItem(BIRCH_LEAF_PILE, new FabricItemSettings());
    public static final Item JUNGLE_LEAF_PILE_ITEM = new BlockItem(JUNGLE_LEAF_PILE, new FabricItemSettings());
    public static final Item ACACIA_LEAF_PILE_ITEM = new BlockItem(ACACIA_LEAF_PILE, new FabricItemSettings());
    public static final Item DARK_OAK_LEAF_PILE_ITEM = new BlockItem(DARK_OAK_LEAF_PILE, new FabricItemSettings());
    public static final Item MANGROVE_LEAF_PILE_ITEM = new BlockItem(MANGROVE_LEAF_PILE, new FabricItemSettings());
    public static final Item CHERRY_LEAF_PILE_ITEM = new BlockItem(CHERRY_LEAF_PILE, new FabricItemSettings());
    public static final Item AZALEA_LEAF_PILE_ITEM = new BlockItem(AZALEA_LEAF_PILE, new FabricItemSettings());
    public static final Item DEAD_OAK_LEAF_PILE_ITEM = new BlockItem(DEAD_OAK_LEAF_PILE, new FabricItemSettings());
    public static final Item DEAD_SPRUCE_LEAF_PILE_ITEM = new BlockItem(DEAD_SPRUCE_LEAF_PILE, new FabricItemSettings());
    public static final Item DEAD_BIRCH_LEAF_PILE_ITEM = new BlockItem(DEAD_BIRCH_LEAF_PILE, new FabricItemSettings());
    public static final Item DEAD_JUNGLE_LEAF_PILE_ITEM = new BlockItem(DEAD_JUNGLE_LEAF_PILE, new FabricItemSettings());
    public static final Item DEAD_ACACIA_LEAF_PILE_ITEM = new BlockItem(DEAD_ACACIA_LEAF_PILE, new FabricItemSettings());
    public static final Item DEAD_DARK_OAK_LEAF_PILE_ITEM = new BlockItem(DEAD_DARK_OAK_LEAF_PILE, new FabricItemSettings());
    public static final Item DEAD_MANGROVE_LEAF_PILE_ITEM = new BlockItem(DEAD_MANGROVE_LEAF_PILE, new FabricItemSettings());
    public static final Item DEAD_CHERRY_LEAF_PILE_ITEM = new BlockItem(DEAD_CHERRY_LEAF_PILE, new FabricItemSettings());
    public static final Item DEAD_AZALEA_LEAF_PILE_ITEM = new BlockItem(DEAD_AZALEA_LEAF_PILE, new FabricItemSettings());

    public static final LeafArmorMaterial LEAF_ARMOR_MATERIAL = new LeafArmorMaterial();
    public static final Item LEAF_SKIRT = new ArmorItem(LEAF_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings());

    // Registry Items
    public static void registry() {
        itemRegistry("oak_leaf_pile", OAK_LEAF_PILE_ITEM);
        itemRegistry("spruce_leaf_pile", SPRUCE_LEAF_PILE_ITEM);
        itemRegistry("birch_leaf_pile", BIRCH_LEAF_PILE_ITEM);
        itemRegistry("jungle_leaf_pile", JUNGLE_LEAF_PILE_ITEM);
        itemRegistry("acacia_leaf_pile", ACACIA_LEAF_PILE_ITEM);
        itemRegistry("dark_oak_leaf_pile", DARK_OAK_LEAF_PILE_ITEM);
        itemRegistry("mangrove_leaf_pile", MANGROVE_LEAF_PILE_ITEM);
        itemRegistry("cherry_leaf_pile", CHERRY_LEAF_PILE_ITEM);
        itemRegistry("azalea_leaf_pile", AZALEA_LEAF_PILE_ITEM);
        itemRegistry("dead_oak_leaf_pile", DEAD_OAK_LEAF_PILE_ITEM);
        itemRegistry("dead_spruce_leaf_pile", DEAD_SPRUCE_LEAF_PILE_ITEM);
        itemRegistry("dead_birch_leaf_pile", DEAD_BIRCH_LEAF_PILE_ITEM);
        itemRegistry("dead_jungle_leaf_pile", DEAD_JUNGLE_LEAF_PILE_ITEM);
        itemRegistry("dead_acacia_leaf_pile", DEAD_ACACIA_LEAF_PILE_ITEM);
        itemRegistry("dead_dark_oak_leaf_pile", DEAD_DARK_OAK_LEAF_PILE_ITEM);
        itemRegistry("dead_mangrove_leaf_pile", DEAD_MANGROVE_LEAF_PILE_ITEM);
        itemRegistry("dead_cherry_leaf_pile", DEAD_CHERRY_LEAF_PILE_ITEM);
        itemRegistry("dead_azalea_leaf_pile", DEAD_AZALEA_LEAF_PILE_ITEM);

        itemRegistry("leaf", LEAF);
        itemRegistry("dead_leaf", DEAD_LEAF);

        itemRegistry("leaf_skirt", LEAF_SKIRT);

        compostingChanceRegistry(LEAF, 0.1F);
        compostingChanceRegistry(DEAD_LEAF, 0.2F);
        compostingChanceRegistry(OAK_LEAF_PILE_ITEM, 0.2F);
        compostingChanceRegistry(SPRUCE_LEAF_PILE_ITEM, 0.2F);
        compostingChanceRegistry(BIRCH_LEAF_PILE_ITEM, 0.2F);
        compostingChanceRegistry(JUNGLE_LEAF_PILE_ITEM, 0.2F);
        compostingChanceRegistry(ACACIA_LEAF_PILE_ITEM, 0.2F);
        compostingChanceRegistry(DARK_OAK_LEAF_PILE_ITEM, 0.2F);
        compostingChanceRegistry(MANGROVE_LEAF_PILE_ITEM, 0.2F);
        compostingChanceRegistry(CHERRY_LEAF_PILE_ITEM, 0.2F);
        compostingChanceRegistry(AZALEA_LEAF_PILE_ITEM, 0.2F);
        compostingChanceRegistry(DEAD_OAK_LEAF_PILE_ITEM, 0.4F);
        compostingChanceRegistry(DEAD_SPRUCE_LEAF_PILE_ITEM, 0.4F);
        compostingChanceRegistry(DEAD_BIRCH_LEAF_PILE_ITEM, 0.4F);
        compostingChanceRegistry(DEAD_JUNGLE_LEAF_PILE_ITEM, 0.4F);
        compostingChanceRegistry(DEAD_ACACIA_LEAF_PILE_ITEM, 0.4F);
        compostingChanceRegistry(DEAD_DARK_OAK_LEAF_PILE_ITEM, 0.4F);
        compostingChanceRegistry(DEAD_MANGROVE_LEAF_PILE_ITEM, 0.4F);
        compostingChanceRegistry(DEAD_CHERRY_LEAF_PILE_ITEM, 0.4F);
        compostingChanceRegistry(DEAD_AZALEA_LEAF_PILE_ITEM, 0.4F);
    }
}

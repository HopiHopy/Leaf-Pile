package com.movtery.leafpile.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

import java.util.ArrayList;

import static com.movtery.leafpile.ModRegistry.itemGroupRegistry;
import static com.movtery.leafpile.item.ModItems.OAK_LEAF_PILE_ITEM;

public class ModItemGroups {
    private static final ArrayList<Item> modItems = new ArrayList<>();
    public static ItemGroup LEAF_PILE_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(OAK_LEAF_PILE_ITEM))
            .displayName(Text.translatable("group.leafpile"))
            .entries(((displayContext, entries) -> {
                for (int i = 0; i < modItems.size(); i++) {
                    entries.add(getModItems().get(i));
                }
            }))
            .build();

    public static ArrayList<Item> getModItems() {
        return modItems;
    }

    public static void setModItems(Item modItems) {
        ModItemGroups.modItems.add(modItems);
    }

    public static void registry() {
        itemGroupRegistry("leafpile", LEAF_PILE_GROUP);
    }
}

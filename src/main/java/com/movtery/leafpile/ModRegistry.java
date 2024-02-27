package com.movtery.leafpile;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;

import static com.movtery.leafpile.LeafPile.MODID;
import static com.movtery.leafpile.item.ModItemGroups.setModItems;

public class ModRegistry {
    public static void blockRegistry(String id, Block blockId) {
        Registry.register(Registries.BLOCK, new Identifier(MODID, id), blockId);
    }

    public static void itemRegistry(String id, Item itemId) {
        Registry.register(Registries.ITEM, new Identifier(MODID, id), itemId);
        itemGroupJoiner(itemId);
    }

    public static void itemGroupRegistry(String id, ItemGroup itemGroupId) {
        Registry.register(Registries.ITEM_GROUP, new Identifier(MODID, id), itemGroupId);
    }

    public static void itemGroupJoiner(Item itemId) {
        setModItems(itemId);
    }

    public static void compostingChanceRegistry(Item itemId, Float chance) {
        CompostingChanceRegistry.INSTANCE.add(itemId, chance);
    }

    public static void flammableBlockRegistry(Block blockId, int burn, int spread) {
        FlammableBlockRegistry.getDefaultInstance().add(blockId, burn, spread);
    }

    public static void soundEventsRegistry(Identifier soundId, SoundEvent soundEvent) {
        Registry.register(Registries.SOUND_EVENT, soundId, soundEvent);
    }

    public static void featuresRegistry(String name, Feature feature) {
        Registry.register(Registries.FEATURE, new Identifier(MODID, name), feature);
    }
}

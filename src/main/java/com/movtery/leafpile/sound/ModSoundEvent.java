package com.movtery.leafpile.sound;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import static com.movtery.leafpile.LeafPile.MODID;
import static com.movtery.leafpile.ModRegistry.soundEventsRegistry;

public class ModSoundEvent {
    public static final Identifier ITEM_ARMOR_EQUIP_LEAF_ID = new Identifier(MODID + ":" + "leaf_skirt");
    public static final SoundEvent ITEM_ARMOR_EQUIP_LEAF = SoundEvent.of(ITEM_ARMOR_EQUIP_LEAF_ID);

    public static void registry() {
        soundEventsRegistry(ITEM_ARMOR_EQUIP_LEAF_ID, ITEM_ARMOR_EQUIP_LEAF);
    }
}

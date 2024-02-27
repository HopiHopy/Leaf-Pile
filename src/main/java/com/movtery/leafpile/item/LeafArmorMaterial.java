package com.movtery.leafpile.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

import static com.movtery.leafpile.sound.ModSoundEvent.ITEM_ARMOR_EQUIP_LEAF;

public class LeafArmorMaterial implements ArmorMaterial {
    private static final int[] DURABILITY = new int[] {35, 45, 55, 25};
    private static final int[] PROTECTION = new int[] {1, 1, 1, 1};

    @Override
    public int getDurability(ArmorItem.Type type) {
        return DURABILITY[type.getEquipmentSlot().getEntitySlotId()];
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return PROTECTION[type.getEquipmentSlot().getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 3;
    }

    @Override
    public SoundEvent getEquipSound() {
        return ITEM_ARMOR_EQUIP_LEAF;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.LEAF);
    }

    @Override
    public String getName() {
        return "leaf";
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}

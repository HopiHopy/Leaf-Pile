package com.movtery.leafpile;

import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;

public class ModProperties {
    public static final IntProperty FALLEN_LEAVES_AMOUNT = IntProperty.of("fallen_leaves_amount", 1, 5);
    public static final BooleanProperty NEVER_DEAD = BooleanProperty.of("never_dead");
}

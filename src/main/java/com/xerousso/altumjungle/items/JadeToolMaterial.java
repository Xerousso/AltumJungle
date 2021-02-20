package com.xerousso.altumjungle.items;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class JadeToolMaterial implements ToolMaterial {

    @Override
    public int getDurability() {
        return 1450;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 8.25f;
    }

    @Override
    public float getAttackDamage() {
        return 2.75f;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 14;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(AltumItems.JADE);
    }

}

package com.xerousso.altumjungle.items;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class JadeToolMaterial implements ToolMaterial {

    @Override
    public int getDurability() {
        return 1300;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 8;
    }

    @Override
    public float getAttackDamage() {
        return 2;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 20;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(AltumItems.JADE);
    }

}

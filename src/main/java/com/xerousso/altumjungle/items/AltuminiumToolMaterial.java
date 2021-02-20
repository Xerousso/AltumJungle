package com.xerousso.altumjungle.items;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class AltuminiumToolMaterial implements ToolMaterial {

    @Override
    public int getDurability() {
        return 2400;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 10.25f;
    }

    @Override
    public float getAttackDamage() {
        return 4.5f;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 20;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(AltumItems.ALTUMINIUM_INGOT);
    }

}

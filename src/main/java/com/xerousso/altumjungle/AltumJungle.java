package com.xerousso.altumjungle;

import com.xerousso.altumjungle.blocks.AltumBlocks;
import com.xerousso.altumjungle.items.AltumItems;
import net.fabricmc.api.ModInitializer;

public class AltumJungle implements ModInitializer {

    public static final String MOD_ID = "altum_jungle";

    @Override
    public void onInitialize() {
        AltumBlocks.init();
        AltumItems.init();
    }

}

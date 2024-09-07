package com.mauritiuschief.tfc_pot_is_hot;

import com.mojang.logging.LogUtils;

import net.minecraftforge.fml.common.Mod;

import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TFCPotIsHot.MODID)
public class TFCPotIsHot {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "tfc_pot_is_hot";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
}

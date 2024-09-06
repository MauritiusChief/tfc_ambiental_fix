package com.mauritiuschief.tfc_pot_is_hot.api;

import com.lumintorious.tfcambiental.api.AmbientalRegistry;
// import com.lumintorious.tfcambiental.api.BlockEntityTemperatureProvider;

public class AmbientalFixRegistry {
    static {
        // Register your methods with the existing registry
        AmbientalRegistry.BLOCK_ENTITIES.register(EnhancedBlockEntityTemperatureProvider::handlePot);
        AmbientalRegistry.BLOCK_ENTITIES.register(EnhancedBlockEntityTemperatureProvider::handleGrill);
    }
}

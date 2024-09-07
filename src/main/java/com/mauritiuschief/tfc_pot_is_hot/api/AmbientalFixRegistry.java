package com.mauritiuschief.tfc_pot_is_hot.api;

// import com.lumintorious.tfcambiental.api.AmbientalRegistry;
// import com.lumintorious.tfcambiental.api.BlockEntityTemperatureProvider;
import com.lumintorious.tfcambiental.api.BlockEntityTemperatureProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

public class AmbientalFixRegistry<Type> implements Iterable<Type> {

    public static final AmbientalFixRegistry<BlockEntityTemperatureProvider> BLOCK_ENTITIES = new AmbientalFixRegistry<>();

    static {
        // Register your methods with the existing registry
        BLOCK_ENTITIES.register(EnhancedBlockEntityTemperatureProvider::handlePot);
        BLOCK_ENTITIES.register(EnhancedBlockEntityTemperatureProvider::handleGrill);
    }

    private final ArrayList<Type> list = new ArrayList<>();

    private AmbientalFixRegistry() {
    }

    public void register(Type type) {
        list.add(type);
    }

    @Override
    public Iterator<Type> iterator() {
        return list.iterator();
    }
}

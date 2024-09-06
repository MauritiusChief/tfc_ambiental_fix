package com.mauritiuschief.tfc_pot_is_hot.api;

import com.lumintorious.tfcambiental.TFCAmbientalConfig;
import com.lumintorious.tfcambiental.item.TFCAmbientalItems;
import com.lumintorious.tfcambiental.api.BlockEntityTemperatureProvider;
import com.lumintorious.tfcambiental.api.EnvironmentalTemperatureProvider;
import com.lumintorious.tfcambiental.modifier.TempModifier;

// import net.dries007.tfc.common.blockentities.FirepitBlockEntity;
import net.dries007.tfc.common.blockentities.PotBlockEntity;
import net.dries007.tfc.common.blockentities.GrillBlockEntity;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.entity.player.Player;

import java.util.Optional;

public interface EnhancedBlockEntityTemperatureProvider extends BlockEntityTemperatureProvider {
    // New methods here
    private static boolean hasProtectionAlt(Player player) { // 由于原作者的hasProtection是private，只能出此下策
        var item = CuriosApi.getCuriosHelper().findCurios(player, TFCAmbientalItems.LEATHER_APRON.get());
        if (item.isEmpty()) {
            return false;
        }
        float environmentTemperature = EnvironmentalTemperatureProvider.getEnvironmentTemperatureWithTimeOfDay(player);
        float AVERAGE = TFCAmbientalConfig.COMMON.averageTemperature.get().floatValue();
        return environmentTemperature > AVERAGE;
    }
    
    static Optional<TempModifier> handlePot(Player player, BlockEntity entity) {
        if (entity instanceof PotBlockEntity pot) {
            float temp = pot.getTemperature();
            float change = temp / 100f;
            if (hasProtectionAlt(player)) {
                change = change * 0.3f;
            }
            return TempModifier.defined("pot", Math.min(6f, change), 0);
        }
        return TempModifier.none();
    }

    static Optional<TempModifier> handleGrill(Player player, BlockEntity entity) {
        if (entity instanceof GrillBlockEntity grill) {
            float temp = grill.getTemperature();
            float change = temp / 100f;
            if (hasProtectionAlt(player)) {
                change = change * 0.3f;
            }
            return TempModifier.defined("grill", Math.min(6f, change), 0);
        }
        return TempModifier.none();
    }
}
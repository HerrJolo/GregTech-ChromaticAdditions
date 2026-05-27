package com.chromatic.chromaticadditions.common.machine;

import com.chromatic.chromaticadditions.ChromaticAdditions;

import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder;
import com.gregtechceu.gtceu.common.machine.multiblock.part.DataAccessHatchMachine;

import net.minecraft.network.chat.Component;

import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

import static com.gregtechceu.gtceu.api.GTValues.MV;
import static com.gregtechceu.gtceu.common.registry.GTRegistration.REGISTRATE;

public class PartRegistry {

    static {
        REGISTRATE.creativeModeTab(() -> ChromaticAdditions.CHROMATIC_TAB);
    }

    public static void init() {}

    public static final MachineDefinition SINGLE_DATA_ACCESS_HATCH = REGISTRATE
            .machine("single_data_access_hatch", (holder) -> new DataAccessHatchMachine(holder, MV, false))
            .langValue("Single Data Access Hatch")
            .tier(MV)
            .rotationState(RotationState.ALL)
            .abilities(ChromaticPartAbility.SINGLE_DATA)
            .tooltips(Component.translatable("gtceu.machine.data_access_hatch.tooltip.0"),
                    Component.translatable("gtceu.machine.data_access_hatch.tooltip.1", 1),
                    Component.translatable("gtceu.part_sharing.enabled"))
            .overlayTieredHullModel("data_access_hatch")
            .register();

    @NotNull
    private static MachineBuilder<MachineDefinition, ?> registerDataHatch(String name, String displayName, int tier,
                                                                          Function<IMachineBlockEntity, MetaMachine> constructor,
                                                                          String model, PartAbility... abilities) {
        return REGISTRATE.machine(name, constructor)
                .langValue(displayName)
                .tier(tier)
                .rotationState(RotationState.ALL)
                .abilities(abilities)
                .overlayTieredHullModel(model);
    }
}

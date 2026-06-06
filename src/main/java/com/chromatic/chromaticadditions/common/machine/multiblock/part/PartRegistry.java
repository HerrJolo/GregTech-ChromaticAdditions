package com.chromatic.chromaticadditions.common.machine.multiblock.part;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder;
import com.gregtechceu.gtceu.common.machine.multiblock.part.DataAccessHatchMachine;

import com.gregtechceu.gtceu.common.machine.multiblock.part.FluidHatchPartMachine;
import net.minecraft.network.chat.Component;

import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.registry.GTRegistration.REGISTRATE;

public class PartRegistry {

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

    public static final MachineDefinition WOODENHATCHES =REGISTRATE
            .machine("primitive_fluid_hatch", (holder) -> new FluidHatchPartMachine(holder, ULV, IO.IN, 1000, 1))
            .langValue("Primitive Fluid Hatch")
            .rotationState(RotationState.ALL)
            .abilities(PartAbility.IMPORT_FLUIDS)
            .overlayTieredHullModel("fluid_passthrough_hatch")
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

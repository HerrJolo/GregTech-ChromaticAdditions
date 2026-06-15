package com.chromatic.chromaticadditions.common.machine.multiblock.part;

import com.chromatic.chromaticadditions.ChromaticAdditions;
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

import com.gregtechceu.gtceu.common.machine.multiblock.part.ItemBusPartMachine;
import net.minecraft.network.chat.Component;
import net.minecraftforge.client.model.generators.ConfiguredModel;

import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.models.GTMachineModels.createBasicReplaceableTextureMachineModel;
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

    public static final MachineDefinition WOODENHATCHESINPUT = REGISTRATE
            .machine("primitive_fluid_input_hatch", (holder) -> new FluidHatchPartMachine(holder, ULV, IO.IN, 1000, 1))
            .langValue("Primitive Fluid Inport Hatch")
            .rotationState(RotationState.ALL)
            .abilities(ChromaticPartAbility.PRIMITIVE_INTPUT_HATCH)
            // .overlayTieredHullModel("fluid_passthrough_hatch")
            .model(createBasicReplaceableTextureMachineModel(ChromaticAdditions.id("block/machine/part/primitive_fluid_input_hatch"))
                    .andThen(builder -> {
                        // UV lock the model so the plank texture doesn't rotate weirdly
                        builder.replaceForAllStates((state, models) -> {
                            for (int i = 0; i < models.length; i++) {
                                models[i] = ConfiguredModel.builder()
                                        .modelFile(models[i].model).uvLock(true)
                                        .buildLast();
                            }
                            return models;
                        });
                    }))
            .register();


    public static final MachineDefinition WOODENHATCHESOUTPUT = REGISTRATE
            .machine("primitive_fluid_output_hatch", (holder) -> new FluidHatchPartMachine(holder, ULV, IO.OUT, 1000, 1))
            .langValue("Primitive Fluid Export Hatch")
            .rotationState(RotationState.ALL)
            .abilities(ChromaticPartAbility.PRIMITIVE_OUTPUT_HATCH)
            // .overlayTieredHullModel("fluid_passthrough_hatch")
            .model(createBasicReplaceableTextureMachineModel(ChromaticAdditions.id("block/machine/part/primitive_fluid_output_hatch"))
                    .andThen(builder -> {
                        // UV lock the model so the plank texture doesn't rotate weirdly
                        builder.replaceForAllStates((state, models) -> {
                            for (int i = 0; i < models.length; i++) {
                                models[i] = ConfiguredModel.builder()
                                        .modelFile(models[i].model).uvLock(true)
                                        .buildLast();
                            }
                            return models;
                        });
                    }))
            .register();


    public static final MachineDefinition WOODENBUSSINPUT = REGISTRATE
            .machine("primitive_item_input_bus", (holder) -> new ItemBusPartMachine(holder, ULV, IO.IN, 1, 1))
            .langValue("Primitive Inport Bus")
            .rotationState(RotationState.ALL)
            .abilities(ChromaticPartAbility.PRIMITIVE_INPUT_BUS)
            // .overlayTieredHullModel("fluid_passthrough_hatch")
            .model(createBasicReplaceableTextureMachineModel(ChromaticAdditions.id("block/machine/part/primitive_input_bus"))
                    .andThen(builder -> {
                        // UV lock the model so the plank texture doesn't rotate weirdly
                        builder.replaceForAllStates((state, models) -> {
                            for (int i = 0; i < models.length; i++) {
                                models[i] = ConfiguredModel.builder()
                                        .modelFile(models[i].model).uvLock(true)
                                        .buildLast();
                            }
                            return models;
                        });
                    }))
            .register();

    public static final MachineDefinition WOODENBUSSOUTPUT = REGISTRATE
            .machine("primitive_item_output_bus", (holder) -> new ItemBusPartMachine(holder, ULV, IO.OUT, 1, 1))
            .langValue("Primitive Export Bus")
            .rotationState(RotationState.ALL)
            .abilities(ChromaticPartAbility.PRIMITIVE_OUTPUT_BUS)
            // .overlayTieredHullModel("fluid_passthrough_hatch")
            .model(createBasicReplaceableTextureMachineModel(ChromaticAdditions.id("block/machine/part/primitive_output_bus"))
                    .andThen(builder -> {
                        // UV lock the model so the plank texture doesn't rotate weirdly
                        builder.replaceForAllStates((state, models) -> {
                            for (int i = 0; i < models.length; i++) {
                                models[i] = ConfiguredModel.builder()
                                        .modelFile(models[i].model).uvLock(true)
                                        .buildLast();
                            }
                            return models;
                        });
                    }))
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

package com.chromatic.chromaticadditions.common.machine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_STEEL_PIPE;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_STEEL_SOLID;
import static com.gregtechceu.gtceu.common.registry.GTRegistration.REGISTRATE;

public class HvMultis {
    


    public static final MultiblockMachineDefinition Extended_Centrifuge = REGISTRATE
            .multiblock("industrial_centrifuge", WorkableElectricMultiblockMachine::new)
            .rotationState(RotationState.ALL)
            .recipeTypes(GTRecipeTypes.CENTRIFUGE_RECIPES)
            .recipeModifier(GTRecipeModifiers.OC_PERFECT)
            .appearanceBlock(CASING_STEEL_SOLID)
            .pattern(definition -> {
                return FactoryBlockPattern.start()
                        .aisle("CCC", "CSC", "CCC")
                        .aisle("CCC", "CGC", "CCC")
                        .aisle("CCC", "CGC", "CCC")
                        .aisle("CCC", "CGC", "CCC")
                        .aisle("CCC", "CKC", "CMC")
                        .where("K", Predicates.controller(Predicates.blocks(definition.get())))
                        .where("M", Predicates.abilities(PartAbility.MAINTENANCE))
                        .where("S", Predicates.abilities(PartAbility.MUFFLER))
                        .where("G", Predicates.blocks(CASING_STEEL_PIPE.get()))
                        .where("C", Predicates.blocks(CASING_STEEL_SOLID.get())
                                .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setExactLimit(1).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.EXPORT_FLUIDS).setPreviewCount(1)))
                        .build();
            })
            .workableCasingModel(GTCEu.id("block/casing/solid/machine_casing_solid_steel"),
                        GTCEu.id("block/multiblock/advanced_processing_array"))
            .register();



    public static void init() {}
}

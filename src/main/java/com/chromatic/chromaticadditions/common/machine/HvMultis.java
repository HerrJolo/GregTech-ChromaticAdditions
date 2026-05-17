package com.chromatic.chromaticadditions.common.machine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.frameGt;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Bronze;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Steel;
import static com.gregtechceu.gtceu.common.registry.GTRegistration.REGISTRATE;

public class HvMultis {
    


    //Centrifuge
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
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                        GTCEu.id("block/multiblock/advanced_processing_array"))
            .register();

    //Macerator
    public static final MultiblockMachineDefinition Extended_Macerator = REGISTRATE
            .multiblock("industrial_macerator", WorkableElectricMultiblockMachine::new)
            .rotationState(RotationState.ALL)
            .recipeTypes(GTRecipeTypes.MACERATOR_RECIPES)
            .recipeModifiers(GTRecipeModifiers.OC_PERFECT)
            .appearanceBlock(CASING_STEEL_SOLID)
            .pattern(definition -> {
                 return FactoryBlockPattern.start()
                        .aisle("CCC", "CSC", "CCC")
                        .aisle("CFC", "FGF", "CFC")
                        .aisle("CFC", "FGF", "CFC")
                        .aisle("CFC", "FGF", "CFC")
                        .aisle("CCC", "CKC", "CMC")
                        .where("K", Predicates.controller(Predicates.blocks(definition.get())))
                        .where("M", Predicates.abilities(PartAbility.MAINTENANCE))
                        .where("S", Predicates.abilities(PartAbility.MUFFLER))
                        .where("G", Predicates.blocks(CASING_STEEL_GEARBOX.get()))
                        .where("F", Predicates.blocks(ChemicalHelper.getBlock(frameGt, Steel)))
                        .where("C", Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                                .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setExactLimit(1).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.EXPORT_FLUIDS).setPreviewCount(1)))
            .build();
            })
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                        GTCEu.id("block/multiblock/advanced_processing_array"))
                .register();


    //Extractor
    public static final MultiblockMachineDefinition Extended_Extractor = REGISTRATE
            .multiblock("industrial_squeezer", WorkableElectricMultiblockMachine::new)
            .rotationState(RotationState.ALL)
            .recipeTypes(GTRecipeTypes.EXTRACTOR_RECIPES)
            .recipeModifiers(GTRecipeModifiers.OC_PERFECT)
            .appearanceBlock(CASING_INVAR_HEATPROOF)
            .pattern(definition -> {
                return FactoryBlockPattern.start()
                        .aisle("CCC", "CGC", "CGC", "CCC")
                        .aisle("CCC", "GBG", "GBG", "CSC")
                        .aisle("CKC", "CGC", "CGC", "CMC")
                        .where("K", Predicates.controller(Predicates.blocks(definition.get())))
                        .where("M", Predicates.abilities(PartAbility.MAINTENANCE))
                        .where("S", Predicates.abilities(PartAbility.MUFFLER))
                        .where("G", Predicates.blocks(ChemicalHelper.getBlock(frameGt, Bronze)))
                        .where("B", Predicates.blocks(CASING_BRONZE_PIPE.get()))
                        .where("C", Predicates.blocks(CASING_INVAR_HEATPROOF.get())
                                .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setExactLimit(1).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.EXPORT_FLUIDS).setPreviewCount(1)))
            .build();
            })
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_heatproof"),
                    GTCEu.id("block/multiblock/advanced_processing_array"))
            .register();


    //Thermal_Centrifuge
    public static final MultiblockMachineDefinition Extended_Thermal_Centrifuge = REGISTRATE
            .multiblock("industrial_thermal_centrifuge", WorkableElectricMultiblockMachine::new)
            .rotationState(RotationState.ALL)
            .recipeTypes(GTRecipeTypes.THERMAL_CENTRIFUGE_RECIPES)
            .recipeModifiers(GTRecipeModifiers.OC_PERFECT)
            .appearanceBlock(CASING_STAINLESS_CLEAN)
            .pattern(definition -> {
                return FactoryBlockPattern.start()
                        .aisle("CCC", "CSC", "CCC")
                        .aisle("CGC", "GPG", "CGC")
                        .aisle("CGC", "GPG", "CGC")
                        .aisle("CGC", "GPG", "CGC")
                        .aisle("CCC", "CKC", "CMC")
                        .where('K', Predicates.controller(Predicates.blocks(definition.get())))
                        .where('M', Predicates.abilities(PartAbility.MAINTENANCE))
                        .where('S', Predicates.abilities(PartAbility.MUFFLER))
                        .where('G', Predicates.blocks(COIL_CUPRONICKEL.get()))
                        .where('P', Predicates.blocks(CASING_STEEL_PIPE.get()))
                        .where('C', Predicates.blocks(CASING_STAINLESS_CLEAN.get())
                                .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setExactLimit(1).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.EXPORT_FLUIDS).setPreviewCount(1)))
                        .build();
            })
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"),
                    GTCEu.id("block/multiblock/advanced_processing_array"))
            .register();









    public static void init() {}
}

package com.chromatic.chromaticadditions.common.machine.multiblock.structurs;

import com.chromatic.chromaticadditions.ChromaticAdditions;
import com.chromatic.chromaticadditions.common.block.CasingBlocks;
import com.chromatic.chromaticadditions.common.data.ChromaticRecipeModefiers;

import com.chromatic.chromaticadditions.common.machine.WorkableChromaticEngines;
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

import net.minecraft.network.chat.Component;

import static com.chromatic.chromaticadditions.ChromaticAdditions.HERRJOLO_REGISTRATE;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.frameGt;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class HvMultisOreProc {

    // Centrifuge
    public static final MultiblockMachineDefinition Extended_Centrifuge = HERRJOLO_REGISTRATE
            .multiblock("industrial_centrifuge", WorkableElectricMultiblockMachine::new)
            .langValue("§6Industrial Centrifuge")
            .tooltips(Component.literal("§7You Spin me right Round"))
            .tooltips(Component.literal("§7Needs a Rotor to Work"))
            .tooltips(Component.literal("§7Does only accept one §6Energy Hatch"))
            .rotationState(RotationState.ALL)
            .recipeTypes(GTRecipeTypes.CENTRIFUGE_RECIPES)
            .recipeModifiers(GTRecipeModifiers.OC_NON_PERFECT, ChromaticRecipeModefiers.SIMPLE_PARALLEL.apply(4))
            .appearanceBlock(CASING_STEEL_SOLID)
            .pattern(definition -> {
                return FactoryBlockPattern.start()
                        .aisle("CCCCC", "CCCCC", "CCCCC")
                        .aisle("CCCCC", "RGGGS", "CCCCC")
                        .aisle("CCCCC", "CKMCC", "CCCCC")
                        .where("K", Predicates.controller(Predicates.blocks(definition.get())))
                        .where("M", Predicates.abilities(PartAbility.MAINTENANCE))
                        .where("S", Predicates.abilities(PartAbility.MUFFLER))
                        .where("R", Predicates.abilities(PartAbility.ROTOR_HOLDER))
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

    // Macerator
    public static final MultiblockMachineDefinition Extended_Macerator = HERRJOLO_REGISTRATE
            .multiblock("industrial_macerator", WorkableElectricMultiblockMachine::new)
            .langValue("§6Industrial Macerator")
            .tooltips(Component.literal("§7Just Crushing it"))
            .tooltips(Component.literal("§7Does only accept one §6Energy Hatch"))
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

    // Extractor
    public static final MultiblockMachineDefinition Extended_Extractor = HERRJOLO_REGISTRATE
            .multiblock("industrial_extractor", WorkableElectricMultiblockMachine::new)
            .langValue("§bIndustrial Extractor")
            .tooltips(Component.literal("§7Will make Apple juice if needed"))
            .tooltips(Component.literal("§7Does only accept one §6Energy Hatch"))
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

    // Thermal_Centrifuge
    public static final MultiblockMachineDefinition Extended_Thermal_Centrifuge = HERRJOLO_REGISTRATE
            .multiblock("industrial_thermal_centrifuge", WorkableElectricMultiblockMachine::new)
            .langValue("§6Industrial Thermal Centrifuge")
            .tooltips(Component.literal("§7A hot Centrifuge"))
            .tooltips(Component.literal("§7Needs a Rotor to Work"))
            .tooltips(Component.literal("§7Does only accept one §6Energy Hatch"))
            .rotationState(RotationState.ALL)
            .recipeTypes(GTRecipeTypes.THERMAL_CENTRIFUGE_RECIPES)
            .recipeModifiers(GTRecipeModifiers.OC_NON_PERFECT, ChromaticRecipeModefiers.SIMPLE_PARALLEL.apply(4))
            .appearanceBlock(CASING_STAINLESS_CLEAN)
            .pattern(definition -> {
                return FactoryBlockPattern.start()
                        .aisle("CGGGC", "CCCCC", "CGGGC")
                        .aisle("CCCCC", "RPPPS", "CCCCC")
                        .aisle("CGGGC", "CKMCC", "CGGGC")
                        .where('K', Predicates.controller(Predicates.blocks(definition.get())))
                        .where('M', Predicates.abilities(PartAbility.MAINTENANCE))
                        .where('S', Predicates.abilities(PartAbility.MUFFLER))
                        .where('R', Predicates.abilities(PartAbility.ROTOR_HOLDER))
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

    // Washer
    public static final MultiblockMachineDefinition Extended_WASHER = HERRJOLO_REGISTRATE
            .multiblock("wet_ore_processor", WorkableElectricMultiblockMachine::new)
            .langValue("§bWet Ore Processor")
            .tooltips(Component.literal("§7Does everything with ores and fluids"))
            .tooltips(Component.literal("§7Does only accept one §6Energy Hatch"))
            .rotationState(RotationState.ALL)
            .recipeTypes(GTRecipeTypes.ORE_WASHER_RECIPES, GTRecipeTypes.SIFTER_RECIPES,
                    GTRecipeTypes.CHEMICAL_BATH_RECIPES)
            .recipeModifiers(GTRecipeModifiers.OC_PERFECT)
            .appearanceBlock(CasingBlocks.LIQUID_WORKING_CASING)
            .pattern(definition -> {
                return FactoryBlockPattern.start()
                        .aisle("CCCCC", "CCSCC", "CCCCC")
                        .aisle("CCCCC", "CGGGC", "C   C")
                        .aisle("CCCCC", "CGGGC", "C   C")
                        .aisle("CCCCC", "CGGGC", "C   C")
                        .aisle("CCCCC", "CCKCC", "CCMCC")
                        .where('K', Predicates.controller(Predicates.blocks(definition.get())))
                        .where('M', Predicates.abilities(PartAbility.MAINTENANCE))
                        .where('S', Predicates.abilities(PartAbility.MUFFLER))
                        .where('G', Predicates.blocks(CASING_GRATE.get()))
                        .where(' ', Predicates.any())
                        .where('C', Predicates.blocks(CasingBlocks.LIQUID_WORKING_CASING.get())
                                .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setExactLimit(1).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.EXPORT_FLUIDS).setPreviewCount(1)))
                        .build();
            })
            .workableCasingModel(ChromaticAdditions.id("block/liquid_working_casing"),
                    GTCEu.id("block/multiblock/advanced_processing_array"))
            .register();

    // Electrolyzer
    public static final MultiblockMachineDefinition Extended_ElECTROLYCER = HERRJOLO_REGISTRATE
            .multiblock("industrial_electrolyze", WorkableElectricMultiblockMachine::new)
            .langValue("§6Industrial Electrolyze")
            .tooltips(Component.literal("§7Ripping molecules apart"))
            .tooltips(Component.literal("§7Does only accept one §6Energy Hatch"))
            .rotationState(RotationState.ALL)
            .recipeTypes(GTRecipeTypes.ELECTROLYZER_RECIPES)
            .recipeModifiers(GTRecipeModifiers.OC_PERFECT)
            .appearanceBlock(CASING_STAINLESS_CLEAN)
            .pattern(definition -> {
                return FactoryBlockPattern.start()
                        .aisle("CCCCC", "CTCTC", "CCCCC")
                        .aisle("CCCCC", "TGCGT", "CTCTC")
                        .aisle("CCCCC", "TG GT", "CTCTC")
                        .aisle("CCCCC", "TGCGT", "CTCTC")
                        .aisle("CCKCC", "CTCTC", "CCMCC")
                        .where('K', Predicates.controller(Predicates.blocks(definition.get())))
                        .where('M', Predicates.abilities(PartAbility.MAINTENANCE))
                        .where('S', Predicates.abilities(PartAbility.MUFFLER))
                        .where('G', Predicates.blocks(ChemicalHelper.getBlock(frameGt, Iron)))
                        .where(' ', Predicates.any())
                        .where('T', Predicates.blocks(CASING_TEMPERED_GLASS.get()))
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

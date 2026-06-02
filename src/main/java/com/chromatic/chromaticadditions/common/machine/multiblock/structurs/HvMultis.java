package com.chromatic.chromaticadditions.common.machine.multiblock.structurs;

import com.chromatic.chromaticadditions.ChromaticAdditions;
import com.chromatic.chromaticadditions.common.block.CasingBlocks;
import com.chromatic.chromaticadditions.common.data.ChromaticRecepieTypes;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.CoilWorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import static com.chromatic.chromaticadditions.ChromaticAdditions.HERRJOLO_REGISTRATE;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.frameGt;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static net.minecraft.world.level.block.Blocks.IRON_BLOCK;

public class HvMultis {

    // Mixer
    public static final MultiblockMachineDefinition Extended_MIXIER = HERRJOLO_REGISTRATE
            .multiblock("mixatron", WorkableElectricMultiblockMachine::new)
            .rotationState(RotationState.ALL)
            .recipeTypes(GTRecipeTypes.MIXER_RECIPES)
            .recipeModifiers(GTRecipeModifiers.OC_NON_PERFECT)
            .appearanceBlock(CasingBlocks.LIQUID_WORKING_CASING)
            .pattern(definition -> {
                return FactoryBlockPattern.start()
                        .aisle(" CCC ", " CGC ", " CGC ", " CSC ", "     ")
                        .aisle("CCCCC", "CA AC", "C   C", "C S C", "     ")
                        .aisle("CCCCC", "G I G", "G I G", "SSISS", "  I  ")
                        .aisle("CCCCC", "CA AC", "C   C", "C S C", "     ")
                        .aisle(" KCM ", " CGC ", " CGC ", " CSC ", "     ")
                        .where('K', Predicates.controller(Predicates.blocks(definition.get())))
                        .where('M', Predicates.abilities(PartAbility.MAINTENANCE))
                        .where('A', Predicates.blocks(ChemicalHelper.getBlock(frameGt, Aluminium)))
                        .where('I', Predicates.blocks(IRON_BLOCK))
                        .where('S', Predicates.blocks(ChemicalHelper.getBlock(frameGt, Steel)))
                        .where('G', Predicates.blocks(CASING_TEMPERED_GLASS.get()))
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

    // Mixer
    public static final MultiblockMachineDefinition Extended_EXTRUDER = HERRJOLO_REGISTRATE
            .multiblock("metal_former", CoilWorkableElectricMultiblockMachine::new)
            .rotationState(RotationState.ALL)
            .recipeTypes(GTRecipeTypes.EXTRUDER_RECIPES)
            .recipeModifiers(GTRecipeModifiers.OC_NON_PERFECT)
            .appearanceBlock(CasingBlocks.LIQUID_WORKING_CASING)
            .pattern(definition -> {
                return FactoryBlockPattern.start()
                        .aisle("IC CI", "I   I", "I   I", "I   I", "IC CI")
                        .aisle("CCCCC", " WSW ", " WSW ", " WSW ", "CCCCC")
                        .aisle("CCCCC", " SZS ", " SZS ", " SZS ", "CCYCC")
                        .aisle("CCKCC", " WSW ", " WSW ", " WSW ", "CCMCC")
                        .aisle("IC CI", "I   I", "I   I", "I   I", "IC CI")
                        .where('K', Predicates.controller(Predicates.blocks(definition.get())))
                        .where('M', Predicates.abilities(PartAbility.MAINTENANCE))
                        .where('G', Predicates.blocks(CASING_INVAR_HEATPROOF.get()))
                        .where('Z', Predicates.blocks(CASING_STEEL_PIPE.get()))
                        .where(' ', Predicates.any())
                        .where('I', Predicates.blocks(ChemicalHelper.getBlock(frameGt, Steel)))
                        .where('S', Predicates.blocks(ChemicalHelper.getBlock(frameGt, Invar)))
                        .where('W', Predicates.heatingCoils())
                        .where('Y', Predicates.abilities(PartAbility.MUFFLER))
                        .where('C', Predicates.blocks(CASING_INVAR_HEATPROOF.get())
                                .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setPreviewCount(1).setExactLimit(1))
                                .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setPreviewCount(1)))
                        .build();
            })
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_heatproof"),
                    GTCEu.id("block/multiblock/advanced_processing_array"))
            .register();

    // Precision Assembler
    public static final MultiblockMachineDefinition PRECISION_ASSEMBLER = HERRJOLO_REGISTRATE
            .multiblock("precision_assembler", CoilWorkableElectricMultiblockMachine::new)
            .rotationState(RotationState.ALL)
            .recipeTypes(ChromaticRecepieTypes.PRECISONASSEMBLER)
            .recipeModifiers(GTRecipeModifiers.OC_NON_PERFECT)
            .appearanceBlock(CASING_STAINLESS_CLEAN)
            .pattern(definition -> {
                return FactoryBlockPattern.start()
                        .aisle("IGGGI", "I   I", "I   I", "I   I", "GGGGG")
                        .aisle("GGGGG", " TGT ", " TTT ", " TGT ", "GGGGG")
                        .aisle("GGSGG", " GSG ", " TST ", " GSG ", "GGGGG")
                        .aisle("GGGGG", " TGT ", " TTT ", " TGT ", "GGGGG")
                        .aisle("IGKGI", "I   I", "I   I", "I   I", "IGMGI")
                        .where('K', Predicates.controller(Predicates.blocks(definition.get())))
                        .where('M', Predicates.abilities(PartAbility.MAINTENANCE))
                        .where('G', Predicates.blocks(CASING_STAINLESS_CLEAN.get())
                                .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setPreviewCount(1).setExactLimit(1))
                                .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setPreviewCount(1)))
                        .where(' ', Predicates.any())
                        .where('I', Predicates.blocks(ChemicalHelper.getBlock(frameGt, BlueSteel)))
                        .where('S', Predicates.blocks(CASING_STAINLESS_STEEL_GEARBOX.get()))
                        .where('T', Predicates.blocks(CASING_TEMPERED_GLASS.get()))
                        .build();
            })
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_heatproof"),
                    GTCEu.id("block/multiblock/advanced_processing_array"))
            .register();

    public static void init() {}
}

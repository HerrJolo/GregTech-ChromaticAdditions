package com.chromatic.chromaticadditions.common.machine;

import com.chromatic.chromaticadditions.ChromaticAdditions;
import com.chromatic.chromaticadditions.common.block.CasingBlocks;
import com.chromatic.chromaticadditions.common.data.ChromaticRecepieTypes;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.machine.multiblock.electric.AssemblyLineMachine;

import static com.chromatic.chromaticadditions.ChromaticAdditions.HERRJOLO_REGISTRATE;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.frameGt;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_STAINLESS_CLEAN;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_TEMPERED_GLASS;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class Em_Lines {

    public static void init() {}




    //EM_LINE
    public static final MultiblockMachineDefinition ELECTRIC_ASSEMBLY_LINE = HERRJOLO_REGISTRATE
            .multiblock("electric_assembly_line", AssemblyLineMachine::new)
            .rotationState(RotationState.ALL)
            .recipeTypes(ChromaticRecepieTypes.EMLINE)
            .recipeModifiers()
            .appearanceBlock(CasingBlocks.EM_CASING)
            .pattern(definition -> {
                return FactoryBlockPattern.start()
                        .aisle("CIC", "CGC", "CCC")
                        .aisle("CIC", "LGL", "CFC")
                        .aisle("CIC", "LGL", "CFC")
                        .aisle("CIC", "CGC", "CCC")
                        .aisle("CIC", "LGL", "CFC")
                        .aisle("CIC", "LGL", "CFC")
                        .aisle("CKC", "CGC", "CMC")
                        .where("K", Predicates.controller(Predicates.blocks(definition.get())))
                        .where("M", Predicates.abilities(PartAbility.MAINTENANCE))
                        .where("G", Predicates.blocks(CASING_STAINLESS_CLEAN.get()))
                        .where("L", Predicates.blocks(CASING_TEMPERED_GLASS.get()))
                        .where("F", Predicates.blocks(ChemicalHelper.getBlock(frameGt, Polytetrafluoroethylene)))
                        .where("C", Predicates.blocks(CasingBlocks.EM_CASING.get()))
                        .where("I", Predicates.blocks(CasingBlocks.EM_CASING.get())
                                .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setPreviewCount(1).setExactLimit(1)))
                        .build();
            })
            .workableCasingModel(ChromaticAdditions.id("block/emcassing"),
                    GTCEu.id("block/multiblock/advanced_processing_array"))
            .register();



}

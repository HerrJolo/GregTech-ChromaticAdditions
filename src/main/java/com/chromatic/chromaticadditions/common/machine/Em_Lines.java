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
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
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
                        .aisle("YIC", "LGL", "CFC")
                        .aisle("YIC", "CGC", "CCC")
                        .aisle("YIC", "LGL", "CFC")
                        .aisle("YIC", "LGL", "CFC")
                        .aisle("YKC", "CGC", "CMC")
                        .where("K", Predicates.controller(Predicates.blocks(definition.get())))
                        .where("M", Predicates.abilities(PartAbility.MAINTENANCE))
                        .where("G", Predicates.blocks(CASING_STAINLESS_STEEL_GEARBOX.get()))
                        .where("L", Predicates.blocks(CASING_TEMPERED_GLASS.get()))
                        .where("F", Predicates.blocks(ChemicalHelper.getBlock(frameGt, Polytetrafluoroethylene)))
                        .where("C", Predicates.blocks(CasingBlocks.EM_CASING.get()))
                        .where("Y", Predicates.blocks(CasingBlocks.EM_CASING.get())
                                .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setPreviewCount(3))
                                .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setPreviewCount(1).setExactLimit(1)))
                        .where("I", Predicates.blocks(CasingBlocks.EM_CASING.get())
                                .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setPreviewCount(6)))
                        .build();
            })
            .workableCasingModel(ChromaticAdditions.id("block/emcassing"),
                    GTCEu.id("block/multiblock/advanced_processing_array"))
            .register();


    //Em_Line_Diode
    public static final MultiblockMachineDefinition ELECTRIC_ASSEMBLY_LINE_DIODE = HERRJOLO_REGISTRATE
            .multiblock("attuned_electric_assembly_line_diode", AssemblyLineMachine::new)
            .rotationState(RotationState.ALL)
            .recipeTypes(ChromaticRecepieTypes.EMLINE_SMDDIODE)
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
                        .aisle("CIC", "LGL", "CFC")
                        .aisle("YIC", "CGC", "CCC")
                        .aisle("YIC", "LGL", "CFC")
                        .aisle("YIC", "LGL", "CFC")
                        .aisle("YIC", "LGL", "CFC")
                        .aisle("YKC", "CGC", "CMC")
                        .where("K", Predicates.controller(Predicates.blocks(definition.get())))
                        .where("M", Predicates.abilities(PartAbility.MAINTENANCE))
                        .where("G", Predicates.blocks(CASING_STAINLESS_STEEL_GEARBOX.get()))
                        .where("L", Predicates.blocks(CASING_TEMPERED_GLASS.get()))
                        .where("F", Predicates.blocks(ChemicalHelper.getBlock(frameGt, Polytetrafluoroethylene)))
                        .where("C", Predicates.blocks(CasingBlocks.EM_CASING.get()))
                        .where("Y", Predicates.blocks(CasingBlocks.EM_CASING.get())
                                .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setPreviewCount(3))
                                .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setPreviewCount(1).setExactLimit(1)))
                        .where("I", Predicates.blocks(CasingBlocks.EM_CASING.get())
                                .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setPreviewCount(6)))
                        .build();
            })
            .workableCasingModel(ChromaticAdditions.id("block/emcassing"),
                    GTCEu.id("block/multiblock/advanced_processing_array"))
            .register();


    //Em_Line_Ressistor
    public static final MultiblockMachineDefinition ELECTRIC_ASSEMBLY_LINE_RESSISTOR = HERRJOLO_REGISTRATE
            .multiblock("attuned_electric_assembly_line_ressistor", AssemblyLineMachine::new)
            .rotationState(RotationState.ALL)
            .recipeTypes(ChromaticRecepieTypes.EMLINE_SMDRESSISITOR)
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
                        .aisle("CIC", "LGL", "CFC")
                        .aisle("YIC", "CGC", "CCC")
                        .aisle("YIC", "LGL", "CFC")
                        .aisle("YIC", "LGL", "CFC")
                        .aisle("YIC", "LGL", "CFC")
                        .aisle("YKC", "CGC", "CMC")
                        .where("K", Predicates.controller(Predicates.blocks(definition.get())))
                        .where("M", Predicates.abilities(PartAbility.MAINTENANCE))
                        .where("G", Predicates.blocks(CASING_STAINLESS_STEEL_GEARBOX.get()))
                        .where("L", Predicates.blocks(CASING_TEMPERED_GLASS.get()))
                        .where("F", Predicates.blocks(ChemicalHelper.getBlock(frameGt, Polytetrafluoroethylene)))
                        .where("C", Predicates.blocks(CasingBlocks.EM_CASING.get()))
                        .where("Y", Predicates.blocks(CasingBlocks.EM_CASING.get())
                                .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setPreviewCount(3))
                                .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setPreviewCount(1).setExactLimit(1)))
                        .where("I", Predicates.blocks(CasingBlocks.EM_CASING.get())
                                .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setPreviewCount(6)))
                        .build();
            })
            .workableCasingModel(ChromaticAdditions.id("block/emcassing"),
                    GTCEu.id("block/multiblock/advanced_processing_array"))
            .register();


    //Em_Line_Transistor
    public static final MultiblockMachineDefinition ELECTRIC_ASSEMBLY_LINE_TRANSISTOR = HERRJOLO_REGISTRATE
            .multiblock("attuned_electric_assembly_line_transistor", AssemblyLineMachine::new)
            .rotationState(RotationState.ALL)
            .recipeTypes(ChromaticRecepieTypes.EMLINE_SMDTRANSISTOR)
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
                        .aisle("CIC", "LGL", "CFC")
                        .aisle("YIC", "CGC", "CCC")
                        .aisle("YIC", "LGL", "CFC")
                        .aisle("YIC", "LGL", "CFC")
                        .aisle("YIC", "LGL", "CFC")
                        .aisle("YKC", "CGC", "CMC")
                        .where("K", Predicates.controller(Predicates.blocks(definition.get())))
                        .where("M", Predicates.abilities(PartAbility.MAINTENANCE))
                        .where("G", Predicates.blocks(CASING_STAINLESS_STEEL_GEARBOX.get()))
                        .where("L", Predicates.blocks(CASING_TEMPERED_GLASS.get()))
                        .where("F", Predicates.blocks(ChemicalHelper.getBlock(frameGt, Polytetrafluoroethylene)))
                        .where("C", Predicates.blocks(CasingBlocks.EM_CASING.get()))
                        .where("Y", Predicates.blocks(CasingBlocks.EM_CASING.get())
                                .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setPreviewCount(3))
                                .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setPreviewCount(1).setExactLimit(1)))
                        .where("I", Predicates.blocks(CasingBlocks.EM_CASING.get())
                                .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setPreviewCount(6)))
                        .build();
            })
            .workableCasingModel(ChromaticAdditions.id("block/emcassing"),
                    GTCEu.id("block/multiblock/advanced_processing_array"))
            .register();


    //Em_Line_Capacitor
    public static final MultiblockMachineDefinition ELECTRIC_ASSEMBLY_LINE_CAPACITOR = HERRJOLO_REGISTRATE
            .multiblock("attuned_electric_assembly_line_capacitor", AssemblyLineMachine::new)
            .rotationState(RotationState.ALL)
            .recipeTypes(ChromaticRecepieTypes.EMLINE_SMDCAPAICTOR)
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
                        .aisle("CIC", "LGL", "CFC")
                        .aisle("YIC", "CGC", "CCC")
                        .aisle("YIC", "LGL", "CFC")
                        .aisle("YIC", "LGL", "CFC")
                        .aisle("YIC", "LGL", "CFC")
                        .aisle("YKC", "CGC", "CMC")
                        .where("K", Predicates.controller(Predicates.blocks(definition.get())))
                        .where("M", Predicates.abilities(PartAbility.MAINTENANCE))
                        .where("G", Predicates.blocks(CASING_STAINLESS_STEEL_GEARBOX.get()))
                        .where("L", Predicates.blocks(CASING_TEMPERED_GLASS.get()))
                        .where("F", Predicates.blocks(ChemicalHelper.getBlock(frameGt, Polytetrafluoroethylene)))
                        .where("C", Predicates.blocks(CasingBlocks.EM_CASING.get()))
                        .where("Y", Predicates.blocks(CasingBlocks.EM_CASING.get())
                                .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setPreviewCount(3))
                                .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setPreviewCount(1).setExactLimit(1)))
                        .where("I", Predicates.blocks(CasingBlocks.EM_CASING.get())
                                .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setPreviewCount(6)))
                        .build();
            })
            .workableCasingModel(ChromaticAdditions.id("block/emcassing"),
                    GTCEu.id("block/multiblock/advanced_processing_array"))
            .register();


    //Em_Line_Inductor
    public static final MultiblockMachineDefinition ELECTRIC_ASSEMBLY_LINE_INDUCTOR = HERRJOLO_REGISTRATE
            .multiblock("attuned_electric_assembly_line_inductor", AssemblyLineMachine::new)
            .rotationState(RotationState.ALL)
            .recipeTypes(ChromaticRecepieTypes.EMLINE_SMDINDUCTOR)
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
                        .aisle("CIC", "LGL", "CFC")
                        .aisle("YIC", "CGC", "CCC")
                        .aisle("YIC", "LGL", "CFC")
                        .aisle("YIC", "LGL", "CFC")
                        .aisle("YIC", "LGL", "CFC")
                        .aisle("YKC", "CGC", "CMC")
                        .where("K", Predicates.controller(Predicates.blocks(definition.get())))
                        .where("M", Predicates.abilities(PartAbility.MAINTENANCE))
                        .where("G", Predicates.blocks(CASING_STAINLESS_STEEL_GEARBOX.get()))
                        .where("L", Predicates.blocks(CASING_TEMPERED_GLASS.get()))
                        .where("F", Predicates.blocks(ChemicalHelper.getBlock(frameGt, Polytetrafluoroethylene)))
                        .where("C", Predicates.blocks(CasingBlocks.EM_CASING.get()))
                        .where("Y", Predicates.blocks(CasingBlocks.EM_CASING.get())
                                .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setPreviewCount(3))
                                .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setPreviewCount(1).setExactLimit(1)))
                        .where("I", Predicates.blocks(CasingBlocks.EM_CASING.get())
                                .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setPreviewCount(6)))
                        .build();
            })
            .workableCasingModel(ChromaticAdditions.id("block/emcassing"),
                    GTCEu.id("block/multiblock/advanced_processing_array"))
            .register();

}

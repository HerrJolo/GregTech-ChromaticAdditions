package com.chromatic.chromaticadditions.common.machine.multiblock.structurs;

import com.chromatic.chromaticadditions.common.block.CasingBlocks;
import com.chromatic.chromaticadditions.common.data.ChromaticRecepieTypes;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
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

import static com.chromatic.chromaticadditions.ChromaticAdditions.HERRJOLO_REGISTRATE;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.frameGt;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_STEEL_GEARBOX;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_STEEL_SOLID;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class PrimitiveMultis {


    public static final MultiblockMachineDefinition LARGE_RIVER_PUMP = HERRJOLO_REGISTRATE
        .multiblock("large_river_pump", WorkableElectricMultiblockMachine::new)
        .rotationState(RotationState.ALL)
        .recipeTypes(ChromaticRecepieTypes.LARGERIVERPUMP)
        .recipeModifiers()
        .appearanceBlock(GTBlocks.TREATED_WOOD_PLANK)
        .pattern(definition -> {
            return FactoryBlockPattern.start()
                    .aisle("abcccba", "aaaaaaa", "aaaaaaa", "aaaaaaa", "aaaaaaa", "aaaaaaa", "aaaaaaa")
                    .aisle("bdcccdb", "adaeada", "aaaaaaa", "aaaaaaa", "aaaaaaa", "aaaaaaa", "aaaaaaa")
                    .aisle("ccaaacc", "aaaaaaa", "aaaeaaa", "aaaeaaa", "aaaeaaa", "aaaaaaa", "aaaaaaa")
                    .aisle("ccadacc", "aeadaea", "aaedeaa", "aaedeaa", "aaedeaa", "aaadaaa", "aaadaaa")
                    .aisle("ccaaacc", "aaaaaaa", "aaaeaaa", "aaaeaaa", "aaaeaaa", "aaaaaaa", "aaaaaaa")
                    .aisle("bdcccdb", "adaeada", "aaaaaaa", "aaaaaaa", "aaaaaaa", "aaaaaaa", "aaaaaaa")
                    .aisle("abcKcba", "aaaaaaa", "aaaaaaa", "aaaaaaa", "aaaaaaa", "aaaaaaa", "aaaaaaa")
                    .where("K", Predicates.controller(Predicates.blocks(definition.get())))
                    .where("a", Predicates.any())
                    .where("b", Predicates.blocks(ChemicalHelper.getBlock(frameGt, TreatedWood)))
                    .where("e", Predicates.blocks(ChemicalHelper.getBlock(frameGt, Iron)))
                    .where("c", Predicates.blocks(GTBlocks.CASING_PUMP_DECK.get())
                        .or(Predicates.abilities(PartAbility.EXPORT_ITEMS))
                        .or(Predicates.abilities(PartAbility.IMPORT_ITEMS))
                        .or(Predicates.abilities(PartAbility.EXPORT_FLUIDS)))
                    .where("d", Predicates.blocks(GTBlocks.RUBBER_LOG.get()))
                    .build();
        })
        .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                GTCEu.id("block/multiblock/advanced_processing_array"))
        .register();

    public static void init() {
    }
}

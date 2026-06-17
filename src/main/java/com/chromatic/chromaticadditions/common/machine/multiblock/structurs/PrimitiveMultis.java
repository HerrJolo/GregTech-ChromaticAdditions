package com.chromatic.chromaticadditions.common.machine.multiblock.structurs;

import com.chromatic.chromaticadditions.common.data.ChromaticRecepieTypes;
import com.chromatic.chromaticadditions.common.machine.multiblock.part.ChromaticPartAbility;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GTBlocks;

import net.minecraft.world.level.block.Blocks;

import static com.chromatic.chromaticadditions.ChromaticAdditions.HERRJOLO_REGISTRATE;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.frameGt;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static net.minecraft.world.level.block.Blocks.IRON_BLOCK;

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
                                .or(Predicates.abilities(ChromaticPartAbility.PRIMITIVE_INPUT_BUS))
                                .or(Predicates.abilities(ChromaticPartAbility.PRIMITIVE_OUTPUT_BUS))
                                .or(Predicates.abilities(ChromaticPartAbility.PRIMITIVE_OUTPUT_HATCH)))
                        .where("d", Predicates.blocks(GTBlocks.RUBBER_LOG.get()))
                        .build();
            })
            .workableCasingModel(GTCEu.id("block/treated_wood_planks"),
                    GTCEu.id("block/multiblock/implosion_compressor"))
            .register();

    public static final MultiblockMachineDefinition PRIMITIVE_MIXER = HERRJOLO_REGISTRATE
            .multiblock("primitve_mixer", WorkableElectricMultiblockMachine::new)
            .rotationState(RotationState.ALL)
            .recipeTypes(ChromaticRecepieTypes.PRIMITIVEMIXER)
            .recipeModifiers()
            .appearanceBlock(GTBlocks.TREATED_WOOD_PLANK)
            .pattern(definition -> {
                return FactoryBlockPattern.start()
                        .aisle(" CCC ", " CGC ", " CGC ", " CSC ", "     ")
                        .aisle("CBBBC", "CA AC", "C   C", "C S C", "     ")
                        .aisle("CBBBC", "G I G", "G I G", "SSISS", "  I  ")
                        .aisle("CBBBC", "CA AC", "C   C", "C S C", "     ")
                        .aisle(" CKC ", " CGC ", " CGC ", " CSC ", "     ")
                        .where('K', Predicates.controller(Predicates.blocks(definition.get())))
                        .where('A', Predicates.blocks(ChemicalHelper.getBlock(frameGt, Iron)))
                        .where('B', Predicates.blocks(Blocks.BRICKS))
                        .where('I', Predicates.blocks(RUBBER_LOG.get()))
                        .where('S', Predicates.blocks(ChemicalHelper.getBlock(frameGt, TreatedWood)))
                        .where('G', Predicates.blocks(Blocks.GLASS))
                        .where(' ', Predicates.any())
                        .where('C', Predicates.blocks(TREATED_WOOD_PLANK.get())
                                .or(Predicates.abilities(ChromaticPartAbility.PRIMITIVE_INPUT_BUS))
                                .or(Predicates.abilities(ChromaticPartAbility.PRIMITIVE_OUTPUT_BUS))
                                .or(Predicates.abilities(ChromaticPartAbility.PRIMITIVE_OUTPUT_HATCH))
                                .or(Predicates.abilities(ChromaticPartAbility.PRIMITIVE_INTPUT_HATCH)))
                        .build();
            })
            .workableCasingModel(GTCEu.id("block/treated_wood_planks"),
                    GTCEu.id("block/multiblock/implosion_compressor"))
            .register();

    public static final MultiblockMachineDefinition PRIMITIVE_PRESS = HERRJOLO_REGISTRATE
            .multiblock("primitve_press", WorkableElectricMultiblockMachine::new)
            .rotationState(RotationState.ALL)
            .recipeTypes(ChromaticRecepieTypes.PRIMITIVEPRESS)
            .recipeModifiers()
            .appearanceBlock(GTBlocks.RUBBER_LOG)
            .pattern(definition -> {
                return FactoryBlockPattern.start()
                        .aisle("IBI", "I I", "I I", "IAI")
                        .aisle("BCB", "   ", " C ", "ACA")
                        .aisle("IBK", "I I", "I I", "IAI")
                        .where('K', Predicates.controller(Predicates.blocks(definition.get())))
                        .where(' ', Predicates.any())
                        .where('A', Predicates.blocks(ChemicalHelper.getBlock(frameGt, Wood)))
                        .where('B', Predicates.blocks(Blocks.BRICKS))
                        .where('C', Predicates.blocks(Blocks.IRON_BLOCK))
                        .where('I', Predicates.blocks(RUBBER_LOG.get())
                                .or(Predicates.abilities(ChromaticPartAbility.PRIMITIVE_INPUT_BUS))
                                .or(Predicates.abilities(ChromaticPartAbility.PRIMITIVE_OUTPUT_BUS))
                                .or(Predicates.abilities(ChromaticPartAbility.PRIMITIVE_OUTPUT_HATCH))
                                .or(Predicates.abilities(ChromaticPartAbility.PRIMITIVE_INTPUT_HATCH)))
                        .where(' ', Predicates.any())
                        .build();
            })
            .workableCasingModel(GTCEu.id("block/rubber_log"),
                    GTCEu.id("block/multiblock/implosion_compressor"))
            .register();

    public static void init() {}
}

package com.chromatic.chromaticadditions.common.machine.multiblock.structurs;

import com.chromatic.chromaticadditions.ChromaticAdditions;
import com.chromatic.chromaticadditions.common.block.CasingBlocks;
import com.chromatic.chromaticadditions.common.data.ChromaticRecepieTypes;
import com.chromatic.chromaticadditions.common.machine.WorkableFruitedGreenhouseMachine;
import com.chromatic.chromaticadditions.common.machine.WorkableTreeGreenhouseMachine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;

import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Blocks;

import static com.chromatic.chromaticadditions.ChromaticAdditions.HERRJOLO_REGISTRATE;

public class GreenHouses {

    public static final MultiblockMachineDefinition FRUIT_GREENHOUSE = HERRJOLO_REGISTRATE
            .multiblock("fruit_greenhouse", WorkableFruitedGreenhouseMachine::new)
            .langValue("§2Fruit Greenhouse")
            .tooltips(Component.literal("§7Grows your Plants for you way more efficient"))
            .tooltips(Component.literal("§7Can also Grow §CSpecial Plants §7if you provide the filing atmosphere"))
            .tooltips(Component.literal("§7Requires 10mb of §9Water §7and 1mb of §5Insect Repellent §7per Second"))
            .tooltips(Component.literal("§7If 2 §2Fertilizer §7are supplied the output will double"))
            .rotationState(RotationState.ALL)
            .recipeTypes(ChromaticRecepieTypes.FRUITEGREENHOUSE)
            .recipeModifiers(GTRecipeModifiers.OC_NON_PERFECT, WorkableFruitedGreenhouseMachine::recipeModifier)
            .appearanceBlock(CasingBlocks.HERMETIC_CASING)
            .pattern(definition -> {
                return FactoryBlockPattern.start()
                        .aisle("abbba", "addda", "abbba", "addda", "abbba")
                        .aisle("beeeb", "daaad", "beeeb", "daaad", "bfffb")
                        .aisle("beeeb", "daaad", "beeeb", "daaad", "bfffb")
                        .aisle("beeeb", "daaad", "beeeb", "daaad", "bfffb")
                        .aisle("abKba", "addda", "abbba", "addda", "abhba")
                        .where("K", Predicates.controller(Predicates.blocks(definition.get())))
                        .where("h", Predicates.abilities(PartAbility.MAINTENANCE))
                        .where("a", Predicates.any())
                        .where("b", Predicates.blocks(CasingBlocks.HERMETIC_CASING.get())
                                .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setExactLimit(1).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setPreviewCount(1)))
                        .where("d", Predicates.blocks(GTBlocks.CASING_TEMPERED_GLASS.get()))
                        .where("e", Predicates.blocks(Blocks.DIRT))
                        .where("f", Predicates.blocks(GTBlocks.FILTER_CASING.get()))
                        .build();
            })
            .workableCasingModel(ChromaticAdditions.id("block/hermeticcasing"),
                    GTCEu.id("block/multiblock/advanced_processing_array"))
            .register();

    public static final MultiblockMachineDefinition TREE_GREENHOUSE = HERRJOLO_REGISTRATE
            .multiblock("tree_greenhouse", WorkableTreeGreenhouseMachine::new)
            .langValue("§2Tree Greenhouse")
            .tooltips(Component.literal("§7Grows Trees way more efficient"))
            .tooltips(Component.literal("§7Requires 10mb of §9Water §7Repellent per Second"))
            .tooltips(Component.literal("§7If 2 §2Fertilizer §7are supplied the output will double"))
            .rotationState(RotationState.ALL)
            .recipeTypes(ChromaticRecepieTypes.TREEGREENHOUSE)
            .recipeModifiers(GTRecipeModifiers.OC_NON_PERFECT, WorkableFruitedGreenhouseMachine::recipeModifier)
            .appearanceBlock(CasingBlocks.HERMETIC_CASING)
            .pattern(definition -> {
                return FactoryBlockPattern.start()
                        .aisle("abbba", "accca", "accca", "accca", "accca")
                        .aisle("bdddb", "ceeec", "ceeec", "ceeec", "ceeec")
                        .aisle("bdddb", "ceeec", "ceeec", "ceeec", "ceeec")
                        .aisle("bdddb", "ceeec", "ceeec", "ceeec", "ceeec")
                        .aisle("abKha", "accca", "accca", "accca", "accca")
                        .where("K", Predicates.controller(Predicates.blocks(definition.get())))
                        .where("h", Predicates.abilities(PartAbility.MAINTENANCE))
                        .where("e", Predicates.any())
                        .where("b", Predicates.blocks(CasingBlocks.HERMETIC_CASING.get())
                                .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setExactLimit(1).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setPreviewCount(1)))
                        .where("a", Predicates.blocks(ChemicalHelper.getBlock(TagPrefix.frameGt, GTMaterials.Steel)))
                        .where("c", Predicates.blocks(GTBlocks.CASING_TEMPERED_GLASS.get()))
                        .where("d", Predicates.blocks(Blocks.DIRT))
                        .build();
            })
            .workableCasingModel(ChromaticAdditions.id("block/hermeticcasing"),
                    GTCEu.id("block/multiblock/advanced_processing_array"))
            .register();

    public static void init() {}
}

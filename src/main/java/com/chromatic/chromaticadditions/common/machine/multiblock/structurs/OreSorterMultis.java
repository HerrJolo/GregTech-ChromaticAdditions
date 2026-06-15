package com.chromatic.chromaticadditions.common.machine.multiblock.structurs;

import com.chromatic.chromaticadditions.common.data.ChromaticRecepieTypes;
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
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Blocks;

import static com.chromatic.chromaticadditions.ChromaticAdditions.HERRJOLO_REGISTRATE;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.frameGt;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_TITANIUM_STABLE;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class OreSorterMultis {



    // Sorter
    public static final MultiblockMachineDefinition STEAMESORTER = HERRJOLO_REGISTRATE
            .multiblock("steam_sorter", WorkableElectricMultiblockMachine::new)
            .langValue("Steam Ore Sorter")
            .tooltips(Component.literal("Sorts your ores, just slowly"))
            .rotationState(RotationState.ALL)
            .recipeTypes(ChromaticRecepieTypes.SORTER)
            .recipeModifiers(GTRecipeModifiers.OC_NON_PERFECT)
            .appearanceBlock(CASING_BRONZE_BRICKS)
            .pattern(definition -> {
                return FactoryBlockPattern.start()
                        .aisle("abbba", "accca", "accca", "addda")
                        .aisle("bcccb", "ceeec", "cdddc", "ddddd")
                        .aisle("bcccb", "ceeec", "cdddc", "ddddd")
                        .aisle("bcccb", "ceeec", "cdddc", "ddddd")
                        .aisle("abbba", "acKca", "accca", "addda")
                        .where("K", Predicates.controller(Predicates.blocks(definition.get())))
                        .where("a", Predicates.blocks(RUBBER_LOG.get()))
                        .where("b", Predicates.blocks(Blocks.BRICKS))
                        .where("c", Predicates.blocks(CASING_BRONZE_BRICKS.get())
                                .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.STEAM).setExactLimit(1).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setPreviewCount(1)))
                        .where("d", Predicates.any())
                        .where("e", Predicates.blocks(ChemicalHelper.getBlock(frameGt, Iron)))
                        .build();
            })
        .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"),
                    GTCEu.id("block/multiblock/implosion_compressor"))
        .register();


    // Sorter
    public static final MultiblockMachineDefinition SORTER = HERRJOLO_REGISTRATE
            .multiblock("sorter", WorkableElectricMultiblockMachine::new)
            .langValue("§6ORE Sorter")
            .tooltips(Component.literal("Sorts ore depending on weight, optics and haptics"))
            .tooltips(Component.literal("Does only accept §6One §fEnergy Hatch"))
            .tooltips(Component.literal("Does not accept Parallel Hatches"))
            .rotationState(RotationState.ALL)
            .recipeTypes(ChromaticRecepieTypes.SORTER)
            .recipeModifiers(GTRecipeModifiers.OC_NON_PERFECT)
            .appearanceBlock(CASING_STEEL_SOLID)
            .pattern(definition -> {
                return FactoryBlockPattern.start()
                        .aisle(" CCC ", " CTC ", " CTC ", " CCC ")
                        .aisle("CCCCC", "CFFFC", "CFFFC", "CCCCC")
                        .aisle("CCCCC", "TFGFT", "TFGFT", "CCSCC")
                        .aisle("CCCCC", "CFFFC", "CFFFC", "CCCCC")
                        .aisle(" CKC ", " CTC ", " CTC ", " CMC ")
                        .where("K", Predicates.controller(Predicates.blocks(definition.get())))
                        .where("M", Predicates.abilities(PartAbility.MAINTENANCE))
                        .where("S", Predicates.abilities(PartAbility.MUFFLER))
                        .where(" ", Predicates.any())
                        .where("G", Predicates.blocks(CASING_STEEL_GEARBOX.get()))
                        .where("F", Predicates.blocks(ChemicalHelper.getBlock(frameGt, StainlessSteel)))
                        .where("T", Predicates.blocks(CASING_TEMPERED_GLASS.get()))
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

    //Large Sorter
    public static final MultiblockMachineDefinition LARGE_SORTER = HERRJOLO_REGISTRATE
            .multiblock("large_sorter", WorkableElectricMultiblockMachine::new)
            .langValue("§1Large Ore Sorter")
            .tooltips(Component.literal("Sorts ore depending on weight, optics and haptics more efficiently"))
            .tooltips(Component.literal("Does only accept §6One §fEnergy Hatch"))
            .tooltips(Component.literal("Does accept Parallel Hatches"))
            .rotationState(RotationState.ALL)
            .recipeTypes(ChromaticRecepieTypes.SORTER)
            .recipeModifiers(GTRecipeModifiers.OC_NON_PERFECT, GTRecipeModifiers.PARALLEL_HATCH)
            .appearanceBlock(CASING_TITANIUM_STABLE)
            .pattern(definition -> {
                return FactoryBlockPattern.start()
                        .aisle(" CCC ", " CTC ", " CTC ", " CTC ", " CTC ", " CCC ")
                        .aisle("CCCCC", "CFFFC", "CFFFC", "CFFFC", "CFFFC", "CCCCC")
                        .aisle("CCCCC", "TFGFT", "TFGFT", "TFGFT", "TFGFT", "CCSCC")
                        .aisle("CCCCC", "CFFFC", "CFFFC", "CFFFC", "CFFFC", "CCCCC")
                        .aisle(" CKY ", " CTC ", " CTC ", " CTC ", " CTC ", " CMC ")
                        .where("K", Predicates.controller(Predicates.blocks(definition.get())))
                        .where("M", Predicates.abilities(PartAbility.MAINTENANCE))
                        .where("S", Predicates.abilities(PartAbility.MUFFLER))
                        .where("Y", Predicates.abilities(PartAbility.PARALLEL_HATCH)
                                .or(Predicates.blocks(CASING_TITANIUM_STABLE.get())))
                        .where(" ", Predicates.any())
                        .where("G", Predicates.blocks(CASING_TUNGSTENSTEEL_GEARBOX.get()))
                        .where("F", Predicates.blocks(ChemicalHelper.getBlock(frameGt, TungstenSteel)))
                        .where("T", Predicates.blocks(CASING_LAMINATED_GLASS.get()))
                        .where("C", Predicates.blocks(CASING_TITANIUM_STABLE.get())
                                .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setExactLimit(1).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.EXPORT_FLUIDS).setPreviewCount(1)))
                        .build();
            })
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_stable_titanium"),
                    GTCEu.id("block/multiblock/advanced_processing_array"))
            .register();

    public static void init() {
    }
}

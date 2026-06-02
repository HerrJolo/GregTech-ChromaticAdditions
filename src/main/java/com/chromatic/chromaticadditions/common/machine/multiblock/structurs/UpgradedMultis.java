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
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;

import net.minecraft.network.chat.Component;

import static com.chromatic.chromaticadditions.ChromaticAdditions.HERRJOLO_REGISTRATE;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.frameGt;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.TungstenSteel;

public class UpgradedMultis {

    public static void init() {}

    public static final MultiblockMachineDefinition LARGE_SORTER = HERRJOLO_REGISTRATE
            .multiblock("large_sorter", WorkableElectricMultiblockMachine::new)
            .langValue("§1Large Sorter")
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
}

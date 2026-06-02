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

import net.minecraft.network.chat.Component;

import static com.chromatic.chromaticadditions.ChromaticAdditions.HERRJOLO_REGISTRATE;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.frameGt;
import static com.gregtechceu.gtceu.common.data.GTMaterials.StainlessSteel;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Steel;

public class DeepOreDrillingMachines {

    public static void init() {}

    public static MultiblockMachineDefinition THE_MINER = HERRJOLO_REGISTRATE
            .multiblock("the_miner", WorkableElectricMultiblockMachine::new)
            .langValue("§5Large Biom Miner Deposit Extractor")
            .tooltips(Component.literal("Digs in to deep mineral deposits and extracts raw unrefined mineral Clusters"))
            .tooltips(Component.literal("Does only accept §6One §fEnergy Hatch"))
            .tooltips(Component.literal("Does not accept Parallel Hatches"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(ChromaticRecepieTypes.THEMINER)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .pattern(definition -> {
                return FactoryBlockPattern.start()
                        .aisle("bbbbbbaaaaaaabbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb")
                        .aisle("bbbbaaaaaaaaaaabbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb")
                        .aisle("bbaaaaaaaaaaaaaaabb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb")
                        .aisle("bbaaaaaaaaaaaaaaabb", "bbbbbbbccbccbbbbbbb", "bbbbbbbbcbcbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb")
                        .aisle("baaaaaaaaaaaaaaaaab", "bbbbbbbccbccbbbbbbb", "bbbbbbbccbccbbbbbbb",
                                "bbbbbbbccbccbbbbbbb", "bbbbbbbccbccbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb")
                        .aisle("baaaaaaaaaaaaaaaaab", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbddbddbbbbbbb",
                                "bbbbbbbddbddbbbbbbb", "bbbbbbbddbddbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb")
                        .aisle("aaaaaaaaaaaaaaaaaaa", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbddbddbbbbbbb", "bbbbbbbcccccbbbbbbb", "bbbbbbbddbddbbbbbbb",
                                "bbbbbbbdbbbdbbbbbbb", "bbbbbbbdbbbdbbbbbbb", "bbbbbbbdbbbdbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb")
                        .aisle("aaaaaaaaaaaaaaaaaaa", "bbbccbbbbbbbbbccbbb", "bbbbcbbbbbbbbbcbbbb",
                                "bbbbcbbbbbbbbbcbbbb", "bbbbcbbbbbbbbbcbbbb", "bbbbbdbbbbbbbdbbbbb",
                                "bbbbbddbbbbbddbbbbb", "bbbbbdcbbbbbcdbbbbb", "bbbbbbdbbbbbdbbbbbb",
                                "bbbbbbdbbbbbdbbbbbb", "bbbbbbdbbbbbdbbbbbb", "bbbbbbdbbbbbdbbbbbb",
                                "bbbbbbbdcccdbbbbbbb", "bbbbbbbdbbbdbbbbbbb", "bbbbbbbdbbbdbbbbbbb",
                                "bbbbbbbdbbbdbbbbbbb", "bbbbbbbdbbbdbbbbbbb", "bbbbbbbdddddbbbbbbb",
                                "bbbbbbbdbbbdbbbbbbb", "bbbbbbbbbbbbbbbbbbb")
                        .aisle("aaaaaaaabbbaaaaaaaa", "bbbccbbbbbbbbbccbbb", "bbbccbbbbbbbbbccbbb",
                                "bbbbcbbbbebbbbcbbbb", "bbbbcbbbbfbbbbcbbbb", "bbbbbdbbbfbbbdbbbbb",
                                "bbbbbddbbfbbddbbbbb", "bbbbbdcbfffbcdbbbbb", "bbbbbbdbfffbdbbbbbb",
                                "bbbbbbbbfefbbbbbbbb", "bbbbbbbbfefbbbbbbbb", "bbbbbbbbfefbbbbbbbb",
                                "bbbbbbbcfefcbbbbbbb", "bbbbbbbbfefbbbbbbbb", "bbbbbbbbfefbbbbbbbb",
                                "bbbbbbbbfefbbbbbbbb", "bbbbbbbbfefbbbbbbbb", "bbbbbbbdfefdbbbbbbb",
                                "bbbbbbbbfefbbbbbbbb", "bbbbbbbbfefbbbbbbbb")
                        .aisle("aaaaaaaabbbaaaaaaaa", "bbbbbbbbbgbbbbbbbbb", "bbbbbbbbbgbbbbbbbbb",
                                "bbbbbbbbegebbbbbbbb", "bbbbbbbbfgfbbbbbbbb", "bbbbbbbbfgfbbbbbbbb",
                                "bbbbbbbbfgfbbbbbbbb", "bbbbbbcbfgfbcbbbbbb", "bbbbbbbbfgfbbbbbbbb",
                                "bbbbbbbbegebbbbbbbb", "bbbbbbbbegebbbbbbbb", "bbbbbbbbegebbbbbbbb",
                                "bbbbbbbcegecbbbbbbb", "bbbbbbbbegebbbbbbbb", "bbbbbbbbegebbbbbbbb",
                                "bbbbbbbbegebbbbbbbb", "bbbbbbbbegebbbbbbbb", "bbbbbbbdegedbbbbbbb",
                                "bbbbbbbbegebbbbbbbb", "bbbbbbbbegebbbbbbbb")
                        .aisle("aaaaaaaabbbaaaaaaaa", "bbbccbbbbbbbbbccbbb", "bbbccbbbbbbbbbccbbb",
                                "bbbbcbbbbebbbbcbbbb", "bbbbcbbbbfbbbbcbbbb", "bbbbbdbbbfbbbdbbbbb",
                                "bbbbbddbbfbbddbbbbb", "bbbbbdcbfffbcdbbbbb", "bbbbbbdbfffbdbbbbbb",
                                "bbbbbbbbfefbbbbbbbb", "bbbbbbbbfefbbbbbbbb", "bbbbbbbbfefbbbbbbbb",
                                "bbbbbbbcfefcbbbbbbb", "bbbbbbbbfefbbbbbbbb", "bbbbbbbbfefbbbbbbbb",
                                "bbbbbbbbfefbbbbbbbb", "bbbbbbbbfefbbbbbbbb", "bbbbbbbdfefdbbbbbbb",
                                "bbbbbbbbfefbbbbbbbb", "bbbbbbbbfefbbbbbbbb")
                        .aisle("aaaaaaaaaaaaaaaaaaa", "bbbccbbbbbbbbbccbbb", "bbbbcbbbbbbbbbcbbbb",
                                "bbbbcbbbbbbbbbcbbbb", "bbbbcbbbbbbbbbcbbbb", "bbbbbdbbbbbbbdbbbbb",
                                "bbbbbddbbbbbddbbbbb", "bbbbbdcbbbbbcdbbbbb", "bbbbbbdbbbbbdbbbbbb",
                                "bbbbbbdbbbbbdbbbbbb", "bbbbbbdbbbbbdbbbbbb", "bbbbbbdbbbbbdbbbbbb",
                                "bbbbbbbdcccdbbbbbbb", "bbbbbbbdbbbdbbbbbbb", "bbbbbbbdbbbdbbbbbbb",
                                "bbbbbbbdbbbdbbbbbbb", "bbbbbbbdbbbdbbbbbbb", "bbbbbbbdddddbbbbbbb",
                                "bbbbbbbdbbbdbbbbbbb", "bbbbbbbbbbbbbbbbbbb")
                        .aisle("aaaaaaaaaaaaaaaaaaa", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbddbddbbbbbbb", "bbbbbbbcccccbbbbbbb", "bbbbbbbddbddbbbbbbb",
                                "bbbbbbbdbbbdbbbbbbb", "bbbbbbbdbbbdbbbbbbb", "bbbbbbbdbbbdbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb")
                        .aisle("baaaaaaaaaaaaaaaaab", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbddbddbbbbbbb",
                                "bbbbbbbddbddbbbbbbb", "bbbbbbbddbddbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb")
                        .aisle("baaaaaaaaaaaaaaaaab", "bbbbbbbccbccbbbbbbb", "bbbbbbbccbccbbbbbbb",
                                "bbbbbbbccbccbbbbbbb", "bbbbbbbccbccbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb")
                        .aisle("bbaaaaaaaaaaaaaaabb", "bbbbbbbcKbccbbbbbbb", "bbbbbbbbcbcbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb")
                        .aisle("bbaaaaaaaaaaaaaaabb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb")
                        .aisle("bbbbaaaaaaaaaaabbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb")
                        .aisle("bbbbbbaaaaaaabbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb",
                                "bbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbb")
                        .where("K", Predicates.controller(Predicates.blocks(definition.get())))
                        .where("a", Predicates.blocks(GTBlocks.LIGHT_CONCRETE.get()))
                        .where("b", Predicates.any())
                        .where("c", Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                                .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setExactLimit(1).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setPreviewCount(1)))
                        .where("d", Predicates.blocks(ChemicalHelper.getBlock(frameGt, Steel)))
                        .where("e", Predicates.blocks(ChemicalHelper.getBlock(frameGt, StainlessSteel)))
                        .where("f", Predicates.blocks(GTBlocks.CASING_STAINLESS_CLEAN.get()))
                        .where("g", Predicates.blocks(GTBlocks.CASING_STEEL_GEARBOX.get()))
                        .build();
            })

            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    GTCEu.id("block/multiblock/advanced_processing_array"))
            .register();
}

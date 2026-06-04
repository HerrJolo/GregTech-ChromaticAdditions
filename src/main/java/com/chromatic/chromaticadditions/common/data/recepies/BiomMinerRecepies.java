package com.chromatic.chromaticadditions.common.data.recepies;

import com.chromatic.chromaticadditions.common.data.ChromaticMaterials;
import com.chromatic.chromaticadditions.common.data.ChromaticRecepieTypes;
import com.chromatic.chromaticadditions.common.item.ChromaticItems;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.data.recipe.CustomTags;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.level.biome.Biomes;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class BiomMinerRecepies {

    public static void init(Consumer<FinishedRecipe> provider) {
        // Dirll

        GTRecipeTypes.ASSEMBLY_LINE_RECIPES.recipeBuilder("Tier1_Drill")
                .inputItems(TagPrefix.toolHeadDrill, TungstenSteel, 3)
                .inputItems(GTItems.COMPONENT_GRINDER_DIAMOND, 3)
                .inputItems(TagPrefix.pipeNormalFluid, Potin, 4)
                .inputItems(CustomTags.IV_CIRCUITS, 2)
                .inputItems(GTItems.EMITTER_IV)
                .inputItems(GTItems.SENSOR_IV)
                .inputFluids(StainlessSteel, 288)
                .inputFluids(TungstenSteel, 576)
                .outputItems(ChromaticItems.DRILL_HEAD)
                .scannerResearch(b -> b.researchStack(GTItems.COMPONENT_GRINDER_DIAMOND.asStack()).EUt(8000))
                .duration(800)
                .EUt(7500)
                .save(provider);

        // Drilling Steel

        GTRecipeTypes.MIXER_RECIPES.recipeBuilder("Drilling_Steel_Dust")
                .inputItems(TagPrefix.dust, Steel, 10)
                .inputItems(TagPrefix.dust, Chromium, 2)
                .inputItems(TagPrefix.dust, Nickel, 2)
                .inputItems(TagPrefix.dust, Molybdenum, 2)
                .inputItems(TagPrefix.dust, Carbon, 1)
                .EUt(400)
                .duration(500)
                .outputItems(TagPrefix.dust, ChromaticMaterials.DRILLING_STEEL, 17)
                .save(provider);

        // Miner
        ChromaticRecepieTypes.THEMINER.recipeBuilder("Magnetic_Deposit")
                .chancedInput(ChromaticItems.DRILL_HEAD.asStack(), 500, 0)
                .inputFluids(DrillingFluid, 10)
                .outputItems(TagPrefix.rawOre, ChromaticMaterials.MAGNETIC_MINERAL_CLUSTER, 15)
                .circuitMeta(1)
                .biome(Biomes.STONY_PEAKS)
                .duration(200)
                .EUt(1000)
                .save(provider);

        ChromaticRecepieTypes.THEMINER.recipeBuilder("Porus_Deposit")
                .chancedInput(ChromaticItems.DRILL_HEAD.asStack(), 500, 0)
                .inputFluids(DrillingFluid, 10)
                .outputItems(TagPrefix.rawOre, ChromaticMaterials.PORUS_MINERAL_CLUSTER, 17)
                .circuitMeta(2)
                .biome(Biomes.SWAMP)
                .duration(200)
                .EUt(1000)
                .save(provider);

        ChromaticRecepieTypes.THEMINER.recipeBuilder("Mixed_Deposit")
                .chancedInput(ChromaticItems.DRILL_HEAD.asStack(), 500, 0)
                .inputFluids(DrillingFluid, 10)
                .outputItems(TagPrefix.rawOre, ChromaticMaterials.MIXED_MINERAL_CLUSTER, 12)
                .circuitMeta(3)
                .biome(Biomes.DESERT)
                .duration(250)
                .EUt(1000)
                .save(provider);

        ChromaticRecepieTypes.THEMINER.recipeBuilder("Crystalized_Deposit")
                .chancedInput(ChromaticItems.DRILL_HEAD.asStack(), 500, 0)
                .inputFluids(DrillingFluid, 10)
                .outputItems(TagPrefix.rawOre, ChromaticMaterials.CRYSTALIZED_MINERAL_CLUSTER, 10)
                .circuitMeta(4)
                .biome(Biomes.DEEP_COLD_OCEAN)
                .duration(300)
                .EUt(1000)
                .save(provider);
    }
}

package com.chromatic.chromaticadditions.common.data.recepies;

import com.chromatic.chromaticadditions.common.data.ChromaticMaterials;
import com.chromatic.chromaticadditions.common.data.ChromaticRecepieTypes;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

public class SorterRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        ChromaticRecepieTypes.SORTER.recipeBuilder("Magnetic_Mineral_Sorting")
                .inputItems(TagPrefix.rawOre, ChromaticMaterials.MAGNETIC_MINERAL_CLUSTER, 5)
                .chancedOutput(new ItemStack(Blocks.COBBLESTONE), 8000, 0)
                .chancedOutput(TagPrefix.rawOre, GTMaterials.Limonite, 4000, 0)
                .chancedOutput(TagPrefix.rawOre, GTMaterials.Magnetite, 3000, 0)
                .chancedOutput(TagPrefix.rawOre, GTMaterials.Pentlandite, 2000, 0)
                .chancedOutput(TagPrefix.rawOre, GTMaterials.Cobaltite, 1000, 0)
                .duration(400)
                .EUt(250)
                .circuitMeta(1)
                .save(provider);

        ChromaticRecepieTypes.SORTER.recipeBuilder("Phorus_Mineral_Sorting")
                .inputItems(TagPrefix.rawOre, ChromaticMaterials.PORUS_MINERAL_CLUSTER, 5)
                .chancedOutput(new ItemStack(Blocks.COBBLESTONE), 8000, 0)
                .chancedOutput(TagPrefix.rawOre, GTMaterials.Copper, 4000, 0)
                .chancedOutput(TagPrefix.rawOre, GTMaterials.Cassiterite, 3000, 0)
                .chancedOutput(TagPrefix.rawOre, GTMaterials.Kyanite, 2500, 0)
                .chancedOutput(TagPrefix.rawOre, GTMaterials.Electrotine, 2000, 0)
                .duration(400)
                .EUt(250)
                .circuitMeta(1)
                .save(provider);

        ChromaticRecepieTypes.SORTER.recipeBuilder("Crystalized_Mineral_Sorting")
                .inputItems(TagPrefix.rawOre, ChromaticMaterials.CRYSTALIZED_MINERAL_CLUSTER, 5)
                .chancedOutput(new ItemStack(Blocks.COBBLESTONE), 8000, 0)
                .chancedOutput(TagPrefix.rawOre, GTMaterials.GreenSapphire, 3000, 0)
                .chancedOutput(TagPrefix.rawOre, GTMaterials.GarnetRed, 3000, 0)
                .chancedOutput(TagPrefix.rawOre, GTMaterials.GarnetYellow, 3000, 0)
                .chancedOutput(TagPrefix.rawOre, GTMaterials.Topaz, 1000, 0)
                .duration(400)
                .EUt(250)
                .circuitMeta(1)
                .save(provider);

        ChromaticRecepieTypes.SORTER.recipeBuilder("Mixed_Mineral_Sorting")
                .inputItems(TagPrefix.rawOre, ChromaticMaterials.MIXED_MINERAL_CLUSTER, 5)
                .chancedOutput(new ItemStack(Blocks.COBBLESTONE), 8000, 0)
                .chancedOutput(TagPrefix.rawOre, GTMaterials.Sulfur, 3000, 0)
                .chancedOutput(TagPrefix.rawOre, GTMaterials.TricalciumPhosphate, 3500, 0)
                .chancedOutput(TagPrefix.rawOre, GTMaterials.Asbestos, 2000, 0)
                .chancedOutput(TagPrefix.rawOre, GTMaterials.Lapis, 1500, 0)
                .duration(400)
                .EUt(250)
                .circuitMeta(1)
                .save(provider);

        ChromaticRecepieTypes.SORTER.recipeBuilder("Rare_Mineral_Sorting")
                .inputItems(TagPrefix.rawOre, ChromaticMaterials.RARE_MINERAL_CLUSTER, 5)
                .chancedOutput(new ItemStack(Blocks.COBBLESTONE), 8000, 0)
                .chancedOutput(TagPrefix.rawOre, GTMaterials.Gold, 1500, 0)
                .chancedOutput(TagPrefix.rawOre, GTMaterials.Silver, 1500, 0)
                .chancedOutput(TagPrefix.rawOre, GTMaterials.Tantalite, 1500, 0)
                .chancedOutput(TagPrefix.rawOre, GTMaterials.VanadiumMagnetite, 1500, 0)
                .duration(400)
                .EUt(250)
                .circuitMeta(1)
                .save(provider);

        ChromaticRecepieTypes.SORTER.recipeBuilder("Precious_Metals_Sorting")
                .inputItems(TagPrefix.rawOre, ChromaticMaterials.PRECIOUS_METALS, 5)
                .inputFluids(GTMaterials.AquaRegia, 100)
                .chancedOutput(TagPrefix.dust, GTMaterials.Stone, 8000, 0)
                .chancedOutput(TagPrefix.dust, GTMaterials.MetalMixture, 3, 6000, 0)
                .chancedOutput(TagPrefix.rawOre, GTMaterials.Copper, 5000, 0)
                .chancedOutput(TagPrefix.rawOre, GTMaterials.Gold, 3500, 0)
                .chancedOutput(TagPrefix.rawOre, GTMaterials.Silver, 3500, 0)
                .duration(400)
                .EUt(250)
                .circuitMeta(1)
                .save(provider);
    }
}

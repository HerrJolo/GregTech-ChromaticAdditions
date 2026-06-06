package com.chromatic.chromaticadditions.common.data.recepies;

import com.chromatic.chromaticadditions.common.data.ChromaticMaterials;
import com.chromatic.chromaticadditions.common.data.ChromaticRecepieTypes;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

public class RiverPumpRecipec {

    public static void init(Consumer<FinishedRecipe> provider) {

        ChromaticRecepieTypes.LARGERIVERPUMP.recipeBuilder("Water_Extraction")
                .notConsumable(TagPrefix.pipeNormalFluid, GTMaterials.Wood, 16)
                .outputFluids(GTMaterials.Water.getFluid(500))
                .biome(Biomes.RIVER)
                .duration(100)
                .save(provider);

        ChromaticRecepieTypes.LARGERIVERPUMP.recipeBuilder("Mud_Extraction")
                .notConsumable(TagPrefix.pipeLargeFluid, GTMaterials.Wood, 16)
                .outputFluids(ChromaticMaterials.RIVERMUD.getFluid(250))
                .biome(Biomes.RIVER)
                .duration(100)
                .save(provider);

        ChromaticRecepieTypes.LARGERIVERPUMP.recipeBuilder("Water_Extraction2")
                .notConsumable(TagPrefix.pipeNormalFluid, GTMaterials.TreatedWood, 8)
                .outputFluids(GTMaterials.Water.getFluid(1000))
                .biome(Biomes.RIVER)
                .duration(100)
                .save(provider);

        ChromaticRecepieTypes.LARGERIVERPUMP.recipeBuilder("Mud_Extraction2")
                .notConsumable(TagPrefix.pipeLargeFluid, GTMaterials.TreatedWood, 8)
                .outputFluids(ChromaticMaterials.RIVERMUD.getFluid(500))
                .biome(Biomes.RIVER)
                .duration(100)
                .save(provider);
    }
}
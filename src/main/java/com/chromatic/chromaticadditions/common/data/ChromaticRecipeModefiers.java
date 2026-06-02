package com.chromatic.chromaticadditions.common.data;

import com.gregtechceu.gtceu.api.recipe.content.ContentModifier;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.api.recipe.modifier.ParallelLogic;
import com.gregtechceu.gtceu.api.recipe.modifier.RecipeModifier;

import java.util.function.IntFunction;

public class ChromaticRecipeModefiers {

    // Code made by .vertyx. for https://github.com/tvertyx/Gregtech-Extra-Additions go check it out its awesom work
    // modified by me

    private static final int MAX_SIMPLE_PARALLEL = 16;

    public static final IntFunction<RecipeModifier> SIMPLE_PARALLEL = parallels -> {
        if (parallels < 1 || parallels > MAX_SIMPLE_PARALLEL) {
            throw new IllegalArgumentException(
                    "SIMPLE_PARALLEL count must be between 1 and " + MAX_SIMPLE_PARALLEL + ", got " + parallels);
        }
        if (parallels == 1) return RecipeModifier.NO_MODIFIER;

        return (machine, recipe) -> {
            int achievable = ParallelLogic.getParallelAmountWithoutEU(machine, recipe, parallels);
            if (achievable <= 1) return ModifierFunction.IDENTITY;
            return ModifierFunction.builder()
                    .modifyAllContents(ContentModifier.multiplier(achievable))
                    .durationMultiplier(2)
                    .parallels(achievable)
                    .build();
        };
    };
}

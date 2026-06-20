package com.chromatic.chromaticadditions.mixin;


import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GTRecipeTypes.class, remap = false)
public class RecipeTypeMixin{

    @Shadow
    @Final
    public static GTRecipeType ASSEMBLER_RECIPES;

    @Shadow
    @Final
    public static GTRecipeType FLUID_SOLIDFICATION_RECIPES;

    @Shadow
    @Final
    public static GTRecipeType MIXER_RECIPES;

    @Shadow
    @Final
    public static GTRecipeType LASER_ENGRAVER_RECIPES;



    @Inject(method = "init", at = @At(value = "TAIL"), remap = false)
    private static void chromatic$chromaticmixin(CallbackInfo ci) {


        ASSEMBLER_RECIPES.setMaxIOSize(9, 1, 3, 0);

        FLUID_SOLIDFICATION_RECIPES.setMaxIOSize(2, 1, 2, 0);

        MIXER_RECIPES.setMaxIOSize(6, 1, 3, 1);

        LASER_ENGRAVER_RECIPES.setMaxIOSize(3, 1, 0, 0);

    }

}

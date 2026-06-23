package com.chromatic.chromaticadditions.common.machine;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.content.ContentModifier;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.api.recipe.modifier.RecipeModifier;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

@Slf4j
public class WorkableTreeGreenhouseMachine extends WorkableElectricMultiblockMachine {

    public WorkableTreeGreenhouseMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    private int RunningTimer = 0;

    private static final FluidStack WATER_STACK = GTMaterials.Water.getFluid(10);

    private static final ItemStack FERTILIZER_STACK = new ItemStack(GTItems.FERTILIZER, 2);

    protected boolean FertilizerBoost = false;

    protected GTRecipe getFluidRecipe() {
        return GTRecipeBuilder.ofRaw().inputFluids(WATER_STACK).buildRawRecipe();
    }

    protected GTRecipe getBoostRecipe() {
        return GTRecipeBuilder.ofRaw().inputItems(FERTILIZER_STACK).perTick(false).buildRawRecipe();
    }

    public static ModifierFunction recipeModifier(@NotNull MetaMachine machine, @NotNull GTRecipe recipe) {
        if (!(machine instanceof WorkableTreeGreenhouseMachine GreenhouseMachine)) {
            return RecipeModifier.nullWrongType(WorkableFruitedGreenhouseMachine.class, machine);
        }
        // has lubricant
        if (RecipeHelper.matchRecipe(GreenhouseMachine, GreenhouseMachine.getBoostRecipe()).isSuccess()) {

            return ModifierFunction.builder()
                    .outputModifier(ContentModifier.multiplier(2))
                    .build();
        }
        return ModifierFunction.IDENTITY;
    }

    @Override
    public boolean onWorking() {
        boolean value = super.onWorking();
        // check Fluid

        if (RunningTimer == 1) {
            // insufficient lubricant
            if (!RecipeHelper.handleRecipeIO(this, getFluidRecipe(), IO.IN, this.recipeLogic.getChanceCaches())
                    .isSuccess()) {
                recipeLogic.setStatus(RecipeLogic.Status.SUSPEND);
                return true;
            }
        }

        if (recipeLogic.getProgress() == 1) {

            this.FertilizerBoost = RecipeHelper.matchRecipe(this, getBoostRecipe()).isSuccess() &&
                    RecipeHelper.handleRecipeIO(this, getBoostRecipe(), IO.IN, this.recipeLogic.getChanceCaches())
                            .isSuccess();

        }

        RunningTimer++;
        if (RunningTimer > 20) RunningTimer %= 20; // reset once every hour of running

        return value;
    }
}

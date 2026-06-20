package com.chromatic.chromaticadditions.common.machine;

import com.chromatic.chromaticadditions.common.data.ChromaticMaterials;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.transfer.fluid.FluidHandlerList;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.gregtechceu.gtceu.utils.GTUtil;
import lombok.extern.slf4j.Slf4j;
import net.minecraftforge.fluids.FluidStack;

import static com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder.ofRaw;

@Slf4j
public class WorkableFruitedGreenhouseMachine extends WorkableElectricMultiblockMachine {

    public WorkableFruitedGreenhouseMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    private int RunningTimer = 0;

    private static final FluidStack WATER_STACK = GTMaterials.Water.getFluid(1);

    protected GTRecipe getFluidRecipe() {
        return GTRecipeBuilder.ofRaw().inputFluids(WATER_STACK).buildRawRecipe();
    }


    @Override
    public boolean onWorking() {
        boolean value = super.onWorking();
        // check lubricant

        log.info("Is Working");
        if (RunningTimer == 1) {
            // insufficient lubricant
            if (!RecipeHelper.handleRecipeIO(this, getFluidRecipe(), IO.IN, this.recipeLogic.getChanceCaches())
                    .isSuccess()) {
                recipeLogic.setStatus(RecipeLogic.Status.SUSPEND);
                return true;
            }
        }

        RunningTimer++;
        if (RunningTimer > 10) RunningTimer %= 10; // reset once every hour of running

        return value;
    }
}

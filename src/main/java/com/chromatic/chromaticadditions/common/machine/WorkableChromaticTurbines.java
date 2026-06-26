package com.chromatic.chromaticadditions.common.machine;

import com.chromatic.chromaticadditions.common.data.ChromaticMaterials;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.ITurbineMachine;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.capability.recipe.RecipeCapability;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.fancy.IFancyTooltip;
import com.gregtechceu.gtceu.api.gui.fancy.TooltipsPanel;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.ITieredMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IRotorHolderMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockDisplayText;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.content.ContentModifier;
import com.gregtechceu.gtceu.api.recipe.ingredient.EnergyStack;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.api.recipe.modifier.ParallelLogic;
import com.gregtechceu.gtceu.api.recipe.modifier.RecipeModifier;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.gregtechceu.gtceu.utils.FormattingUtil;

import com.gregtechceu.gtceu.utils.GTMath;
import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;

import lombok.Getter;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class WorkableChromaticTurbines extends WorkableElectricMultiblockMachine implements ITieredMachine, ITurbineMachine {

    public static final int MIN_DURABILITY_TO_WARN = 10;

    private final long BASE_EU_OUTPUT;
    @Getter
    private final int tier;

    private int runningTimer  = 0;

    private static final FluidStack LUBRICANT_STACK = GTMaterials.Lubricant.getFluid(4);
    private static final FluidStack GOOD_LUBRICANT_STACK = ChromaticMaterials.GOOD_LUBRICANT.getFluid(2);
    private static final FluidStack PERFECTED_LUBRICANT_STACK = ChromaticMaterials.PERFECTED_LUBRICANT.getFluid(1);


    private boolean isLubricantDiscounted = false;
    private boolean isGoodLubricantDiscounted = false;
    private boolean isPerfectLubricantDiscounted = false;


    public WorkableChromaticTurbines(IMachineBlockEntity holder, int tier) {
        super(holder);
        this.tier = tier;
        this.BASE_EU_OUTPUT = GTValues.V[tier] * 2;
    }

    protected GTRecipe getLubricantRecipe() {
        return GTRecipeBuilder.ofRaw().inputFluids(LUBRICANT_STACK).buildRawRecipe();
    }

    protected GTRecipe getGoodLubricantRecipe() {
        return GTRecipeBuilder.ofRaw().inputFluids(GOOD_LUBRICANT_STACK).buildRawRecipe();
    }

    protected GTRecipe getPerfectedLubricantRecipe() {
        return GTRecipeBuilder.ofRaw().inputFluids(PERFECTED_LUBRICANT_STACK).buildRawRecipe();
    }


    @Nullable
    private IRotorHolderMachine getRotorHolder() {
        for (IMultiPart part : getParts()) {
            if (part instanceof IRotorHolderMachine rotorHolder) {
                return rotorHolder;
            }
        }
        return null;
    }




    @Override
    public long getOverclockVoltage() {
        var rotorHolder = getRotorHolder();
        if (rotorHolder != null && rotorHolder.hasRotor())
            return BASE_EU_OUTPUT * rotorHolder.getTotalPower() / 100;
        return 0;
    }




    /**
     * @return EUt multiplier that should be applied to the turbine's output
     */
    protected double productionBoost() {
        var rotorHolder = getRotorHolder();
        if (rotorHolder != null && rotorHolder.hasRotor()) {
            int maxSpeed = rotorHolder.getMaxRotorHolderSpeed();
            int currentSpeed = rotorHolder.getRotorSpeed();
            if (currentSpeed >= maxSpeed) return 1;
            return Math.pow(1.0 * currentSpeed / maxSpeed, 2);
        }
        return 0;
    }





    @Override
    public boolean hasRotor() {
        var rotorHolder = getRotorHolder();
        return rotorHolder != null && rotorHolder.hasRotor();
    }




    @Override
    public int getRotorSpeed() {
        var rotorHolder = getRotorHolder();
        if (rotorHolder != null && rotorHolder.hasRotor()) {
            return rotorHolder.getRotorSpeed();
        }
        return 0;
    }





    @Override
    public int getMaxRotorHolderSpeed() {
        var rotorHolder = getRotorHolder();
        if (rotorHolder != null && rotorHolder.hasRotor()) {
            return rotorHolder.getMaxRotorHolderSpeed();
        }
        return 0;
    }





    @Override
    public int getTotalEfficiency() {
        var rotorHolder = getRotorHolder();
        if (rotorHolder != null && rotorHolder.hasRotor()) {
            return rotorHolder.getTotalEfficiency();
        }
        return -1;
    }




    @Override
    public long getCurrentProduction() {
        return isActive() && recipeLogic.getLastRecipe() != null ?
                recipeLogic.getLastRecipe().getOutputEUt().voltage() : 0;
    }




    @Override
    public int getRotorDurabilityPercent() {
        var rotorHolder = getRotorHolder();
        if (rotorHolder != null && rotorHolder.hasRotor()) {
            return rotorHolder.getRotorDurabilityPercent();
        }
        return -1;
    }

    protected double getGoodLubeProductionBoost() {
        if (!isGoodLubricantDiscounted) return 1;
        return 1.05;
    }

    protected double getPerfectedLubeProductionBoost() {
        if (!isPerfectLubricantDiscounted) return 1;
        return 1.10;
    }

    //////////////////////////////////////
    // ****** Recipe Logic *******//
    //////////////////////////////////////
    /**
     * Recipe Modifier for <b>Large Turbine Multiblocks</b> - can be used as a valid {@link RecipeModifier}
     * <p>
     * Recipe is fast parallelized up to {@code (baseEUt * power) / recipeEUt} times.
     * Duration is then multiplied by the holder efficiency.
     * </p>
     *
     * @param machine a {@link WorkableChromaticTurbines}
     * @param recipe  recipe
     * @return A {@link ModifierFunction} for the given Turbine Multiblock and recipe
     */
    public static ModifierFunction recipeModifier(@NotNull MetaMachine machine, @NotNull GTRecipe recipe) {
        if (!(machine instanceof WorkableChromaticTurbines turbineMachine)) {
            return RecipeModifier.nullWrongType(WorkableChromaticTurbines.class, machine);
        }

        var rotorHolder = turbineMachine.getRotorHolder();
        if (rotorHolder == null) return ModifierFunction.NULL;

        EnergyStack EUt = recipe.getOutputEUt();
        long turbineMaxVoltage = turbineMachine.getOverclockVoltage();
        double holderEfficiency = rotorHolder.getTotalEfficiency() / 100.0;

        if (EUt.isEmpty() || turbineMaxVoltage <= EUt.voltage() || holderEfficiency <= 0) return ModifierFunction.NULL;

        // get the amount of parallel required to match the desired output voltage
        // Max Parallel is Ceilinged not Floored to ensure the output voltage is actually met,
        // at the cost of slightly increased fuel
        int maxParallel = (int) (turbineMaxVoltage / EUt.getTotalEU());
        if (turbineMaxVoltage % EUt.getTotalEU() != 0) maxParallel++;

        int actualParallel = ParallelLogic.getParallelAmountFast(turbineMachine, recipe, maxParallel);
        double eutMultiplier = (maxParallel == actualParallel) ?
                turbineMachine.productionBoost() * turbineMaxVoltage / EUt.voltage() :
                turbineMachine.productionBoost() * actualParallel;

        return ModifierFunction.builder()
                .inputModifier(ContentModifier.multiplier(actualParallel))
                .outputModifier(ContentModifier.multiplier(actualParallel))
                .eutMultiplier(eutMultiplier * turbineMachine.getGoodLubeProductionBoost() * turbineMachine.getPerfectedLubeProductionBoost())
                .parallels(actualParallel)
                .durationMultiplier(holderEfficiency)
                .build();
    }

    @Override
    public boolean onWorking() {
        boolean value = super.onWorking();
        // check lubricant

        if (runningTimer % 72 == 0) {
            // insufficient lubricant
            if ((RecipeHelper.handleRecipeIO(this, getLubricantRecipe(), IO.IN, this.recipeLogic.getChanceCaches()).isSuccess()) ||
                    (RecipeHelper.handleRecipeIO(this, getGoodLubricantRecipe(), IO.IN, this.recipeLogic.getChanceCaches()).isSuccess()) ||
                    (RecipeHelper.handleRecipeIO(this, getPerfectedLubricantRecipe(), IO.IN, this.recipeLogic.getChanceCaches()).isSuccess())) {
                recipeLogic.setStatus(RecipeLogic.Status.WORKING);
            } else {
                recipeLogic.setStatus(RecipeLogic.Status.SUSPEND);
                return true;
            }
        }

        if (recipeLogic.getProgress() == 1) {
            var LubricantRecipe = getLubricantRecipe();
            this.isLubricantDiscounted = RecipeHelper.matchRecipe(this, LubricantRecipe).isSuccess() &&
                    RecipeHelper.handleRecipeIO(this, LubricantRecipe, IO.IN, this.recipeLogic.getChanceCaches())
                            .isSuccess();
        }

        if (recipeLogic.getProgress() == 1) {
            var GoodLubricantRecipe = getGoodLubricantRecipe();
            this.isGoodLubricantDiscounted = RecipeHelper.matchRecipe(this, GoodLubricantRecipe).isSuccess() &&
                    RecipeHelper.handleRecipeIO(this, GoodLubricantRecipe, IO.IN, this.recipeLogic.getChanceCaches())
                            .isSuccess();
        }
        if (recipeLogic.getProgress() == 1) {
            var PerfectLubricantRecipe = getPerfectedLubricantRecipe();
            this.isPerfectLubricantDiscounted = RecipeHelper.matchRecipe(this, PerfectLubricantRecipe).isSuccess() &&
                    RecipeHelper.handleRecipeIO(this, PerfectLubricantRecipe, IO.IN, this.recipeLogic.getChanceCaches())
                            .isSuccess();
        }

        runningTimer++;
        if (runningTimer > 72000) runningTimer %= 72000; // reset once every hour of running
        return value;
    }



    @Override
    public boolean regressWhenWaiting() {
        return false;
    }

    @Override
    public boolean canVoidRecipeOutputs(RecipeCapability<?> capability) {
        // void both eu and fluid tick outputs
        return true;
    }

    //////////////////////////////////////
    // ******* GUI ********//
    //////////////////////////////////////

    @Override
    public void addDisplayText(List<Component> textList) {
        MultiblockDisplayText.Builder builder = MultiblockDisplayText.builder(textList, isFormed())
                .setWorkingStatus(recipeLogic.isWorkingEnabled(), recipeLogic.isActive());

        var rotorHolder = getRotorHolder();

        long currentProduction = getCurrentProduction();

        if (isActive() && isWorkingEnabled()) {
            builder.addCurrentEnergyProductionLine((currentProduction));


        }

        if (rotorHolder != null && rotorHolder.getRotorEfficiency() > 0) {
            textList.add(Component.translatable("gtceu.multiblock.turbine.rotor_speed",
                    FormattingUtil.formatNumbers(rotorHolder.getRotorSpeed()),
                    FormattingUtil.formatNumbers(rotorHolder.getMaxRotorHolderSpeed())));
            textList.add(Component.translatable("gtceu.multiblock.turbine.efficiency",
                    rotorHolder.getTotalEfficiency()));

            int rotorDurability = rotorHolder.getRotorDurabilityPercent();
            if (rotorDurability > MIN_DURABILITY_TO_WARN) {
                textList.add(Component.translatable("gtceu.multiblock.turbine.rotor_durability", rotorDurability));
            } else {
                textList.add(Component.translatable("gtceu.multiblock.turbine.rotor_durability", rotorDurability)
                        .setStyle(Style.EMPTY.withColor(ChatFormatting.RED)));
            }
        }

        if (isFormed && isLubricantDiscounted) {
            builder.addCustom(tl -> tl.add(Component.literal("Has No Lubricant Boost").withStyle(ChatFormatting.DARK_GREEN)));
        }
        if (isFormed && isGoodLubricantDiscounted) {
            builder.addCustom(tl -> tl.add(Component.literal("Has 5% Lubricant Boost").withStyle(ChatFormatting.DARK_GREEN)));
        }
        if (isFormed && isPerfectLubricantDiscounted) {
            builder.addCustom(tl -> tl.add(Component.literal("Has 10% Lubricant Boost").withStyle(ChatFormatting.DARK_GREEN)));
        }

        builder.addWorkingStatusLine();
    }


}

package com.chromatic.chromaticadditions.common.machine;

import com.chromatic.chromaticadditions.common.data.ChromaticMaterials;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.fancy.IFancyTooltip;
import com.gregtechceu.gtceu.api.gui.fancy.TooltipsPanel;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.ITieredMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockDisplayText;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.pattern.util.RelativeDirection;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.content.ContentModifier;
import com.gregtechceu.gtceu.api.recipe.ingredient.EnergyStack;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.api.recipe.modifier.ParallelLogic;
import com.gregtechceu.gtceu.api.recipe.modifier.RecipeModifier;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.machine.multiblock.generator.LargeCombustionEngineMachine;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.gregtechceu.gtceu.utils.GTMath;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

import lombok.Getter;
import javax.annotation.ParametersAreNonnullByDefault;
import net.minecraft.MethodsReturnNonnullByDefault;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.List;


@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class WorkableChromaticEngines extends WorkableElectricMultiblockMachine implements ITieredMachine{

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            WorkableChromaticEngines.class, WorkableMultiblockMachine.MANAGED_FIELD_HOLDER);

    private static final FluidStack OXYGEN_STACK = GTMaterials.Oxygen.getFluid(1);
    private static final FluidStack LIQUID_OXYGEN_STACK = GTMaterials.Oxygen.getFluid(FluidStorageKeys.LIQUID, 4);
    private static final FluidStack LUBRICANT_STACK = GTMaterials.Lubricant.getFluid(4);
    private static final FluidStack GOOD_LUBRICANT_STACK = ChromaticMaterials.GOOD_LUBRICANT.getFluid(2);
    private static final FluidStack PERFECTED_LUBRICANT_STACK = ChromaticMaterials.PERFECTED_LUBRICANT.getFluid(1);



    @Getter
    private final int tier;
    //runtime
    @DescSynced
    private boolean isOxygenBoosted = false;
    private boolean isLubricantDiscounted = false;
    private boolean isGoodLubricantDiscounted = false;
    private boolean isPerfectLubricantDiscounted = false;

    private int runningTimer = 0;

    public WorkableChromaticEngines(IMachineBlockEntity holder, int tier) {
        super(holder);
        this.tier = tier;
    }


    private boolean isIntakesObstructed() {
             for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                            // Skip the controller block itself
                            if (i == 0 && j == 0) continue;
                            var blockPos = RelativeDirection.offsetPos(getPos(), getFrontFacing(), getUpwardsFacing(), isFlipped(),
                             i, j, 1);
                            var blockState = this.getLevel().getBlockState(blockPos);
                            if (!blockState.isAir())
                                return true;
                        }
                }
            return false;
        }

    private boolean isExtreme() {
        return getTier() > GTValues.EV;
    }

    public boolean isBoostAllowed() {
       return getMaxVoltage() >= GTValues.V[getTier() + 1];
    }

    //////////////////////////////////////
    // ****** Recipe Logic *******//
    //////////////////////////////////////

    @Override
    public long getOverclockVoltage() {
        if (isOxygenBoosted) return GTValues.V[tier] * 2;
        else return GTValues.V[tier];
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

    protected GTRecipe getBoostRecipe() {
        return GTRecipeBuilder.ofRaw().inputFluids(isExtreme() ? LIQUID_OXYGEN_STACK : OXYGEN_STACK).buildRawRecipe();
    }

    /**
     * @return EUt multiplier that should be applied to the engine's output
     */
    protected double getProductionBoost() {
        if (!isOxygenBoosted) return 1;
        return isExtreme() ? 2.0 : 1.5;
    }

    protected double getGoodLubeProductionBoost() {
        if (!isGoodLubricantDiscounted) return 1;
        return 1.05;
    }

    protected double getPerfectedLubeProductionBoost() {
        if (!isPerfectLubricantDiscounted) return 1;
        return 1.10;
    }

    /**
     * Recipe Modifier for <b>Combustion Engine Multiblocks</b> - can be used as a valid {@link RecipeModifier}
     * <p>
     * Recipe is rejected if the machine's intakes are obstructed or if it doesn't have lubricant<br>
     * Recipe is parallelized up to {@code desiredEUt / recipeEUt} times.
     * EUt is further multiplied by the production boost of the engine.
     *
     * @param machine a {@link WorkableChromaticEngines}
     * @param recipe  recipe
     * @return A {@link ModifierFunction} for the given Combustion Engine
     */
    public static ModifierFunction recipeModifier(@NotNull MetaMachine machine, @NotNull GTRecipe recipe) {
       if (!(machine instanceof WorkableChromaticEngines engineMachine)) {
           return RecipeModifier.nullWrongType(WorkableChromaticEngines.class, machine);
       }
       EnergyStack EUt = recipe.getOutputEUt();
       // has lubricant
       if (!EUt.isEmpty() && !engineMachine.isIntakesObstructed()) {

           int maxParallel = (int) (engineMachine.getOverclockVoltage() / EUt.getTotalEU()); // get maximum parallel

           int actualParallel = ParallelLogic.getParallelAmount(engineMachine, recipe, maxParallel);

           double eutMultiplier = actualParallel * engineMachine.getProductionBoost() * engineMachine.getGoodLubeProductionBoost() * engineMachine.getPerfectedLubeProductionBoost();

           return ModifierFunction.builder()
                   .inputModifier(ContentModifier.multiplier(actualParallel))
                   .outputModifier(ContentModifier.multiplier(actualParallel))
                   .eutMultiplier(eutMultiplier)
                   .parallels(actualParallel)
                   .build();
       }
    return ModifierFunction.NULL;
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
        //check boost fluid
        if (isBoostAllowed()) {
            var boosterRecipe = getBoostRecipe();
            this.isOxygenBoosted = RecipeHelper.matchRecipe(this, boosterRecipe).isSuccess() &&
                    RecipeHelper.handleRecipeIO(this, boosterRecipe, IO.IN, this.recipeLogic.getChanceCaches())
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


    //////////////////////////////////////
    // ******* GUI ********//
    //////////////////////////////////////

    @Override
    public void addDisplayText(List<Component> textList) {
        MultiblockDisplayText.Builder builder = MultiblockDisplayText.builder(textList, isFormed())
                .setWorkingStatus(recipeLogic.isWorkingEnabled(), recipeLogic.isActive());

        long lastEUt = recipeLogic.getLastRecipe() != null ?
                recipeLogic.getLastRecipe().getOutputEUt().getTotalEU() : 0;
        if (isExtreme()) {
            builder.addEnergyProductionLine(GTValues.V[tier + 1], lastEUt);
        } else {
            builder.addEnergyProductionAmpsLine(GTValues.V[tier] * 3, 3);
        }

        if (isActive() && isWorkingEnabled()) {
            builder.addCurrentEnergyProductionLine(lastEUt);
        }

        builder.addFuelNeededLine(getRecipeFluidInputInfo(), recipeLogic.getDuration());

        if (isFormed && isOxygenBoosted) {
            final var key = isExtreme() ? "gtceu.multiblock.large_combustion_engine.liquid_oxygen_boosted" :
                    "gtceu.multiblock.large_combustion_engine.oxygen_boosted";
            builder.addCustom(tl -> tl.add(Component.translatable(key).withStyle(ChatFormatting.AQUA)));
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

    @Nullable
    public String getRecipeFluidInputInfo() {
        // Previous Recipe is always null on first world load, so try to acquire a new recipe
        GTRecipe recipe = recipeLogic.getLastRecipe();
        if (recipe == null) {
            Iterator<GTRecipe> iterator = recipeLogic.searchRecipe();
            recipe = iterator.hasNext() ? iterator.next() : null;
            if (recipe == null) return null;
        }
        FluidStack requiredFluidInput = RecipeHelper.getInputFluids(recipe).get(0);

        long ocAmount = getMaxVoltage() / recipe.getOutputEUt().getTotalEU();
        int neededAmount = GTMath.saturatedCast(ocAmount * requiredFluidInput.getAmount());
        return ChatFormatting.RED + FormattingUtil.formatNumbers(neededAmount) + "mB";
    }

    @Override
    public void attachTooltips(TooltipsPanel tooltipsPanel) {
        super.attachTooltips(tooltipsPanel);
        tooltipsPanel.attachTooltips(new IFancyTooltip.Basic(
                () -> GuiTextures.INDICATOR_NO_STEAM.get(false),
                () -> List.of(Component.translatable("gtceu.multiblock.large_combustion_engine.obstructed")
                        .setStyle(Style.EMPTY.withColor(ChatFormatting.RED))),
                this::isIntakesObstructed,
                () -> null));
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }


}

package com.chromatic.chromaticadditions.common.data;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;
import com.gregtechceu.gtceu.utils.ResearchManager;

import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;

import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.MULTIBLOCK;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.register;

public class ChromaticRecepieTypes {

    public static GTRecipeType EMLINE;
    public static GTRecipeType ADVANCED_EMLINE;

    public static void init() {
        EMLINE = register("electric_assembly_line", MULTIBLOCK)
                .setEUIO(IO.IN)
                .setMaxIOSize(6, 1, 3, 0)
                .setSlotOverlay(false, false, GuiTextures.CIRCUIT_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.ASSEMBLER);

        ADVANCED_EMLINE = register("smd_manufactur", MULTIBLOCK)
                .setEUIO(IO.IN)
                .setMaxIOSize(6, 1, 3, 0)
                .setSlotOverlay(false, false, GuiTextures.CIRCUIT_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setHasResearchSlot(true)
                .onRecipeBuild(ResearchManager::createDefaultResearchRecipe)
                .setSound(GTSoundEntries.ASSEMBLER);
    }
}

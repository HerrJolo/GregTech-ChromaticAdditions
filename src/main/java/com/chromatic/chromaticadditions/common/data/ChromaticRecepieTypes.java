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
    public static GTRecipeType SORTER;
    public static GTRecipeType THEMINER;
    public static GTRecipeType PRECISONASSEMBLER;
    public static GTRecipeType LARGERIVERPUMP;
    public static GTRecipeType PRIMITIVEMIXER;
    public static GTRecipeType PRIMITIVEPRESS;




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

        SORTER = register("Sortiting", MULTIBLOCK)
                .setEUIO(IO.IN)
                .setMaxIOSize(2, 9, 1, 0)
                .setSlotOverlay(false, false, GuiTextures.CENTRIFUGE_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .onRecipeBuild(ResearchManager::createDefaultResearchRecipe)
                .setSound(GTSoundEntries.CENTRIFUGE);

        THEMINER = register("Biome_Miner", MULTIBLOCK)
                .setEUIO(IO.IN)
                .setMaxIOSize(2, 1, 1, 0)
                .setSlotOverlay(false, false, GuiTextures.HAMMER_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.MACERATOR);

        PRECISONASSEMBLER = register("Precison_Assembeling", MULTIBLOCK)
                .setEUIO(IO.IN)
                .setMaxIOSize(9, 1, 3, 0)
                .setSlotOverlay(false, false, GuiTextures.CENTRIFUGE_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.ASSEMBLER);

        LARGERIVERPUMP = register("large_river_pump", MULTIBLOCK)
                .setEUIO(IO.IN)
                .setMaxIOSize(1, 1, 0, 1)
                .setSlotOverlay(false, false, GuiTextures.CENTRIFUGE_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.BOILER);

        PRIMITIVEMIXER = register("primitive_mixer", MULTIBLOCK)
                .setEUIO(IO.IN)
                .setMaxIOSize(6, 1, 2, 0)
                .setSlotOverlay(false, false, GuiTextures.CENTRIFUGE_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.MIXER);

        PRIMITIVEPRESS = register("primitive_press", MULTIBLOCK)
                .setEUIO(IO.IN)
                .setMaxIOSize(2, 1, 0, 0)
                .setSlotOverlay(false, false, GuiTextures.CENTRIFUGE_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.MIXER);
    }
}

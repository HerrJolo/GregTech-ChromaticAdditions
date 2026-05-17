package com.chromatic.chromaticadditions.common.data;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;
import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;

import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.MULTIBLOCK;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.register;

public class ChromaticRecepieTypes {

    public static GTRecipeType EMLINE;
    public static GTRecipeType EMLINE_SMDDIODE;
    public static GTRecipeType EMLINE_SMDCAPAICTOR;
    public static GTRecipeType EMLINE_SMDRESSISITOR;
    public static GTRecipeType EMLINE_SMDTRANSISTOR;
    public static GTRecipeType EMLINE_SMDINDUCTOR;



    public static void init() {
        EMLINE = register("electric_assembly_line", MULTIBLOCK)
                .setEUIO(IO.IN)
                .setMaxIOSize(6, 3, 1, 0)
                .setSlotOverlay(false, false, GuiTextures.CIRCUIT_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.ASSEMBLER);
    }




}

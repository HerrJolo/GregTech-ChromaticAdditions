package com.chromatic.chromaticadditions.common.machine;

import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import it.unimi.dsi.fastutil.Pair;

import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.registerSimpleSteamMachines;

public class SteamMixer {

    public static final Pair<MachineDefinition, MachineDefinition> STEAM_MIXER = registerSimpleSteamMachines(
            "mixer", GTRecipeTypes.MIXER_RECIPES);

    public static void init() {}
}

package com.chromatic.chromaticadditions.common.machine;

import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;

public class ChromaticPartAbility extends PartAbility {


    public ChromaticPartAbility(String name) {
        super(name);
    }

    public static final PartAbility SINGLE_DATA = new PartAbility("single_data");
}

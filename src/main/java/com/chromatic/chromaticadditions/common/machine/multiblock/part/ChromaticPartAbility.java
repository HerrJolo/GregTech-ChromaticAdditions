package com.chromatic.chromaticadditions.common.machine.multiblock.part;

import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;

public class ChromaticPartAbility extends PartAbility {

    public ChromaticPartAbility(String name) {
        super(name);
    }

    public static final PartAbility SINGLE_DATA = new PartAbility("single_data");

    public static final PartAbility PRIMITIVE_INPUT_BUS = new PartAbility("single_data");
    public static final PartAbility PRIMITIVE_OUTPUT_BUS = new PartAbility("single_data");
    public static final PartAbility PRIMITIVE_OUTPUT_HATCH = new PartAbility("single_data");
    public static final PartAbility PRIMITIVE_INTPUT_HATCH = new PartAbility("single_data");
}

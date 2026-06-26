package com.chromatic.chromaticadditions.common.item;

import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import org.jetbrains.annotations.NotNull;

public class ChromaticFlags extends MaterialIconSet  {

    public ChromaticFlags(@NotNull String name, @NotNull MaterialIconSet parentIconset) {
        super(name, parentIconset);
    }


    public static final MaterialIconSet HARD = new MaterialIconSet("hard", METALLIC);


}


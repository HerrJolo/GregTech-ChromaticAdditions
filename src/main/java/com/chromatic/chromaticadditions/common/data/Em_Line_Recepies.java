package com.chromatic.chromaticadditions.common.data;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Platinum;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Steel;

public class Em_Line_Recepies {

    public static void init(Consumer<FinishedRecipe> provider) {
        var advancedemline = ChromaticRecepieTypes.ADVANCED_EMLINE;

        advancedemline.recipeBuilder("Smd_Diode_With_Research")
                .inputItems(TagPrefix.wireFine, Platinum, 8)
                .inputItems(TagPrefix.plate, Steel, 6)
                .inputItems(TagPrefix.plate, Steel, 6)
                .inputItems(TagPrefix.plate, Steel, 6)
                .inputItems(TagPrefix.plate, Steel, 6)
                .circuitMeta(2)
                .inputFluids(GTMaterials.AceticAcid.getFluid(1000))
                .outputItems(GTBlocks.CASING_STEEL_SOLID)
                .duration(160)
                .EUt(500)
                .scannerResearch(
                        b -> b
                                .researchStack(GTItems.SMD_DIODE.asStack())
                                .EUt(120)

                )
                .save(provider);
    }
}

package com.chromatic.chromaticadditions.common.data;

import com.gregtechceu.gtceu.api.data.tag.TagUtil;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ChromaticTags {

    public static final TagKey<Item> NETHERMASKS = TagUtil.createItemTag("nether_masks");
    public static final TagKey<Item> ENDMASKS = TagUtil.createItemTag("end_masks");

    public static final TagKey<Item> HEATPROTCETIONSUITE = TagUtil.createItemTag("heat_proteition_suite");
    public static final TagKey<Item> GRAVDISTORTIONSUITE = TagUtil.createItemTag("gravity_distribution_suite");
}

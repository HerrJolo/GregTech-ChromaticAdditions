package com.chromatic.chromaticadditions.common.data.tools;

import com.chromatic.chromaticadditions.ChromaticAdditions;

import com.gregtechceu.gtceu.common.data.GTItems;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ChromaticToolMaterials {

    public static final Tier NANO = TierSortingRegistry.registerTier(
            new ForgeTier(4, 1500, 1f, 0f, 15, BlockTags.NEEDS_DIAMOND_TOOL,
                    () -> Ingredient.of(GTItems.CARBON_FIBER_PLATE.get())),
            ChromaticAdditions.id("tools/nanotools"), List.of(Tiers.NETHERITE), List.of());
}

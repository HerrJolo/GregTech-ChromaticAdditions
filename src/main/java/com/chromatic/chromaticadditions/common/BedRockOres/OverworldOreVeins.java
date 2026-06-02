package com.chromatic.chromaticadditions.common.BedRockOres;

import com.chromatic.chromaticadditions.ChromaticAdditions;
import com.chromatic.chromaticadditions.common.data.ChromaticMaterials;

import com.gregtechceu.gtceu.api.data.worldgen.bedrockore.BedrockOreDefinition;
import com.gregtechceu.gtceu.api.data.worldgen.bedrockore.WeightedMaterial;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Set;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class OverworldOreVeins {

    public static void init() {}

    public static final Set<ResourceKey<Level>> DIM_OVERWORLD = Set.of(Level.OVERWORLD);

    public static final BedrockOreDefinition OVERWORLD_BEDROCK_ORE_VEIN_MAGNETIC_ORE = BedrockOreDefinition
            .builder(ChromaticAdditions.id("magnetic_mineral_deposit"))
            .weight(100)
            .size(3) //
            .yield(5, 10)
            .materials(List.of(
                    new WeightedMaterial(ChromaticMaterials.MAGNETIC_MINERAL_CLUSTER, 5)))
            .dimensions(DIM_OVERWORLD)
            .register();

    public static final BedrockOreDefinition OVERWORLD_BEDROCK_ORE_VEIN_PORUS_ORE = BedrockOreDefinition
            .builder(ChromaticAdditions.id("porus_mineral_deposit"))
            .weight(100)
            .size(3) //
            .yield(5, 10)
            .materials(List.of(
                    new WeightedMaterial(ChromaticMaterials.PORUS_MINERAL_CLUSTER, 5)))
            .dimensions(DIM_OVERWORLD)
            .register();

    public static final BedrockOreDefinition OVERWORLD_BEDROCK_ORE_VEIN_MIXED_ORE = BedrockOreDefinition
            .builder(ChromaticAdditions.id("mixed_mineral_deposit"))
            .weight(100)
            .size(3) //
            .yield(5, 10)
            .materials(List.of(
                    new WeightedMaterial(ChromaticMaterials.MIXED_MINERAL_CLUSTER, 5)))
            .dimensions(DIM_OVERWORLD)
            .register();

    public static final BedrockOreDefinition OVERWORLD_BEDROCK_ORE_VEIN_CRYSTALIZED_ORE = BedrockOreDefinition
            .builder(ChromaticAdditions.id("crystalized_mineral_deposit"))
            .weight(100)
            .size(3) //
            .yield(5, 10)
            .materials(List.of(
                    new WeightedMaterial(ChromaticMaterials.CRYSTALIZED_MINERAL_CLUSTER, 5)))
            .dimensions(DIM_OVERWORLD)
            .register();

    public static final BedrockOreDefinition OVERWORLD_BEDROCK_ORE_VEIN_RARE_ORE = BedrockOreDefinition
            .builder(ChromaticAdditions.id("rare_mineral_deposit"))
            .weight(100)
            .size(3) //
            .yield(5, 10)
            .materials(List.of(
                    new WeightedMaterial(ChromaticMaterials.RARE_MINERAL_CLUSTER, 5)))
            .dimensions(DIM_OVERWORLD)
            .register();
}

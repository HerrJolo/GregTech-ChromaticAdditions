package com.chromatic.chromaticadditions.common.data;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import earth.terrarium.adastra.common.registry.ModItems;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;

public class ChromaticMaterials {

    public static Material MAGNETIC_MINERAL_CLUSTER;
    public static Material PORUS_MINERAL_CLUSTER;
    public static Material MIXED_MINERAL_CLUSTER;
    public static Material CRYSTALIZED_MINERAL_CLUSTER;
    public static Material RARE_MINERAL_CLUSTER;
    public static Material PRECIOUS_METALS;
    public static Material DESH;
    public static Material DRILLING_STEEL;
    public static Material RIVERMUD;
    public static Material OVERWORLD_ORE_SLURRY;
    public static Material COKE_OVEN_DUST;
    public static Material CRUDE_LUBRICANT;
    public static Material GOOD_LUBRICANT;
    public static Material PERFECTED_LUBRICANT;
    public static Material INSECTECIDE;

    public static void init() {
        MAGNETIC_MINERAL_CLUSTER = new Material.Builder(GTCEu.id("magnetic_mineral_cluster"))
                .ore()
                .flags(DISABLE_MATERIAL_RECIPES, NO_ORE_PROCESSING_TAB)
                .color(0xC43333).secondaryColor(0x3D3434)
                .buildAndRegister();

        PORUS_MINERAL_CLUSTER = new Material.Builder(GTCEu.id("porus_mineral_cluster"))
                .ore()
                .flags(DISABLE_MATERIAL_RECIPES, NO_ORE_PROCESSING_TAB)
                .color(0xE3FF00).secondaryColor(0x1F991C)
                .buildAndRegister();

        MIXED_MINERAL_CLUSTER = new Material.Builder(GTCEu.id("mixed_mineral_cluster"))
                .ore()
                .flags(DISABLE_MATERIAL_RECIPES, NO_ORE_PROCESSING_TAB)
                .color(0xE3FF00).secondaryColor(0xC253AD)
                .buildAndRegister();

        CRYSTALIZED_MINERAL_CLUSTER = new Material.Builder(GTCEu.id("crystalized_mineral_cluster"))
                .ore()
                .flags(DISABLE_MATERIAL_RECIPES, NO_ORE_PROCESSING_TAB)
                .color(0x178278).secondaryColor(0xFFFFFF)
                .buildAndRegister();

        RARE_MINERAL_CLUSTER = new Material.Builder(GTCEu.id("rare_mineral_cluster"))
                .ore()
                .flags(DISABLE_MATERIAL_RECIPES, NO_ORE_PROCESSING_TAB)
                .color(0xD4AF37).secondaryColor(0xC0C0C0)
                .buildAndRegister();

        PRECIOUS_METALS = new Material.Builder(GTCEu.id("precious_metals"))
                .ore()
                .flags(DISABLE_MATERIAL_RECIPES, NO_ORE_PROCESSING_TAB)
                .color(0x7A826F).secondaryColor(0xA17445)
                .buildAndRegister();

        DESH = new Material.Builder(GTCEu.id("desh"))
                .ore()
                .ingot()
                .addOreByproducts(GTMaterials.Aluminium, GTMaterials.Bauxite, GTMaterials.Gallium)
                .washedIn(GTMaterials.SodiumPersulfate)
                .flags(GENERATE_ROD, GENERATE_FRAME, GENERATE_PLATE)
                .blast(b -> b.temp(1700, BlastProperty.GasTier.MID)
                        .blastStats(VA[HV], 600)
                        .vacuumStats(VA[HV]))
                .color(0xd38b4c)
                .buildAndRegister();

        DRILLING_STEEL = new Material.Builder(GTCEu.id("drilling_steel"))
                .ingot()
                .dust()
                .flags(EXCLUDE_BLOCK_CRAFTING_RECIPES, GENERATE_PLATE, GENERATE_FRAME, GENERATE_ROD)
                .iconSet(MaterialIconSet.SHINY)
                .blast(b -> b.temp(1500, BlastProperty.GasTier.LOW)
                        .blastStats(VA[HV], 600)
                        .vacuumStats(VA[HV], 600))
                .color(0xD6C3C3)
                .buildAndRegister();

        RIVERMUD = new Material.Builder(GTCEu.id("river_mud"))
                .fluid()
                .color(0xA87D7D)
                .buildAndRegister();

        GTMaterials.Iron.addFlags(GENERATE_FRAME);

        ingot.setIgnored(DESH, ModItems.DESH_INGOT);
        block.setIgnored(DESH, ModItems.DESH_BLOCK);
        plate.setIgnored(DESH, ModItems.DESH_PLATE);
        nugget.setIgnored(DESH, ModItems.DESH_NUGGET);

        OVERWORLD_ORE_SLURRY = new Material.Builder(GTCEu.id("overworld_ore_slurry"))
                .fluid()
                .color(0x666666)
                .buildAndRegister();

        COKE_OVEN_DUST = new Material.Builder(GTCEu.id("coke_oven_brick_dust"))
                .dust()
                .color(0xc1bd91)
                .buildAndRegister();

        CRUDE_LUBRICANT = new Material.Builder(GTCEu.id("crude_lubricant"))
                .fluid()
                .color(0xC3C789)
                .buildAndRegister();

        GOOD_LUBRICANT = new Material.Builder(GTCEu.id("good_lubricant"))
                .fluid()
                .color(0xF3FF78)
                .buildAndRegister();

        PERFECTED_LUBRICANT = new Material.Builder(GTCEu.id("perfected_lubricant"))
                .fluid()
                .color(0xF8FFD9)
                .buildAndRegister();

        INSECTECIDE = new Material.Builder(GTCEu.id("insecticide"))
                .fluid()
                .color(0x5C3D9C)
                .buildAndRegister();
    }
}

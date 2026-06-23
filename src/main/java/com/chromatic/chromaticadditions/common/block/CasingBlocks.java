package com.chromatic.chromaticadditions.common.block;

import com.chromatic.chromaticadditions.ChromaticAdditions;

import com.gregtechceu.gtceu.data.recipe.CustomTags;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiFunction;
import org.jetbrains.annotations.NotNull;

import static com.chromatic.chromaticadditions.ChromaticAdditions.HERRJOLO_REGISTRATE;

public class CasingBlocks {

    public static void init() {}

    private static @NotNull BlockEntry<Block> registerSimpleBlock(String name, String id, String texture,
                                                                  NonNullBiFunction<Block, Item.Properties, ? extends BlockItem> func) {
        return HERRJOLO_REGISTRATE
                .block(id, Block::new)
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .tag(CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH)
                .properties(p -> p.isValidSpawn((state, level, pos, ent) -> false)
                        .strength(5.0f, 6.0f)
                        .requiresCorrectToolForDrops())
                .blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry(),
                        prov.models().cubeAll(ctx.getName(), ChromaticAdditions.id("block/" + texture))))
                .lang(name)
                .item(func)
                .build()
                .register();
    }

    public static BlockEntry<Block> LIQUID_WORKING_CASING = registerSimpleBlock(
            "Liquid Working Casing", "liquid_working_casing",
            "liquid_working_casing", BlockItem::new);

    public static BlockEntry<Block> EM_CASING = registerSimpleBlock(
            "Electronic Shielding Casing", "em_casing",
            "emcassing", BlockItem::new);

    public static BlockEntry<Block> DRILLING_CASING = registerSimpleBlock(
            "Drilling Pipe Casing", "drilling_casing",
            "drilling_casing", BlockItem::new);

    public static BlockEntry<Block> HERMETIC_CASING = registerSimpleBlock(
            "Hermetic Casing", "hermetic_casing",
            "hermeticcasing", BlockItem::new);
}

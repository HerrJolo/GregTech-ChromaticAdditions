package com.chromatic.chromaticadditions.common.block;

import com.chromatic.chromaticadditions.ChromaticAdditions;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiFunction;
import org.jetbrains.annotations.NotNull;

import static com.chromatic.chromaticadditions.ChromaticAdditions.HERRJOLO_REGISTRATE;

public class DepositBlocks {

    public static void init() {}

    private static @NotNull BlockEntry<Block> registerSimpleBlock(String name, String id, String texture,
                                                                  NonNullBiFunction<Block, Item.Properties, ? extends BlockItem> func) {
        return HERRJOLO_REGISTRATE
                .block(id, Block::new)
                .initialProperties(() -> Blocks.IRON_ORE)
                .tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .properties(p -> p.isValidSpawn((state, level, pos, ent) -> false)
                        .strength(3.0f, 5.0f)
                        .requiresCorrectToolForDrops())
                .blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry(),
                        prov.models().cubeAll(ctx.getName(), ChromaticAdditions.id("block/" + texture))))
                .lang(name)
                .item(func)
                .build()
                .register();
    }

    public static BlockEntry<Block> COAL_DEPOSIT = registerSimpleBlock(
            "Coal Deposit", "coal_deposit",
            "coal_deposit", BlockItem::new);

    public static BlockEntry<Block> IRON_DEPOSIT = registerSimpleBlock(
            "Iron Deposit", "iron_deposit",
            "iron_deposit", BlockItem::new);

    public static BlockEntry<Block> COPPER_DEPOSIT = registerSimpleBlock(
            "Copper Deposit", "copper_deposit",
            "copper_deposit", BlockItem::new);

    public static BlockEntry<Block> CASSITERITE_DEPOSIT = registerSimpleBlock(
            "Cassiterite Deposit", "cassiterite_deposit",
            "cassiterite_deposit", BlockItem::new);
}

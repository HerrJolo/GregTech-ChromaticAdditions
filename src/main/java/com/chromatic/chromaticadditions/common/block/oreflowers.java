package com.chromatic.chromaticadditions.common.block;

import com.chromatic.chromaticadditions.ChromaticAdditions;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiFunction;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import org.jetbrains.annotations.NotNull;

import static com.chromatic.chromaticadditions.ChromaticAdditions.HERRJOLO_REGISTRATE;

public class oreflowers {


    private static @NotNull BlockEntry<Block> registerFlowerBlock(String name, String id, String texture,
                                                                  NonNullBiFunction<Block, Item.Properties, ? extends BlockItem> func) {
        return HERRJOLO_REGISTRATE
                .block(id, p -> new FlowerBlock(() -> MobEffects.WITHER, 5, p))
                .initialProperties(() -> Blocks.CRIMSON_FUNGUS)
                .addLayer(() -> RenderType::cutout)
                .properties(p -> p.isValidSpawn((state, level, pos, ent) -> false)
                        .strength(5.0f, 6.0f))
                .blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry(),
                        prov.models().cross(ctx.getName(), ChromaticAdditions.id("block/" + texture))))
                .lang(name)
                .item(func)
                .build()
                .register();
    }

    public static BlockEntry<Block> NETHER_SHROOM = registerFlowerBlock(
            "Nether Shroom", "nether_shroom",
            "nether_shroom", BlockItem::new);
}

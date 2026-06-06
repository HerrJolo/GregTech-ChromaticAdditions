package com.chromatic.chromaticadditions.common.data.tools;

import com.gregtechceu.gtceu.api.item.tool.GTToolType;
import com.gregtechceu.gtceu.api.item.tool.IGTToolDefinition;
import com.gregtechceu.gtceu.api.sound.SoundEntry;
import com.gregtechceu.gtceu.common.data.item.GTToolActions;
import com.gregtechceu.gtceu.common.item.tool.behavior.TorchPlaceBehavior;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ToolAction;

import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Set;

public class ChromaticMultiTool extends GTToolType {

    public ChromaticMultiTool(String name, String idFormat, char symbol, Set<GTToolType> toolClasses,
                              ToolConstructor constructor, IGTToolDefinition toolDefinition,
                              List<TagKey<Item>> itemTags, List<TagKey<Item>> matchTags,
                              List<TagKey<Item>> craftingTags, List<TagKey<Block>> harvestTags,
                              Set<ToolAction> defaultAbilities, Set<String> toolClassNames,
                              ResourceLocation modelLocation, @Nullable SoundEntry soundEntry,
                              boolean playSoundOnBlockDestroy, int electricTier, long materialAmount) {
        super(name, idFormat, symbol, toolClasses, constructor, toolDefinition, itemTags, matchTags, craftingTags,
                harvestTags, defaultAbilities, toolClassNames, modelLocation, soundEntry, playSoundOnBlockDestroy,
                electricTier, materialAmount);
    }

    public static final GTToolType MULTITOOL = GTToolType.builder("multitool")
            .toolTag(ItemTags.PICKAXES, ItemTags.SHOVELS, ItemTags.AXES)
            .harvestTag(BlockTags.MINEABLE_WITH_AXE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.MINEABLE_WITH_SHOVEL)
            .toolStats(b -> b.blockBreaking().attackDamage(1.5f).attackSpeed(-3.0f)
                    .behaviors(TorchPlaceBehavior.INSTANCE))
            .toolClassNames("multitool")
            .defaultActions(GTToolActions.DEFAULT_DRILL_ACTIONS)
            .build();
}

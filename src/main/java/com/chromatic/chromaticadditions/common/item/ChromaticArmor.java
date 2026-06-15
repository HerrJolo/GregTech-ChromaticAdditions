package com.chromatic.chromaticadditions.common.item;

import com.chromatic.chromaticadditions.common.data.ChromaticTags;
import com.chromatic.chromaticadditions.common.data.armor.ChromaticArmorMaterials;
import com.chromatic.chromaticadditions.common.data.armor.NanoBootsLogicSuite;

import com.gregtechceu.gtceu.api.item.armor.ArmorComponentItem;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.gregtechceu.gtceu.data.recipe.CustomTags;

import net.minecraft.world.item.*;
import net.minecraftforge.common.Tags;

import com.tterrag.registrate.util.entry.ItemEntry;

import static com.chromatic.chromaticadditions.ChromaticAdditions.HERRJOLO_REGISTRATE;

public class ChromaticArmor {

    public static ItemEntry<ArmorComponentItem> NANO_TRAVELER_BOOTS = HERRJOLO_REGISTRATE
            .item("nano_tarveler_boots",
                    (p) -> new ArmorComponentItem(ChromaticArmorMaterials.NANOBOOTS, ArmorItem.Type.BOOTS, p)
                            .setArmorLogic(new NanoBootsLogicSuite(ArmorItem.Type.BOOTS,
                                    32,
                                    6_400_000L * (long) Math.max(1,
                                            Math.pow(4, ConfigHolder.INSTANCE.tools.voltageTierNanoSuit - 3)),
                                    ConfigHolder.INSTANCE.tools.voltageTierNanoSuit)))
            .properties(Item.Properties::fireResistant)
            .lang("NanoMuscle™ Traveler Boots")
            .properties(p -> p.rarity(Rarity.EPIC))
            .tag(Tags.Items.ARMORS_BOOTS)
            .tag(CustomTags.STEP_BOOTS)
            .register();

    public static ItemEntry<ArmorComponentItem> NANO_GAS_MASK = HERRJOLO_REGISTRATE
            .item("nano_gas_mask",
                    (p) -> new ArmorComponentItem(ChromaticArmorMaterials.NANOBOOTS, ArmorItem.Type.HELMET, p)
                            .setArmorLogic(new NanoBootsLogicSuite(ArmorItem.Type.HELMET,
                                    32,
                                    6_400_000L * (long) Math.max(1,
                                            Math.pow(4, ConfigHolder.INSTANCE.tools.voltageTierNanoSuit - 3)),
                                    ConfigHolder.INSTANCE.tools.voltageTierNanoSuit)))
            .properties(Item.Properties::fireResistant)
            .lang("NanoMuscle™ Gas Mask")
            .properties(p -> p.rarity(Rarity.EPIC))
            .tag(Tags.Items.ARMORS_HELMETS, ChromaticTags.NETHERMASKS, ChromaticTags.ENDMASKS)
            .register();

    public static ItemEntry<ArmorItem> ADVANCED_GAS_MASK = HERRJOLO_REGISTRATE
            .item("advanced_gas_mask",
                    (p) -> new ArmorItem(ChromaticArmorMaterials.ADVANCEDGAS, ArmorItem.Type.HELMET, p))
            .properties(p -> p.rarity(Rarity.RARE))
            .lang("Advanced Gas Mask")
            .tag(Tags.Items.ARMORS_HELMETS, ChromaticTags.NETHERMASKS)
            .register();

    public static ItemEntry<ArmorItem> PRIMITIVE_GAS_MASK = HERRJOLO_REGISTRATE
            .item("primitive_gas_mask", (p) -> new ArmorItem(ChromaticArmorMaterials.IRONGAS, ArmorItem.Type.HELMET, p))
            .properties(p -> p.rarity(Rarity.UNCOMMON))
            .lang("Primitive Gas Mask")
            .tag(Tags.Items.ARMORS_HELMETS, ChromaticTags.NETHERMASKS)
            .register();

    public static void init() {}
}

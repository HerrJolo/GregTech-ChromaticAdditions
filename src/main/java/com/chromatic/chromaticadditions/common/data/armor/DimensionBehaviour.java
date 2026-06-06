package com.chromatic.chromaticadditions.common.data.armor;

import com.chromatic.chromaticadditions.common.item.ChromaticArmor;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import lombok.extern.slf4j.Slf4j;

import java.awt.*;

@Slf4j
public class DimensionBehaviour {

    // private static final Map<Dimension, TagKey<Item>> gasMaskTagsByDimesion = new Object2ObjectOpenHashMap<>();
    // private static final Map<Dimension, Consumer<event.player>> effectsByDimesion = new Object2ObjectOpenHashMap<>();

    @SubscribeEvent
    public static void playerTickEvent(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            return;
        }
        if (event.player.level().isClientSide) {
            return;
        }

        Player p = event.player;
        ItemStack helmet = p.getItemBySlot(EquipmentSlot.HEAD);

        boolean hasNanoGasMask = helmet.is(ChromaticArmor.NANO_GAS_MASK.get());

        boolean hasAdvancedGasMask = helmet.is(ChromaticArmor.ADVANCED_GAS_MASK.get());

        boolean hasIronGasMask = helmet.is(ChromaticArmor.PRIMITIVE_GAS_MASK.get());

        boolean hasNetherCondition = hasNanoGasMask || hasAdvancedGasMask || hasIronGasMask;

        if (p.level().dimension().equals(Level.OVERWORLD)) {
            return;
        }

        if (p.level().dimension().equals(Level.NETHER) && !hasNetherCondition) {
            p.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 4));
            p.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 5));
        }

        if (p.level().dimension().equals(Level.END) && !hasNanoGasMask) {
            p.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 4));
            p.addEffect(new MobEffectInstance(MobEffects.HUNGER, 100, 4));
            p.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 5));
            p.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 100, 5));

        }
    };
}

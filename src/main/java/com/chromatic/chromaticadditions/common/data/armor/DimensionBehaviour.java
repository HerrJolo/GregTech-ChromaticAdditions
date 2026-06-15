package com.chromatic.chromaticadditions.common.data.armor;

import com.chromatic.chromaticadditions.common.data.ChromaticTags;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;
import top.theillusivec4.curios.api.type.inventory.ICurioStacksHandler;

import java.awt.*;
import java.util.*;

@Slf4j
public class DimensionBehaviour {

    // private static final Map<Dimension, TagKey<Item>> gasMaskTagsByDimesion = new Object2ObjectOpenHashMap<>();
    // private static final Map<Dimension, Consumer<event.player>> effectsByDimesion = new Object2ObjectOpenHashMap<>();
    private static ArrayList<ItemStack> BodyContendCurio = new ArrayList<ItemStack>();

    @SubscribeEvent
    @NotNull
    public static void playerTickEvent(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            return;
        }
        if (event.player.level().isClientSide) {
            return;
        }
        Player p = event.player;

        CuriosApi.getCuriosInventory(p).ifPresent(CuriosInventory -> {

            ICuriosItemHandler curiosInventory = CuriosApi.getCuriosInventory(event.player).resolve().get();

            ICurioStacksHandler bodyHandler = curiosInventory.getCurios().get("body");

            if (bodyHandler != null) {
                ItemStack body = bodyHandler.getStacks().getStackInSlot(0);
                BodyContendCurio.add(0, body);
            }
        });

        ItemStack helmet = p.getItemBySlot(EquipmentSlot.HEAD);

        boolean hasEndAcces = helmet.is(ChromaticTags.ENDMASKS);

        boolean hasNetherAcces = (helmet.is(ChromaticTags.NETHERMASKS) &&
                BodyContendCurio.get(0).is(ChromaticTags.HEATPROTCETIONSUITE));

        if (p.level().dimension().equals(Level.OVERWORLD)) {
            return;
        }

        if (p.level().dimension().equals(Level.NETHER) && !hasNetherAcces) {
            p.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 4));
            p.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 5));
        }

        if (p.level().dimension().equals(Level.END) && !hasEndAcces) {
            p.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 4));
            p.addEffect(new MobEffectInstance(MobEffects.HUNGER, 100, 4));
            p.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 5));
            p.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 100, 5));

        }
    };
}

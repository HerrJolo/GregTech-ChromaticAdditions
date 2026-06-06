package com.chromatic.chromaticadditions.common.data.armor;

import com.gregtechceu.gtceu.api.item.armor.IArmorLogic;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EaryGasMasks implements IArmorLogic {

    @Override
    public ArmorItem.Type getArmorType() {
        return null;
    }

    @Override
    public int getArmorDisplay(Player player, @NotNull ItemStack itemStack, EquipmentSlot equipmentSlot) {
        return 0;
    }

    @Override
    public boolean isPPE() {
        return true;
    }

    @Override
    public @Nullable ResourceLocation getArmorTexture(ItemStack itemStack, Entity entity, EquipmentSlot equipmentSlot,
                                                      String s) {
        return null;
    }
}

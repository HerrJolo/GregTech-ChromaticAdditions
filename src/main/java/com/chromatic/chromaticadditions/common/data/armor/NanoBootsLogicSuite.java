package com.chromatic.chromaticadditions.common.data.armor;

import com.gregtechceu.gtceu.api.capability.GTCapabilityHelper;
import com.gregtechceu.gtceu.api.capability.IElectricItem;
import com.gregtechceu.gtceu.api.item.armor.ArmorLogicSuite;
import com.gregtechceu.gtceu.api.item.armor.ArmorUtils;
import com.gregtechceu.gtceu.common.item.armor.IStepAssist;
import com.gregtechceu.gtceu.utils.input.SyncedKeyMappings;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class NanoBootsLogicSuite extends ArmorLogicSuite implements IStepAssist {

    private static final byte RUNNING_TIMER = 5; // .5 seconds
    private static final byte JUMPING_TIMER = 5; // .5 seconds
    private static final double LEGGING_ACCEL = 0.045D;

    @OnlyIn(Dist.CLIENT)
    protected ArmorUtils.ModularHUD HUD;

    public NanoBootsLogicSuite(ArmorItem.Type slot, int energyPerUse, long capacity, int tier) {
        super(energyPerUse, capacity, tier, slot);
    }

    @Override
    public void onArmorTick(Level world, Player player, ItemStack itemStack) {
        IElectricItem item = GTCapabilityHelper.getElectricItem(itemStack);
        if (item == null)
            return;

        CompoundTag data = itemStack.getOrCreateTag();
        byte toggleTimer = data.contains("toggleTimer") ? data.getByte("toggleTimer") : 0;
        int nightVisionTimer = data.contains("nightVisionTimer") ? data.getInt("nightVisionTimer") :
                ArmorUtils.NIGHTVISION_DURATION;
        byte runningTimer = data.contains("runningTimer") ? data.getByte("runningTimer") : RUNNING_TIMER;
        byte toggleBootsTimer = data.contains("toggleBootsTimer") ? data.getByte("toggleBootsTimer") : JUMPING_TIMER;

        boolean ret = false;
        if (type == ArmorItem.Type.HELMET) {

            boolean nightVision = data.contains("nightVision") && data.getBoolean("nightVision");
            if (toggleTimer == 0 && SyncedKeyMappings.ARMOR_MODE_SWITCH.isKeyDown(player)) {
                nightVision = !nightVision;
                toggleTimer = 5;
                if (item.getCharge() < ArmorUtils.MIN_NIGHTVISION_CHARGE) {
                    nightVision = false;
                    player.displayClientMessage(Component.translatable("metaarmor.qts.nightvision.error"), true);
                } else {
                    player.displayClientMessage(Component
                            .translatable("metaarmor.qts.nightvision." + (nightVision ? "enabled" : "disabled")), true);
                }
            }

            if (nightVision) {
                player.removeEffect(MobEffects.BLINDNESS);
                if (nightVisionTimer <= ArmorUtils.NIGHT_VISION_RESET) {
                    nightVisionTimer = ArmorUtils.NIGHTVISION_DURATION;
                    player.addEffect(
                            new MobEffectInstance(MobEffects.NIGHT_VISION, ArmorUtils.NIGHTVISION_DURATION, 0, true,
                                    false));
                    item.discharge((4), this.tier, true, false, false);
                }
            } else {
                player.removeEffect(MobEffects.NIGHT_VISION);
            }
            data.putBoolean("nightVision", nightVision);

            if (nightVisionTimer > 0) nightVisionTimer--;
            if (toggleTimer > 0) toggleTimer--;

            data.putInt("nightVisionTimer", nightVisionTimer);
            data.putByte("toggleTimer", toggleTimer);

        } else if (type == ArmorItem.Type.BOOTS) {

            boolean canUseEnergy = item.canUse(energyPerUse / 32);

            boolean sprinting = SyncedKeyMappings.VANILLA_FORWARD.isKeyDown(player) && player.isSprinting();

            boolean walking = SyncedKeyMappings.VANILLA_FORWARD.isKeyDown(player);

            boolean jumping = SyncedKeyMappings.VANILLA_JUMP.isKeyDown(player);

            boolean sneaking = SyncedKeyMappings.VANILLA_SNEAK.isKeyDown(player);

            /*
             * if (canUseEnergy && sprinting) {
             * if (runningTimer == 0) {
             * runningTimer = RUNNING_TIMER;
             * item.discharge(energyPerUse / 32, item.getTier(), true, false, false);
             * }
             * }
             * if (canUseEnergy && (player.onGround() || player.isInWater()) && sprinting) {
             * float speed = 0.25F;
             * if (player.isInWater()) {
             * speed = 0.1F;
             * if (jumping) {
             * player.push(0.0, 0.1, 0.0);
             * player.hurtMarked = true;
             * }
             * }
             * player.moveRelative(speed, new Vec3(0, 0, 0.8));
             * }
             *
             * /*
             * * if (canUseEnergy && (player.onGround() || player.isInWater()) && walking) {
             * * float speed = 0.25F;
             * * if (player.isInWater()) {
             * * speed = 0.1F;
             * * if (jumping) {
             * * player.push(0.0, 0.1, 0.0);
             * * player.hurtMarked = true;
             * * }
             * * }
             * * player.moveRelative(speed, new Vec3(0, 0, 0.8));
             * * }
             */
            /*
             * else if (canUseEnergy && player.isInWater() && (sneaking || jumping)) {
             * if (sneaking)
             * player.push(0.0, -LEGGING_ACCEL, 0.0);
             * if (jumping)
             * player.push(0.0, LEGGING_ACCEL, 0.0);
             * }
             *
             * if (runningTimer > 0) runningTimer--;
             * data.putByte("runningTimer", runningTimer);
             */
            boolean stepAssist = data.contains("stepAssist") && data.getBoolean("stepAssist");
            if (toggleBootsTimer == 0 && SyncedKeyMappings.STEP_ASSIST_ENABLE.isKeyDown(player)) {
                stepAssist = !stepAssist;
                toggleBootsTimer = 5;
                if (world.isClientSide()) player.displayClientMessage(Component
                        .translatable("metaarmor.qts.step_assist." + (stepAssist ? "enabled" : "disabled")), true);
                data.putBoolean("stepAssist", stepAssist);
            }

            if (toggleBootsTimer > 0) toggleBootsTimer--;
            data.putInt("toggleBootsTimer", toggleBootsTimer);
        }

        if (ret) {
            player.inventoryMenu.sendAllDataToRemote();
        }
    }

    @Override
    public int damageArmor(LivingEntity entity, ItemStack itemStack, DamageSource source, int damage,
                           EquipmentSlot equipmentSlot) {
        IElectricItem item = GTCapabilityHelper.getElectricItem(itemStack);
        if (item != null) {
            item.discharge(energyPerUse / 100L * damage, item.getTier(), true, false, false);
        }
        return super.damageArmor(entity, itemStack, source, damage, equipmentSlot);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void drawHUD(ItemStack item, GuiGraphics guiGraphics) {
        addCapacityHUD(item, this.HUD);
        this.HUD.draw(guiGraphics);
        this.HUD.reset();
    }

    @Override
    public void addInfo(ItemStack itemStack, List<Component> lines) {
        super.addInfo(itemStack, lines);
        if (type == ArmorItem.Type.HELMET) {
            CompoundTag nbtData = itemStack.getOrCreateTag();
            boolean nv = nbtData.getBoolean("nightVision");
            if (nv) {
                lines.add(Component.translatable("metaarmor.message.nightvision.enabled"));
            } else {
                lines.add(Component.translatable("metaarmor.message.nightvision.disabled"));
            }
        } else if (type == ArmorItem.Type.BOOTS) {
            lines.add(Component.literal("Increases Movement Speed"));
            CompoundTag nbtData = itemStack.getOrCreateTag();
            if (nbtData.getBoolean("stepAssist"))
                lines.add(Component.translatable("metaarmor.message.step_assist.enabled"));
            else lines.add(Component.translatable("metaarmor.message.step_assist.disabled"));
            lines.add(Component.translatable("metaarmor.tooltip.falldamage"));
            lines.add(Component.literal("Increases Jump Height"));
        }
    }

    @Override
    public boolean isPPE() {
        return true;
    }
}

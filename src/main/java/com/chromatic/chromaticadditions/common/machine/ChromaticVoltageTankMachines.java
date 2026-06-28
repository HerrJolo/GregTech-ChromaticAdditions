package com.chromatic.chromaticadditions.common.machine;

import com.chromatic.chromaticadditions.ChromaticAdditions;

import com.gregtechceu.gtceu.api.block.MetaMachineBlock;
import com.gregtechceu.gtceu.api.blockentity.MetaMachineBlockEntity;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.FluidPipeProperties;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.item.DrumMachineItem;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.utils.FormattingUtil;

import net.minecraft.network.chat.Component;
import net.minecraftforge.fluids.FluidType;

import static com.chromatic.chromaticadditions.ChromaticAdditions.HERRJOLO_REGISTRATE;
import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.*;

public class ChromaticVoltageTankMachines {

    public static void init() {}

    public static MachineDefinition registerChromaticDrum(Material material, int capacity, String lang) {
        return registerDrum(HERRJOLO_REGISTRATE, material, capacity, lang);
    }

    public static MachineDefinition registerChromaticDrum(GTRegistrate registrate, Material material, int capacity,
                                                          String lang) {
        boolean wooden = material.hasProperty(PropertyKey.WOOD);
        var definition = registrate
                .machine(material.getName() + "_reinforced_drum", MachineDefinition::new,
                        holder -> new ChromaticTanks(holder, material, capacity), MetaMachineBlock::new,
                        (holder, prop) -> DrumMachineItem.create(holder, prop, material),
                        MetaMachineBlockEntity::new)
                .langValue(lang)
                .rotationState(RotationState.NONE)
                .simpleModel(ChromaticAdditions.id("block/machine/template/drum/metal_drum"))
                .tooltipBuilder((stack, list) -> {
                    TANK_TOOLTIPS.accept(stack, list);
                    if (material.hasProperty(PropertyKey.FLUID_PIPE)) {
                        FluidPipeProperties pipeprops = material.getProperty(PropertyKey.FLUID_PIPE);
                        pipeprops.appendTooltips(list, false, true);
                    }
                })
                .tooltips(Component.translatable("gtceu.machine.quantum_tank.tooltip"),
                        Component.translatable("gtceu.universal.tooltip.fluid_storage_capacity",
                                FormattingUtil.formatNumbers(capacity)))
                .paintingColor(wooden ? 0xFFFFFF : material.getMaterialRGB())
                .itemColor((s, i) -> wooden ? 0xFFFFFF : material.getMaterialRGB())
                .register();
        DRUM_CAPACITY.put(definition, capacity);
        return definition;
    }

    public static MachineDefinition ALUMINIUM_DRUM = registerChromaticDrum(HERRJOLO_REGISTRATE, GTMaterials.Aluminium,
            (512 * FluidType.BUCKET_VOLUME), "Reinforced Aluminium Drum");
    public static MachineDefinition STEEL_DRUM = registerChromaticDrum(HERRJOLO_REGISTRATE, GTMaterials.Steel,
            (256 * FluidType.BUCKET_VOLUME), "Reinforced Steel Drum");
    public static MachineDefinition BRONZE_DRUM = registerChromaticDrum(HERRJOLO_REGISTRATE, GTMaterials.Bronze,
            (128 * FluidType.BUCKET_VOLUME), "Reinforced Bronze Drum");
    public static MachineDefinition GOLD_DRUM = registerChromaticDrum(HERRJOLO_REGISTRATE, GTMaterials.Gold,
            (128 * FluidType.BUCKET_VOLUME), "Reinforced Gold Drum");
}

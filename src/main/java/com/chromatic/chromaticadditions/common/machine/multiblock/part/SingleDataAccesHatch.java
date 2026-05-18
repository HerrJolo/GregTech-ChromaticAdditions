package com.chromatic.chromaticadditions.common.machine.multiblock.part;

import com.gregtechceu.gtceu.api.GTValues;


import com.gregtechceu.gtceu.api.capability.IDataAccessHatch;
import com.gregtechceu.gtceu.api.capability.IMonitorComponent;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.feature.IDataInfoProvider;
import com.gregtechceu.gtceu.common.machine.multiblock.part.DataAccessHatchMachine;


public class SingleDataAccesHatch extends DataAccessHatchMachine{

    public SingleDataAccesHatch(IMachineBlockEntity holder, int tier, boolean isCreative) {
        super(holder, tier, isCreative);
    }

    @Override
    public int getInventorySize() {
        return switch (getTier()) {
            case GTValues.LuV -> 16;
            case GTValues.EV -> 9;
            case GTValues.HV -> 4;
            case GTValues.MV ->1;
            default -> 0;
    };




}










}

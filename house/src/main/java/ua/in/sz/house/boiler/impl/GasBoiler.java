package ua.in.sz.house.boiler.impl;

import lombok.AllArgsConstructor;
import ua.in.sz.house.boiler.Boiler;
import ua.in.sz.house.boiler.Resource;
import ua.in.sz.house.house.House;

import static ua.in.sz.house.Main.TARGET_TEMPERATURE;

@AllArgsConstructor
public class GasBoiler extends Boiler {

    private static final double heatCapacity = 9_300;

    private static final double climateRatio = 1.3;

    @Override
    public Resource resourceQuantity(House house, double tIn, double tOut) {
        double boilerPowerPerHour = house.getHeatLoss(TARGET_TEMPERATURE, tOut) * climateRatio;
        return Resource.Gas.of(boilerPowerPerHour / heatCapacity);
    }
}

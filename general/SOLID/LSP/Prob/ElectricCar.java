package com.SOLID.LSP.Prob;

public class ElectricCar implements Car{
    private int kilometersCovered = 0;//Pick the value from sensor
    @Override
    public float fetchMileage() {
        return 380 - kilometersCovered;
    }

    @Override
    public int fuelTankCapacity() {
        throw new UnsupportedOperationException();
    }
    @Override
    public float fetchCo2Emission() {
//My car is a green car. So wont pollute. So am returning 0
        return 0;
    }
    @Override
    public void start() {
//Electric car starts
    }
    @Override
    public void honk() {
//Electric car honks
    }
}
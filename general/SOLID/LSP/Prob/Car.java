package com.SOLID.LSP.Prob;

public interface Car {
    public float fetchMileage();//no. of kms per litre of fuel
    public int fuelTankCapacity();// in litres
    public float fetchCo2Emission();//grams of CO2 per km run of the car
    public void start();
    public void honk();
}
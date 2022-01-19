package com.SOLID.ISP.Sol;

import com.SOLID.LSP.Sol.Car;
import com.SOLID.LSP.Sol.Engine;

public abstract class FossilFuelCar implements Car {
    private Engine engine;
    private FuelTank fuelTank;
    public FossilFuelCar(Engine engine, FuelTank fuelTank) {
        this.engine = engine;
        this.fuelTank = fuelTank;
    }
    public abstract float fetchMileage() ;
    public abstract int fuelTankCapacity() ;
}
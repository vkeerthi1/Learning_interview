package com.SOLID.LSP.Sol;

public abstract class FossilFuelCar implements Car{
    private Engine engine;
    public FossilFuelCar(Engine engine) {
        this.engine = engine;
    }
    public abstract float fetchMileage() ;
    public abstract int fuelTankCapacity() ;
}

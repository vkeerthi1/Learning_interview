package com.SOLID.LSP.Prob;

public class PetrolCar implements Car {
    @Override
    public float fetchMileage() {
//value calculated based on logic
        return 25;
    }

    @Override
    public int fuelTankCapacity() {
//value calculated based on car
        return 30;
    }

    @Override
    public float fetchCo2Emission() {
//value calculated based on engine
        return 0.5f;
    }

    @Override
    public void start() {
    }

    @Override
    public void honk() {   //Petrol car honks     }
    }
}

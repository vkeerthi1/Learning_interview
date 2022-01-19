package com.SOLID.LSP.Prob;

public class CarApplication {
    public static void main(String a[]) {
        Car car1 = new PetrolCar();
        printCarDetails(car1);
        Car car2 = new ElectricCar();
        printCarDetails(car2);
    }
    private static void printCarDetails(Car car) {
        car.fetchCo2Emission();
        car.fetchMileage();
        car.fuelTankCapacity();
    }
}
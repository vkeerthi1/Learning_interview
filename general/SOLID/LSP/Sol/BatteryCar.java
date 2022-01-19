package com.SOLID.LSP.Sol;

public abstract class BatteryCar implements Car{
    private Battery battery;
    public BatteryCar(Battery battery) {
        this.battery = battery;
    }
}

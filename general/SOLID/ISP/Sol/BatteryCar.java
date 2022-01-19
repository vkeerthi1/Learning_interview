package com.SOLID.ISP.Sol;

import com.SOLID.LSP.Sol.Battery;
import com.SOLID.LSP.Sol.Car;

public abstract class BatteryCar implements Car{
    private Battery battery;
    public BatteryCar(Battery battery) {
        this.battery = battery;
    }
}

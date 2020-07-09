package com.testmodule.pattern.factory.simplefactory;

public class CarProduct implements VehicleProduct {
    @Override
    public void run() {
        System.out.println("汽车跑...");
    }
}

package com.testmodule.pattern.factory.simplefactory;

public class PlaneProduct implements VehicleProduct {
    @Override
    public void run() {
        System.out.println("飞机飞...");
    }
}

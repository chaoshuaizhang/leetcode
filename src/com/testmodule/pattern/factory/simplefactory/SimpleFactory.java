package com.testmodule.pattern.factory.simplefactory;

public class SimpleFactory implements AbstractFactory {

    public static<T> T createProduct(String proType){
        T t = null;
        switch (proType) {
            case "car":
                t = (T) new CarProduct();
                break;
            case "plane":
                t = (T) new PlaneProduct();
                break;
        }
        return t;
    }


    @Override
    public VehicleProduct create(String proType) {
        VehicleProduct product = null;
        switch (proType) {
            case "car":
                product = new CarProduct();
                break;
            case "plane":
                product = new PlaneProduct();
                break;
        }
        return product;
    }

    public static class SimpleFactoryInstance{

        public static SimpleFactory factory = new SimpleFactory();

    }

}

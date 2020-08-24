package com.testmodule.pattern.factory.simplefactory;

/**
 * 简单工厂
 *
 * @author Administrator
 */
public class SimpleFactory implements AbstractFactory {

    /**
     * 当创建任意产品时可以调这个方法
     *
     * @param proType
     * @param <T>
     * @return
     */
    public static <T> T createProduct(String proType) {
        T t = null;
        switch (proType) {
            case "car":
                t = (T) new CarProduct();
                break;
            case "plane":
                t = (T) new PlaneProduct();
                break;
            default:
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
            default:
        }
        return product;
    }

    public static class SimpleFactoryInstance {

        public static SimpleFactory factory = new SimpleFactory();

    }

}

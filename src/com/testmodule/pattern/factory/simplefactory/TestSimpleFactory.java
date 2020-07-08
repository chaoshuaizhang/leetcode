package com.testmodule.pattern.factory.simplefactory;

/**
 * 简单工厂测试类
 *
 * @author Administrator
 */
public class TestSimpleFactory {
    public static void main(String[] args) {
        // 简单工厂模式不属于23种设计模式的范畴，那为什么会有它呢？
        // Java中的面向接口编程
        VehicleProduct vehicle = new CarProduct();
        vehicle.run();
        /*
         * 简单工厂模式
         * 优点：可以创建任意商品（下边只能创建VehicleProduct，但是可以改造下，创建任意商品）
         * 缺点：可以创建所有，所以负担会很重，如果生产的产品很多的话，在create方法中会有很多的逻辑，
         * 并且没有做到对扩展开放，如果想扩展，就要修改核心的create逻辑
         *
         * 如果想在交通工具下再来一款产品，船，直接创建即可，然后修改SimpleFactory的create方法
         *
         * */
        AbstractFactory factory = SimpleFactory.SimpleFactoryInstance.factory;
        VehicleProduct product = factory.create("plane");
        product.run();
    }
}

package com.testmodule.pattern.factory.factorymethod;

public class TestFactoryMethod {
    public static void main(String[] args) {

        /*
        * 优点：对比前边的简单工厂，可以发现每个产品对应的都有一个工厂，你想创建一个新的产品
        * 时，不需要修改别的工厂的方法，只需要创建一个生产新产品的新工厂就行。即使你新想生产
        * 小米电池，那么直接创建一个小米电池工厂就行。同理如果像生产魅族手机壳，直接创建魅族
        * 手机壳产品、工厂就行
        * 缺点：
        *   1. 如果后期产生的产品太多时，会出现无数的工厂.
        *   2.
        *  与抽象工厂相比：可以创建任意产品
        *  【感觉就是工厂方法是针对产品维度来说的，抽象工厂是根据产品簇维度来说的】
        * */
        //如果想生产华为的电池，直接改变工厂就行
        AbstractFactory factory = new XiaoMiPowerFactory();
        //如果想切换产品，直接改变产品就行
        PhoneProduct product = factory.create();
        product.productFeatures();
    }
}

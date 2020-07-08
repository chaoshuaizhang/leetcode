package com.testmodule.pattern.factory.abstractfactory;

import com.testmodule.pattern.factory.factorymethod.XiaoMiPowerFactory;

public class TestAbstractFactory {
    public static void main(String[] args) {
        /*
        * 对于抽象工厂来说：它扩展产品组是很方便的，比如现在要添加一个生产魅族周边产品的工厂，
        * 只需要添加一个魅族工厂以及相关产品就行，不需要修改其他的工厂。
        * 但是如果现在想新添加一种产品，比如手机壳，则需要在AbstractFactory
        * 中新添加一个创建手机壳的方法，此时，华为工厂、小米工厂等所有工厂都需
        * 要重写这个方法，这是比较麻烦的，并且如果有一个工厂不生产手机壳，不好
        * 意思，没办法，照样需要重写！
        * */
        AbstractFactory factory = new XiaoMiPhoneFactory();
        PowerPhoneProduct powerProduct = factory.createPowerProduct();
        ScreenPhoneProduct screenProduct = factory.createScreenProduct();
        screenProduct.productScreen();
        powerProduct.productPower();
    }
}

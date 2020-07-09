package com.testmodule.pattern.factory.factorymethod;

/**
 * 生产华为手机电池产品的工厂
 */
public class HuaWeiPowerFactory implements AbstractFactory {
    @Override
    public PhoneProduct create() {
        return new HuaWeiPowerProduct();
    }
}
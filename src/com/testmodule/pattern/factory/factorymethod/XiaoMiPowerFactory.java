package com.testmodule.pattern.factory.factorymethod;

/**
 * 生产华为手机电池产品的工厂
 */
public class XiaoMiPowerFactory implements AbstractFactory {
    @Override
    public PhoneProduct create() {
        return new XiaoMiPowerProduct();
    }
}
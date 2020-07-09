package com.testmodule.pattern.factory.factorymethod;

/**
 * 华为手机周边产品的基类
 */
public class XiaoMiPowerProduct implements PhoneProduct {
    @Override
    public void productFeatures() {
        System.out.println("小米工厂生产小米电源...");
    }
}

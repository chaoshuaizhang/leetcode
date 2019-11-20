package com.testmodule.pattern.factory.factorymethod;

/**
 * 华为手机电源产品
 */
public class HuaWeiPowerProduct implements PhoneProduct {
    @Override
    public void productFeatures() {
        System.out.println("电池工厂创建一个电池...");
    }
}

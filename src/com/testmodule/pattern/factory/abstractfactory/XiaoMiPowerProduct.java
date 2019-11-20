package com.testmodule.pattern.factory.abstractfactory;

/**
 * 华为手机电源产品
 */
public class XiaoMiPowerProduct implements PhoneProduct {
    @Override
    public void productFeatures() {
        System.out.println("小米电池工厂创建一个小米电池...");
    }
}

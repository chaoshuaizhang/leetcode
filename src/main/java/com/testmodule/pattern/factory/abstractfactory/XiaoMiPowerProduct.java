package com.testmodule.pattern.factory.abstractfactory;

/**
 * 华为手机电源产品
 */
public class XiaoMiPowerProduct implements PowerPhoneProduct {
    @Override
    public void productPower() {
        System.out.println("小米工厂创建一个小米电池...");
    }
}

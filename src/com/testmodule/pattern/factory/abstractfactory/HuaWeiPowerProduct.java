package com.testmodule.pattern.factory.abstractfactory;

/**
 * 华为手机电源产品
 */
public class HuaWeiPowerProduct implements PowerPhoneProduct {
    @Override
    public void productPower() {
        System.out.println("华为电池工厂创建一个华为电池...");
    }
}

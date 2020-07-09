package com.testmodule.pattern.factory.factorymethod;

/**
 * 华为手机屏幕产品
 */
public class HuaWeiScreenProduct implements PhoneProduct {
    @Override
    public void productFeatures() {
        System.out.println("华为屏幕工厂创建一个华为手机屏幕...");
    }
}

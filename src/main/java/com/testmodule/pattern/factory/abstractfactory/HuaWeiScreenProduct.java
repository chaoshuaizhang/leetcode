package com.testmodule.pattern.factory.abstractfactory;

/**
 * 华为手机屏幕产品
 */
public class HuaWeiScreenProduct implements ScreenPhoneProduct {
    @Override
    public void productScreen() {
        System.out.println("华为屏幕工厂创建一个华为手机屏幕...");
    }
}

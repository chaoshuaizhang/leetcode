package com.testmodule.pattern.factory.abstractfactory;

import com.testmodule.pattern.factory.factorymethod.PhoneProduct;

/**
 * 华为手机屏幕产品
 */
public class XiaoMiScreenProduct implements ScreenPhoneProduct {

    @Override
    public void productScreen() {
        System.out.println("小米工厂创建一个小米手机屏幕...");
    }
}

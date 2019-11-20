package com.testmodule.pattern.factory.factorymethod;

/**
 * 生产华为手机屏幕的工厂
 */
public class HuaWeiScreenFactory implements AbstractFactory {
    @Override
    public PhoneProduct create() {
        return new HuaWeiScreenProduct();
    }
}

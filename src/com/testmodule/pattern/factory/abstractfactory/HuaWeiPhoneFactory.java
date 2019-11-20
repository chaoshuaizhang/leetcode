package com.testmodule.pattern.factory.abstractfactory;

public class HuaWeiPhoneFactory implements AbstractFactory {
    @Override
    public ScreenPhoneProduct createScreenProduct() {
        return new HuaWeiScreenProduct();
    }

    @Override
    public PowerPhoneProduct createPowerProduct() {
        return new HuaWeiPowerProduct();
    }
}

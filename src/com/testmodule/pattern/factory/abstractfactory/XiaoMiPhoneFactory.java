package com.testmodule.pattern.factory.abstractfactory;

public class XiaoMiPhoneFactory implements AbstractFactory {
    @Override
    public ScreenPhoneProduct createScreenProduct() {
        return new XiaoMiScreenProduct();
    }

    @Override
    public PowerPhoneProduct createPowerProduct() {
        return new XiaoMiPowerProduct();
    }
}

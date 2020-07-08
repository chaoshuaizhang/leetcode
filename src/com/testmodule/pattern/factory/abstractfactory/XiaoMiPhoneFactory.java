package com.testmodule.pattern.factory.abstractfactory;

import com.testmodule.pattern.factory.factorymethod.PhoneProduct;

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

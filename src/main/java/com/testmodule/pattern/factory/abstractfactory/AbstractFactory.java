package com.testmodule.pattern.factory.abstractfactory;


public interface AbstractFactory {
    ScreenPhoneProduct createScreenProduct();

    PowerPhoneProduct createPowerProduct();
}

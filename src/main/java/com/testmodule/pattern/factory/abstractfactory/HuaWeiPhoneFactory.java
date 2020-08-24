package com.testmodule.pattern.factory.abstractfactory;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class HuaWeiPhoneFactory implements AbstractFactory {
    @Override
    public ScreenPhoneProduct createScreenProduct() {
        PhantomReference<String> p = new PhantomReference<>(this.toString(), new ReferenceQueue<>());
        return new HuaWeiScreenProduct();
    }

    @Override
    public PowerPhoneProduct createPowerProduct() {
        return new HuaWeiPowerProduct();
    }
}

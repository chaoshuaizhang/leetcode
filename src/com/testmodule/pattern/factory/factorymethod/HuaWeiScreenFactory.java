package com.testmodule.pattern.factory.factorymethod;

import com.testmodule.pattern.factory.abstractfactory.XiaoMiPhoneProduct;
import com.testmodule.testKotlin.service.impl.CartServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * 生产华为手机屏幕的工厂
 * @author Administrator
 */
public class HuaWeiScreenFactory implements AbstractFactory {
    @Override
    public PhoneProduct create() {
        return new HuaWeiScreenProduct();
    }
}

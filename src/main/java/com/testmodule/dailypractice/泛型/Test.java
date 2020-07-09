package com.testmodule.dailypractice.泛型;

import com.testmodule.pattern.factory.factorymethod.HuaWeiPowerProduct;
import com.testmodule.pattern.factory.factorymethod.PhoneProduct;
import com.testmodule.pattern.factory.factorymethod.XiaoMiPowerProduct;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author changePosition
 * @date 2020/4/25/025 0:07
 */
public class Test {
    public static void main(String[] args) {

        List<? super XiaoMiPowerProduct> l1 = new ArrayList<>();
        List<? super HuaWeiPowerProduct> l2 = new ArrayList<>();
        System.out.println(l1.getClass() == l2.getClass());
        Erasure<XiaoMiPowerProduct> erasure = new Erasure<>(null);
        try {
            Method add = erasure.getClass().getDeclaredMethod("add", PhoneProduct.class);
//            add.invoke(erasure,"123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(l1.size());
        Class eclz = erasure.getClass();
        System.out.println("erasure class is:"+eclz.getName());
        Field[] fields = erasure.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getType().getName());
        }
        List<? extends PhoneProduct> list = new ArrayList<>();
        List<XiaoMiPowerProduct> xiaoMiPowerProducts = new ArrayList<>();
        xiaoMiPowerProducts.add(new XiaoMiPowerProduct());
        xiaoMiPowerProducts.add(new XiaoMiPowerProduct());
        xiaoMiPowerProducts.add(new XiaoMiPowerProduct());
        list = xiaoMiPowerProducts;
        list.remove(0);
        System.out.println(xiaoMiPowerProducts.size());
    }
}

class Erasure <T extends PhoneProduct>{
 //  public class Erasure <T>{
           T object;

           public Erasure(T object) {
               this.object = object;
           }

           public void add(T t){
               object = t;
           }

        }
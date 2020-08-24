package com.testmodule.剑指offer.C04_二维数组中的查找;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.sun.org.apache.xalan.internal.xsltc.trax.DOM2TO;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * @author changePosition
 * @date 2020/7/31/031 9:12
 */
public class Test0731 {
    public static void main(String[] args) {
//        Integer a = new Integer(6);
//        Integer b = new Integer(8);
//        a.compareTo(b);
        B b = new B();
        JSONObject.parseObject("", DOM2TO.class);
        Object parse = JSON.parseObject("", new TypeReference<DOM2TO>() {
        }.getType());
        B.a();
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("11");
        set.add("222");
        set.add("3a");
        set.add("42");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

class A {
    public static void a(){}
}

class B extends A {
    public static void a(){}
}

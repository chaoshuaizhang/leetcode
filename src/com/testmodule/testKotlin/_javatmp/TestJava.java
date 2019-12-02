package com.testmodule.testKotlin._javatmp;

import com.alibaba.fastjson.JSONArray;
import com.google.gson.Gson;
import com.testmodule.testKotlin.entity.RefundEntity;

import java.util.ArrayList;
import java.util.List;

public class TestJava {
    List<String> listStr = new ArrayList<>();
    static List<Integer> listInt = new ArrayList<>();
    public static void main(String[] args) {
        JSONArray array = new JSONArray();
        RefundEntity entity = new RefundEntity(1, 1, "1");
        entity.a = "aaa";
        entity.t = "ttt";
        array.add(entity);
        System.out.println(new Gson().toJson(array));
//        System.out.println(array.toJSONString());
        System.out.println("Test Java");
        for (int i = 0; i < listInt.size(); i++) {
            Integer integer = listInt.get(i);
        }
    }

    public static int getNum(int num) {
        num++;
        return num;
    }

    private static class InnerStaticClass{
        private void innerFun(){}
    }

    private class InnerClass{
        private void fun(){}
    }

}

class OutClass<T>{
    T t;
    public String getStr(String str){
        return str;
    }
}
class MO extends OutClass<String>{}
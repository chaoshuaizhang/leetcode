package com.leetcode.testKotlin;

import java.util.ArrayList;
import java.util.List;

public class TestJava {
    List<String> listStr = new ArrayList<>();
    static List<Integer> listInt = new ArrayList<>();
    public static void main(String[] args) {
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

class OutClass{
    public String getStr(String str){
        return str;
    }
}

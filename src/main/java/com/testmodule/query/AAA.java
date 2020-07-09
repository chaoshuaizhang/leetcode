//package com.testmodule.query;
//
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
//interface AAA {
//
//    public HashMap a();
//}
//
//public class BBB implements AAA {
//
//    public static void main(String[] args) {
//        AAA a = new BBB();
//        ((BBB) a).bb();
//        CCC c = new CCC();
//        c.cc();
//        BBB b = (BBB)c;
//    }
//
//    public void bb(){}
//
//    public HashMap a() {
//        System.out.println("BBB");
//        return null;
//    }
//}
//
//class CCC extends BBB{
//    public void cc(){}
//}

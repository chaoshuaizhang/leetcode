package com.testmodule.pattern.singleton;

/**
 * @author changePosition
 * @date 2020/3/2/002 16:15
 */
public class TestSingleton {
    static {
        System.out.println("-----");
    }

    private static class MyInstance{
        static {
            System.out.println("inner");
        }
    }

}

class Test{
    public static void main(String[] args) {
        System.out.println("+++++");
        TestSingleton[] arr = new TestSingleton[5];
        System.out.println(arr[0]);
    }
}
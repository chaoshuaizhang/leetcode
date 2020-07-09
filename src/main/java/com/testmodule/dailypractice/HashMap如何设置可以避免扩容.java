package com.testmodule.dailypractice;

/**
 * 假设我们知道创建的map最大会放置多少个元素，那我们可
 * 以提前设置map的初始大小，那么设置多大才能不让其在后
 * 期的使用中自动扩容？
 */
public class HashMap如何设置可以避免扩容 {
    static final int MAXIMUM_CAPACITY = 1 << 30;
    public static void main(String[] args) {
        TestHashMap testHashMap = new TestHashMap();
        System.out.println(testHashMap.tableSizeFor(1000000) * 0.75);
//        System.out.println(testHashMap.tableSizeFor2(16) );
        System.out.println(testHashMap.tableSizeFor(100000) * 0.75);
        System.out.println(testHashMap.tableSizeFor(10000) * 0.75);
        System.out.println(testHashMap.tableSizeFor(1000) * 0.75);
        System.out.println(testHashMap.tableSizeFor(100) * 0.75);
        System.out.println(testHashMap.tableSizeFor(10) * 0.75);
        System.out.println(testHashMap.tableSizeFor(3) * 0.75);
        System.out.println(testHashMap.hash(testHashMap.hashCode()));
        System.out.println(testHashMap.hash(testHashMap));
    }

    static class TestHashMap{

        final int tableSizeFor(int cap) {
            int n = cap - 1;
            int tmp = n >>> 1;
            n |= tmp;
            tmp = n >>> 2;
            n |= tmp;
            tmp = n >>> 4;
            n |= tmp;
            tmp = n >>> 8;
            n |= tmp;
            tmp = n >>> 16;
            n |= tmp;
            return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
        }

        final int tableSizeFor2(int cap) {
            int n = cap;
            n |= n >>> 1;
            n |= n >>> 2;
            n |= n >>> 4;
            n |= n >>> 8;
            n |= n >>> 16;
            return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
        }

        final int hash(Object key) {
            int h;
            return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        }

        int hash ( int h){
            //通过key的hashCode重新计算出一个分布更均匀的值，减少插入时的碰撞
            h ^= (h >>> 20) ^ (h >>> 12);
            return h ^ (h >>> 7) ^ (h >>> 4);
        }
    }
}

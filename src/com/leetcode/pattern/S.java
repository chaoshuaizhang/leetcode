package com.leetcode.pattern;


import java.util.HashMap;

public class S{

    static final int MAXIMUM_CAPACITY = 1 << 30;
    public static void main(String[] args) {
        System.out.println(tableSizeFor(1000000) * 0.75);
        System.out.println(tableSizeFor(100000) * 0.75);
        System.out.println(tableSizeFor(10000) * 0.75);
        System.out.println(tableSizeFor(1000) * 0.75);
        System.out.println(tableSizeFor(100) * 0.75);
        System.out.println(tableSizeFor(10) * 0.75);
//        S s = new S();
//        System.out.println(hash(s.hashCode()));
//        System.out.println(hash(s));
    }

    static final int tableSizeFor(int cap) {
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

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static int hash ( int h){
        //通过key的hashCode重新计算出一个分布更均匀的值，减少插入时的碰撞
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

}

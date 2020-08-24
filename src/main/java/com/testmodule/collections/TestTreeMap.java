package com.testmodule.collections;

import com.testmodule.testKotlin.entity.CartEntity;
import sun.nio.ch.FileChannelImpl;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.LockSupport;

/**
 * @author changePosition
 * @date 2020/7/9/009 16:59
 */
public class TestTreeMap<K> implements Comparable<Integer>, Comparator<String> {
    Comparator comparator;

    public static void main(String[] args) {

        try {
            System.out.println(t());
        } catch (Exception e) {
            e.printStackTrace();
        }

//        ByteBuffer.allocateDirect(100);
//        TreeMap<Object, Object> map = new TreeMap<>();
//        for (int i = 0; i < 15; i++) {
//            Object c = new Object();
//            map.put(c, c);
//        }
//        Iterator<Object> iterator = map.keySet().iterator();
    }

    @Override
    public int compareTo(Integer o) {
        return 0;
    }

    @Override
    public int compare(String k1, String k2) {
        return comparator == null ? ((Comparable<? super K>) k1).compareTo((K) k2)
                : comparator.compare((K) k1, (K) k2);
    }

    public static int t() throws Exception {
        try {
            throw new Exception("111111");
        }catch (Exception e){
            throw new Exception("222222");
        }finally {
            throw new Exception("-----");
        }
    }
}

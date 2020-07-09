package com.testmodule.java8;

import com.alibaba.fastjson.JSONObject;
import com.testmodule.testKotlin.entity.CartEntity;

import java.io.File;
import java.io.FileFilter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author changePosition
 * @date 2020/6/8/008 14:12
 */
public class Test {
    private static List<CartEntity> list = new ArrayList<>();

    static {
        CartEntity entity1 = new CartEntity("1001");
        CartEntity entity2 = new CartEntity("1002");
        CartEntity entity3 = new CartEntity("1003");
        CartEntity entity4 = new CartEntity("1004");
        CartEntity entity5 = new CartEntity("1005");
        entity1.currentPrice = new BigDecimal(1001);
        entity2.currentPrice = new BigDecimal(1002);
        entity3.currentPrice = new BigDecimal(1003);
        entity4.currentPrice = new BigDecimal(1004);
        entity5.currentPrice = new BigDecimal(1005);
        list.add(entity1);
        list.add(entity2);
        list.add(entity3);
        list.add(entity4);
        list.add(entity5);
    }

    private static void testSort() {
        // 默认的写法
        Collections.sort(list, new Comparator<CartEntity>() {
            @Override
            public int compare(CartEntity o1, CartEntity o2) {
                if (o1.currentPrice.doubleValue() > o2.currentPrice.doubleValue()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        printList(list);

        // 直接把内部类转换为lambda
        Collections.sort(list, (o1, o2) -> {
            if (o1.currentPrice.doubleValue() > o2.currentPrice.doubleValue()) {
                return 1;
            }
            return -1;
        });
        printList(list);
        // 结合java8的lambda
        list.sort((o1, o2) -> {
            if (o1.currentPrice.doubleValue() > o2.currentPrice.doubleValue()) {
                return -1;
            }
            return 1;
        });
        printList(list);

        // 正序
        list.sort(Comparator.comparing(CartEntity::getCurrentPrice));
        printList(list);

        //倒序
        list.sort(Comparator.comparing(CartEntity::getCurrentPrice).reversed());
        printList(list);
    }

    private static void testPredicate(List<CartEntity> entities, MyPredicate<CartEntity> predicate) {
        for (CartEntity entity : entities) {
            if (predicate.test(entity)) {
                System.out.println("符合条件：" + entity.currentPrice.doubleValue());
            }
        }
        Function<CartEntity, Boolean> f;
    }

    public static void main(String[] args) {
        // 把方法当参数传递
        testPredicate(list, Test::isRemove);

        // 上边的优化
        testPredicate(list, c -> c.currentPrice.doubleValue() > 1003);

        prettyPrintApple(list, new MyPredicateImpl2());

        prettyPrintApple(list, cartEntity ->
            "添加描述："+cartEntity.currentPrice.toString()
        );

        System.out.println(JSONObject.toJSONString(null));

        new Thread(()->{
            System.out.println();
        });
        System.exit(0);

    }

    private static boolean isRemove(CartEntity entity) {
        return entity.currentPrice.doubleValue() > 1003;
    }

    private static void printList(List<CartEntity> list) {
        System.out.println("------------------------------------");
        for (CartEntity entity : list) {
            System.out.println(entity.getCardId());
        }
    }

    private static void prettyPrintApple(List<CartEntity> list, MyPredicate2<CartEntity> predicate){
        // 根据条件去操作list
        for (CartEntity entity : list) {
            System.out.println(predicate.test(entity));
        }
    }

    private static <T> void prettyPrintAnything(List<T> list, MyPredicate2<T> predicate){
        // 根据条件去操作list
        for (T t : list) {
            System.out.println(predicate.test(t));
        }
    }

    interface MyPredicate<T>{
        boolean test(T t);
    }

    /*
    * 自定义Predicate，和系统自带的Predicate一样
    * */
    class MyPredicateImpl implements MyPredicate<CartEntity>{
        @Override
        public boolean test(CartEntity cartEntity) {
            return false;
        }
    }

    interface MyPredicate2<T>{
        String test(T t);
    }

    static class MyPredicateImpl2 implements MyPredicate2<CartEntity>{
        @Override
        public String test(CartEntity cartEntity) {
            return String.valueOf(cartEntity.currentPrice.doubleValue());
        }
    }
    class MyPredicateImpl21 implements MyPredicate2<CartEntity>{
        @Override
        public String test(CartEntity cartEntity) {
            return String.valueOf(cartEntity.currentPrice.doubleValue()+100);
        }
    }

}

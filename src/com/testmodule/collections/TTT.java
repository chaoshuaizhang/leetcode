package com.testmodule.collections;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TTT {

    public static void main(String[] args) {

        int aw = 1;
        int sw = 2;
        int dw = 3;

        System.out.println(aw & 1);
        System.out.println(sw & 1);
        System.out.println(dw & 1);

        System.out.println("]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]");

        aw = sw = dw;
        System.out.println(sw);
        System.out.println(aw);

        System.out.println("[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[");


        TE t1 = new TE("a");
        TE t2 = new TE("b");
        t1.next = t2;
        t2 = t1;
        int n = 9;
        System.out.println(9|9>>>1);
        System.out.println("===");


        Map<String, String> map = new HashMap<>();
        map.put(null, null);
        ConcurrentHashMap<String, String> map1 = new ConcurrentHashMap<>(1);
        map1.put(null, null);
        map.put("a", "aaa");
        for (int i = 1; i < 3; i++) {
            map.put(""+i,""+i);
        }
        for (String s : map.keySet()) {
            if(s.equals("1"))
            map.remove("1");
        }
        try {
            map1.put("11","as");
            Class<? extends Map> aClass = map1.getClass();
            Field threshold = aClass.getDeclaredField("threshold");
            int o = (int) threshold.get(map1);
            System.out.println("------------------------");
            System.out.println(o);
            System.out.println("------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.get("");
        map.remove("");
        Set<String> set = map.keySet();
        Iterator<String> iterator = set.iterator();
        Set<Map.Entry<String, String>> entries = map.entrySet();
        map.clear();

        BaseA baseA = new BaseA("aaa");
        try {
            BaseA clone = (BaseA) baseA.clone();
            System.out.println(baseA == clone);
            System.out.println(baseA.tag == clone.tag);
            System.out.println(baseA.director == clone.director);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


        //一般情况下我们创建一个对象是这样做的
        //构造方法里填入必传参数，其他可选参数通过set方法设置
        AlertDialog dialog = new AlertDialog(1001, "标题");
        dialog.setColor(0x000000);
        dialog.setContent("内容");
        dialog.setButtonText("确定");
        //dialog对象创建完成，开始使用


        //使用建造者模式，注意这里的id和title表示必传参数，任何对象都需要传这两个参数
        AlertDialog alertDialog = new AlertDialog.Builder(1001, "标题")
                .setColor(0x000000)
                .setContent("内容")
                .setButtonText("确定")
                .build();
        //alertDialog构造完成开始使用

        //
        List<String> a = new ArrayList<>();
        a(Collections.singletonList(a));

    }

    static void a(List<Object> o) {
    }

}

class AlertDialog {

    public AlertDialog(Builder builder) {
    }

    public AlertDialog(int id, String title) {

    }

    public void setContent(String content) {
    }

    public void setColor(int color) {
    }

    public void setButtonText(String btnText) {
    }

    public static class Builder {

        public Builder(int id, String title) {
        }

        public Builder setContent(String content) {
            return this;
        }

        public Builder setColor(int color) {
            return this;
        }

        public Builder setButtonText(String btnText) {
            return this;
        }

        public AlertDialog build() {
            return new AlertDialog(this);
        }

        public AlertDialog getResult() {
            return new AlertDialog(this);
        }
    }

}

class Director implements Cloneable {

    private AlertDialog.Builder builder;

    public Director(AlertDialog.Builder builder) {
        this.builder = builder;
    }

    public void construct(String content, int color, String btnText) {
        builder.setContent(content);
        builder.setColor(color);
        builder.setButtonText(btnText);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class BaseA implements Cloneable {
    public String tag;

    public Director director = new Director(null);

    public BaseA(String tag) {
        this.tag = tag;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        BaseA clone = (BaseA) super.clone();
        clone.director = (Director) clone.director.clone();
        return clone;
    }
}

class TE extends BaseA {

    private String a;
    public TE next;

    public TE(String tag) {
        super(tag);
    }
}

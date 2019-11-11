package com.leetcode;

public class TTT {

    public static void main(String[] args) {
        //一般情况下我们创建一个对象是这样做的
        //构造方法里填入比传参数，其他可选参数通过set方法设置
        AlertDialog dialog = new AlertDialog(1001, "标题");
        dialog.setColor(0x000000);
        dialog.setContent("内容");
        dialog.setButtonText("确定");
        //dialog对象创建完成，开始使用


        //使用建造者模式，注意这里的id和title表示比传参数，任何对象都需要传这两个参数
        AlertDialog alertDialog = new AlertDialog.Builder(1001, "标题")
                .setColor(0x000000)
                .setContent("内容")
                .setButtonText("确定")
                .build();
        //alertDialog构造完成开始使用

        //
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

class Director {

    private AlertDialog.Builder builder;

    public Director(AlertDialog.Builder builder) {
        this.builder = builder;
    }

    public void construct(String content, int color, String btnText) {
        builder.setContent(content);
        builder.setColor(color);
        builder.setButtonText(btnText);
    }

}

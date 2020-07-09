package com.testmodule.dailypractice;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;

class 文件操作 {
    public static void main(String[] args) throws Exception {
        //定义一个文件路径（文件可以不存在）
        read();
    }

    private static void write()  throws Exception{
        File file = new File("F:\\study\\android\\PDF书籍", "text.txt");
        //dos输入到文件
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        String data = "BCHU以5或叫jdnbhDBVHUFBVHFVEBRE吧v覅吧v54副本vicudbviuervu热比";
        byte[] bytes = data.getBytes();
        dos.write(bytes);
        dos.close();
        //开始输出
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        byte[] all = new byte[bytes.length];
        int read = dis.read(all);
        dis.close();
        System.out.println(all.length + "     " + read+"      "+new String(all));
    }

    private static void read() throws Exception{
        File file = new File("F:\\study\\android", "hsp.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuilder builder = new StringBuilder();
        String s;
        while ((s = bufferedReader.readLine()) != null){
            builder.append(s);
        }
        JSONArray array = JSONArray.parseArray(builder.toString());
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.getJSONObject(i).getString("part"));
        }
//        FileInputStream fileInputStream = new FileInputStream(file);
//        byte[] bytes = new byte[1024];
//        while (fileInputStream.read(bytes) > 0){
//            builder.append(new String(bytes,"UTF-8"));
//        }

//        System.out.println(builder.toString());
    }




}

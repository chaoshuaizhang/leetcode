package com.leetcode.dailypractice;

import java.io.*;
import java.nio.ByteBuffer;

class 文件操作 {
    public static void main(String[] args) throws Exception {
        //定义一个文件路径（文件可以不存在）
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
}

package com.leetcode.dailypractice;

import java.io.File;

class PrintFilesName {

    public static void main(String[] args) {
        //printFileName(new File("E:\\CCAA\\程序文件"));
        byte[] b = new byte[100];
        System.out.println(b.length);
    }

    static void printFileName(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                File fileTmp = files[i];
                if (fileTmp.isDirectory()) {
                    printFileName(fileTmp);
                }else{
                    System.out.println(fileTmp.getName());
                }
            }
        }
        System.out.println(file.getName());
    }

}

package com.FANXING.ggc;

import org.junit.Test;

import java.io.File;

/**
 * File类的使用
 * 1.file类的一个对象,代表一个文件或者一个文件目录(俗称:文件夹);
 * 2.file类声明在Java.io包下
 * 3.路径分隔符: Windows:\\
 */
public class FileTest {
    @Test
    public void test1(){
//        构造器1
        File fil = new File("hellow.txt");
        System.out.println(fil);
//        构造器二
        File file2 = new File("D:\\workspace_ideal","javaSenior");
        System.out.println(file2);
//        构造器三
        File file3 = new File(file2,"hi,tet");
        System.out.println(file3);
    }
}

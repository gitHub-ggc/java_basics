package com.FANXING.ggc;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class fileTest2 {
    public static void main(String[] args) {
//        File file1 = new File("cc");
//        File file2 = new File("E:\\hsssssssssssi.txt");
//        boolean renameTo =  file1.renameTo(file2);
//        System.out.println(renameTo);
        File file1 = new File("D:\\developer_tools\\workspace_ideal\\day03");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());
    }
    @Test
    public void test2() throws IOException {
        File file = new File("Wo.txt");
        if(!file.exists()){
          file.createNewFile();
            System.out.println("创建成功!");
        }else{
            file.delete();
        }

    }
    @Test
    public void test3() throws IOException {
       File file = new File("D:\\developer_tools\\io\\hello.txt");
        File file2 = new File(file.getParent(),"haha.txt");
        if(!file2.exists()){
            file2.createNewFile();
            System.out.println("创建成功!");
        }
    }
    @Test
    public void test4(){//找出该文件目录下的所有含有后缀名为jpg的文件
        File srcFile = new File("D:\\developer_tools\\io");
        String[] fileNames = srcFile.list();
        for(String fileName : fileNames){
            if(fileName.endsWith(".jpg")){
                System.out.println(fileName);
            }
        }
    }
    @Test
    public void test5(){

    }
}

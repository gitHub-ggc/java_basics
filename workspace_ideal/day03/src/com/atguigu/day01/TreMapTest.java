package com.atguigu.day01;

import org.junit.Test;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.TreeMap;

public class TreMapTest {
    public static void main(String[] args) throws Exception {

          Properties pros =  new Properties();
          FileInputStream fis = new FileInputStream("jdbc.properties");
          pros.load(fis);//加载流对应的文件
          String  name = pros.getProperty("name");
          String password = pros.getProperty("password");
          System.out.println("name = " + name + ", password = " + password);
    }
    @Test
    public void test1(){
        TreeMap treeMap = new TreeMap();
    }
}


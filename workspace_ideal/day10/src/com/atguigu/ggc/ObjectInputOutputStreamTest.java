package com.atguigu.ggc;

import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用
 * 1.ObjectInputSteam 和 ObjectOutputStream
 * 2.作用:用于存储和读取基本数据类型或对象的处理流,它的强大之处就是把Java中
 */
public class ObjectInputOutputStreamTest {
    @Test
    public void test() {
        //序列:将内存中的对象转化为二进制流保存到文件中或者被其它网络接口所捕捉
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("hellow.dat"));
            oos.writeObject(new String("我爱北京天安门!"));
            oos.flush();
            oos.writeObject(new Person("张三",23));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    @Test
    public void test2() {
        //反序列化:将磁盘文件中的对象还原为内存中的一个Java对象
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("hellow.dat"));
            Object obj = ois.readObject();
            String str = (String)obj;
//            System.out.println(str);
            Person ps = (Person)ois.readObject();
            System.out.println(ps);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

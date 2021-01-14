package com.atguigu.ggc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 1.遍历Collection的两种方式
 * 使用迭代器 2.增强for循环 3.java8中
 * 2.Java.utils包下定义的迭代器接口:Interator
 * <p>
 * 2.1说明:
 * <p>
 * 2.2作用:
 * <p>
 * 2.3如何获取实例:
 * <p>
 * 2.4遍历代码的实现:
 * <p>
 * 2.5remove()的使用
 */

public class ListExer {
    @Test
    public void testListRemove(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }
    private static void updateList(List list){
        list.remove(2);
        list.remove(new Integer(2));
    }
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(343);
        coll.add(343);
        coll.forEach(System.out::println);
    }
    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(343);
        coll.add(897);
        for(Object obj : coll){
            System.out.println(obj);
        }
    }
    //增强for循环遍历数组
    @Test
    public void test3(){
        int [] arr = new int[]{1,2,3,4,5,6};
        for(int i : arr){
            System.out.println(i);
        }
    }
}

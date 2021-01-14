package com.atguigu.ggc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 常用的方法
 *   1.增:add(object obj)
 *     删:remove(int index) / remove(object obj)
 *     改:set(int index,Object ele)
 *     查:get(int index)
 *     插:add(int index,Object ele)
 *     长度:size()
 *     遍历:1.Iterator 迭代器方式
 *          2.增强for循环
 *          3.普通的循环
 */
public class ListTest {
    @Test
    public  void test1(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(123);
        arrayList.add(456);
        arrayList.add("AA");
        arrayList.add(new test7("Tom",12));
        arrayList.add(456);

        arrayList.add(1,"BB");
        System.out.println(arrayList);
        List integers = Arrays.asList(1, 2, 3);
        arrayList.addAll(integers);
        arrayList.indexOf(456);
        System.out.println(arrayList);

    }
    @Test
    public void test3(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(123);
        arrayList.add(456);
        arrayList.add("AA");
        //方式一:iterator迭代器方式
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
       //方式二:增强for循环
        for(Object obj : arrayList){
            System.out.println(obj);
        }
        //方式三:普通for循环
        for(int i = 0 ; i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
    }
}

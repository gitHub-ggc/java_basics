package com.atguigu.day01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *面试题:Collection和Collections的区别
 * 答:Collection是一个接口,而Collections是一个操作Coolection接口的工具类
 */
public class CollectionsTest {
   @Test
   public void test1(){
       List list = new ArrayList();
       list.add(123);
       list.add(43);
       list.add(765);
       list.add(-97);
       list.add(0);
//       System.out.println(list);
//       Collections.reverse(list);
//       Collections.shuffle(list);
//       Collections.sort(list);
//       Collections.swap(List,i:1,i:2);
       List dest = Arrays.asList(new Object[list.size()]);
       Collections.copy(dest,list);
       System.out.println(dest);
       /**
        * Collections 类中提供多个synchronizedXxx()方法,该方法可使将指定集合包装成线程同步的集合
        *从而可以解决多线程并发访问集合时的线程安全问题
        */
        List list1 = Collections.synchronizedList(list);
   }
}

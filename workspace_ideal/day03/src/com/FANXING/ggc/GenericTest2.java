package com.FANXING.ggc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 1.泛型在继承方面的体现
 *
 * 2.通配符的使用:?
 * 不能写入数据(除了null),但是可以读取数据
 */
public class GenericTest2 {
   @Test
    public void test1(){
       List<Object> list1 = null;
       List<String> list2 = null;
       List<?> list = null;
       list = list1;
       list = list2;
//       print(list1);
//       print(list2);
       ArrayList<String> list3 = new ArrayList<>();
       list3.add("1");
       list3.add("2");
       list3.add("6");
       list = list3;
       Object o = list.get(0);
       System.out.println(o);

   }
   public void print(List<?> list){
       Iterator<?> iterator = list.iterator();
       while (iterator.hasNext()){
           Object obj = iterator.next();
           System.out.println(obj);
       }
   }
}

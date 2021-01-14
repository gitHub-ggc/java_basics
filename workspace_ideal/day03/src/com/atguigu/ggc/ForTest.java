package com.atguigu.ggc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * foreeach用于遍历集合或者数组
 */
public class ForTest {
    @Test
    public void test() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(456);
        for(Object obj : coll){
            System.out.println(obj);
        }
    }
    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,5,6};
        for(int i : arr){
            System.out.println(i);
        }
    }
}

package com.FANXING.ggc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ziDingYiFanZing2 {

    @Test
    public void test1(){
        ziDingYiFanZing<String> p = new ziDingYiFanZing<String>(11,"33","55");
    }
    @Test
    public <E>List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for(E e : arr){
            list.add(e);
        }
        return list;
    }
}
class tests{
    public static void main(String[] args) {
        ziDingYiFanZing2 t1 = new ziDingYiFanZing2();
        Integer[] arr = new Integer[]{1,2,3,4,5};
        List<Integer> bb = t1.copyFromArrayToList(arr);
        System.out.println(bb);
    }

}

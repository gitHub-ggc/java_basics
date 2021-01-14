package com.FANXING.ggc;

import org.junit.Test;

import java.util.*;

public class GenericTest {
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(45);
        list.add(55);
        list.add(47);
        list.add(88);
//        list.add("zhangsan");
        for(Object obj : list){
           int stuScore = (Integer)obj;
            System.out.println(stuScore);
        }
    }
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(45);
        list.add(99);
        list.add(55);
        list.add(39);
//        list.add("ss");
//        Iterator<Integer> iterator = list.iterator();
//        while(iterator.hasNext()){
//            int sco = iterator.next();
//            System.out.println(sco);
//        }
        for(Object obj : list){
           int sco = (Integer)obj;
            System.out.println(sco);
        }
    }
    @Test
     public void test3(){
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("zhangsan",45);
        map.put("lisi",55);
        map.put("laoliu",98);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "===" + value);
        }

    }
}

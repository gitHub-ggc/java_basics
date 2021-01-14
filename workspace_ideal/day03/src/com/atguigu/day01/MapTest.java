package com.atguigu.day01;

import org.junit.Test;

import java.util.*;

public class MapTest {
    Map map = new HashMap();
    @Test
    public void test3(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);
        map.put("AA",87);
        System.out.println(map);
        HashMap map1 = new HashMap();
        map1.put("CC",123);
        map1.put("DD",123);
        map.putAll(map1);
        System.out.println(map);
        Object value = map.remove("CC");
        System.out.println(map);
        map.clear();//与map = null不同
        System.out.println(map.size());
        map.get("AA");
        //遍历所有的key集:keySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
//        遍历所有的value
        Collection values = map.values();
        for(Object obj : values){
            System.out.println(obj);
        }
        //遍历所有的key=value
        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()){
           Object obj = iterator1.next();
           Map.Entry entry = (Map.Entry) obj;
//           方式二
            Set keySet = map.keySet();
            Iterator iterator3 = keySet.iterator();
            while (iterator3.hasNext()){
                Object key = iterator3.next();
                Object valuess = map.get(key);
                System.out.println(key + "========" + value);
            }
        }
    }
}

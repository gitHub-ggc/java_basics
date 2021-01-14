package com.atguigu.day01;

import java.util.*;

public class keHuoTest implements Comparable{
    public static void main(String[] args) {
        List list = new ArrayList();
        Scanner in = new Scanner(System.in);
        System.out.println("输入5个数字");
        for(int i=0;i<5;i++){
          list.add(in.nextInt());
        }
        System.out.println(list);
        Collections.reverse(list);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        for(Object obj : list){
            System.out.println(obj);
        }

        System.out.println(list);
    }


    @Override
    public int compareTo(Object o) {
        if(o instanceof List){
            List p = (List)o;
            return 1;
        }
        return 0;
    }

}

package com.atguigu.ggc;
//比较对象的大小
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test4 {
    public static void main(String[] args) {

    }
    @Test
    public void dome() throws ParseException {
       //将字符串"2017-08-16"转化为java.sql.Date类的对象
        SimpleDateFormat p1 = new SimpleDateFormat("YYYY-MM-dd");
        Date p2 = p1.parse("2017-08-16");
        java.sql.Date p3 = new java.sql.Date(p2.getTime());
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println("*****************************************************************");

    }
}
//class Person implements Comparable{
//    private String name;
//    private int age;
//
//    @Override
//    public int compareTo(Object o) {
//        if(o instanceof Person){
//            Person p1 = (Person)o;
//            return this.name.compareTo(p1.name);
//        }
//        throw new RuntimeException();
//    }
//}
//Comparator com = new Comparator() {
//    @Override
//    public int compare(Object o1, Object o2) {
//        if(o1 instanceof Person && o2 instanceof Person){
//            Person  t1 = (Person) o1;
//            Person  t2 = (Person) o2;
//            if(t1.name.equals(t2.name)){
//                return -Double.compare(t1.age,t2.age);
//            }else {
//                return t1.name.compareTo(t2.name);
//            }
//        }
//    }
//}

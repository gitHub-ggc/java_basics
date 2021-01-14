package com.atguigu.ggc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class test7 {
    public static void main(String[] args) {

    }
    private String name;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        test7 test7 = (test7) o;
        return age == test7.age &&
                Objects.equals(name, test7.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

    public test7(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "test7{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class CollectionTest{
    @Test
    public void test1111(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(456);
        test7 p = new test7("Jerry",20);
        coll.add(p);
        //contains:判断当前集合中是否包含obj
        boolean contains = coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new String("Tom")));
        System.out.println(coll.contains(p));

        Iterator iterator = coll.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());

//        遍历集合
         while(iterator.hasNext()){
             System.out.println(iterator.next());
//             移除集合中指定的元素
             Object obj = iterator.next();
             if("Tom".equals(obj)){
                 iterator.remove();
             }
         }
         //
    }
}


package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MethodTest {
    @Test
    public void test(){
        Class<Person> personClass = Person.class;

        Method[] methods = personClass.getMethods();
        for(Method t : methods){
            System.out.println(t);
        }
        System.out.println("****************************************");
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for(Method p : declaredMethods){
            System.out.println(p);
        }

    }
    @Test
    public void test2() throws Exception {
        Class<Person> pc = Person.class;
        Person person = pc.newInstance();
        Field age = pc.getField("age");

        age.set(person,1011);
        int o = (int)age.get(person);
        System.out.println(o);
    }
    @Test
    public void test3() throws Exception {
        Class<Person> pc2 = Person.class;
        Person p2 = pc2.newInstance();

        Field id = pc2.getDeclaredField("id");
        id.setAccessible(true);
        id.set(p2,2001);
        System.out.println(id.get(p2));
    }
    @Test
    public void test4() throws Exception {
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();
        Method show = personClass.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        Object chn = show.invoke(person, "CHN");
        System.out.println(chn);
    }
    @Test
    public void test5() throws Exception {
        Class<Person> personClass = Person.class;
        Method showDec = personClass.getDeclaredMethod("showDec");
        showDec.setAccessible(true);
        Object invoke = showDec.invoke(Person.class);
        System.out.println(invoke);

    }
}

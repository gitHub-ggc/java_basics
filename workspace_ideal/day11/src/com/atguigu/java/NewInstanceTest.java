package com.atguigu.java;

import org.junit.Test;

import java.util.Random;

/**
 * 通过反射创建对应的运行时的类对象
 */
public class NewInstanceTest {
     @Test
    public void test() throws IllegalAccessException, InstantiationException {
         Class<Person> personClass = Person.class;
         Person person = personClass.newInstance();
     }
     @Test
    public void test2(){
         for(int i=0;i<10;i++){
           int num = new Random().nextInt(3);
           String classPath = "";
           switch (num){
               case 0:
                   classPath = "java.util.Date";
                   break;
               case 1:
                   classPath = "java.lang.Object";
                   break;
               case 2:
                   classPath = "com.atguigu.java.Person";
                   break;
           }
             try {
                 Object instance = getInstance(classPath);
                 System.out.println(instance);
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }

     }
     public Object getInstance(String classPath) throws Exception{
         Class<?> aClass = Class.forName(classPath);
         Object o = aClass.newInstance();
        return  o;
     }
}

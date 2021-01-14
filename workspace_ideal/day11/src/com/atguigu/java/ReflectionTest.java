package com.atguigu.java;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionTest {
   @Test
   public void test(){
      Person p1 = new Person("Tom",12);
      p1.age = 10;
      System.out.println(p1.toString());
      p1.show();
   }
   @Test
   public void test2() throws Exception{
       Class clazz = Person.class;
       //1.通过反射,创建对象指定的属性,方法
       Constructor cons = clazz.getConstructor(String.class, int.class);
       Object obj = cons.newInstance("Tom", 12);
       Person p = (Person) obj;
       System.out.println(p.toString());
       //2.通过反射,调用对象的指定属性,方法
       //调用属性
       Field age = clazz.getDeclaredField("age");
       age.set(p,10);
       System.out.println(p.toString());
       //调用方法
       Method show = clazz.getDeclaredMethod("show");
       show.invoke(p);
       System.out.println("***************************************************");
       //通过反射调用Pertson类的私有的结构,比如:私有构造器,方法,属性
       Constructor cons2 = clazz.getDeclaredConstructor(String.class);
       cons2.setAccessible(true);
       Object obj2 = cons2.newInstance("张三");
       Person p2 = (Person)obj2;
       System.out.println(p2);
       //改动私有的属性
       Field name = clazz.getDeclaredField("name");
       name.setAccessible(true);
       name.set(p2,"aa");
       System.out.println(p2);
       //改动私有的方法
       Method showNation = clazz.getDeclaredMethod("showNation", String.class);
       showNation.setAccessible(true);
       Object zhongguo = showNation.invoke(p2, "中国");
       System.out.println(zhongguo);
   }
   public void test3() throws ClassNotFoundException {
       Class clazs1 = Person.class;
       Person person = new Person();
       Class clasz2 = person.getClass();
       Class clazs3 = Class.forName("com.atguigu.java.Person");
   }
   @Test
   public void test4() throws IOException {
       Properties properties = new Properties();
//       FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
//       properties.load(fileInputStream);

       ClassLoader classLoader = ReflectionTest.class.getClassLoader();
       InputStream resourceAsStream = classLoader.getResourceAsStream("jdb1.properties");
       properties.load(resourceAsStream);

       String name = properties.getProperty("name");
       String passward = properties.getProperty("passward");
       System.out.println("name==" + name +"," + "passward==" + passward);
   }
}

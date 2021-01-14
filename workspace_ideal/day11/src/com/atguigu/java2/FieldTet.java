package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldTet {
    @Test
    public void test(){
        Class<Person> personClass = Person.class;

        //获取person类中所有public的属性
        Field[] fields = personClass.getFields();
       for(Field f : fields){
           System.out.println(f);
       }
        System.out.println();
       //获取去当前类所有的属性(公有和私有)
        Field[] declaredFields = personClass.getDeclaredFields();
        for(Field fields1 : declaredFields){
            System.out.println(fields1);
        }
    }
    @Test
    public void test2(){
        Class<Person> personClass2 = Person.class;

        Field[] declaredFields2 = personClass2.getDeclaredFields();

        for(Field t : declaredFields2){
            int modifiers = t.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            Class<?> type = t.getType();
            System.out.print(type.getName() + "\t");

            String name = t.getName();
            System.out.print(name);

            System.out.println();



        }

    }
}

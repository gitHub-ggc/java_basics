package com.atguigu.ggc;

import java.io.Serializable;
import java.util.Objects;

/**
 *person需要满足如下需求
 * 1.实现接口:Serializable
 * 2.serialVersionUID
 * 3.当前Person类需要实现serialVersionUID接口之外,还必须保证其内部所有属性必须是是可序列化的(默认情况下,基本数据类型
 *   可序列化)
 * 4.ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 */
public class Person implements Serializable{
    public static final long serialVersionUID = 475463534532L;
    private String name;
    private  int age;

    public Person() {
    }

    public Person(String name, int age) {
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
}

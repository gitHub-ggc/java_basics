package com.atguigu.java.java3;

import java.util.Objects;

public class Employee {
    private String name;
    private int age;
    private double price;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Employee() {
    }

    public Employee(String name, int age, double price) {
        this.name = name;
        this.age = age;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Double.compare(employee.price, price) == 0 &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age, price);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", price=" + price +
                '}';
    }
}

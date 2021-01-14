package com.atguigu.ggc;

public class dome6 {
    private String name;
    private int age;

    public dome6() {
    }

    public dome6(String name, int age) {
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
   public void walk(){
       System.out.println("人走路");
   }
   public void eat(){
       System.out.println("人吃饭");
   }
}
interface info{
    void show();
}
 class Student extends dome6 implements info{
     @Override
     public void walk() {
         System.out.println("学生走路");
     }

     @Override
     public void eat() {
         System.out.println("学生吃饭");
     }

     @Override
     public void show() {

     }
 }


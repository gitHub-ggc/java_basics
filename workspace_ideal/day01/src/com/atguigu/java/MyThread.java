package com.atguigu.java;

public class MyThread {
    public static void main(String[] args) {
        ThreadTest t1 = new ThreadTest();
       t1.start();
        for(int i=0;i<100;i++){
            if(i % 2 ==0){
                System.out.println(i + "111");
            }
        }
    }
}
class ThreadTest extends Thread{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println(i);
        }
    }
}



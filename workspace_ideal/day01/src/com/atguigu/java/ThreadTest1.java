package com.atguigu.java;


class MThread implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
public class ThreadTest1 {
    public static void main(String[] args) {
        MThread p1 = new MThread();
        Thread t1 = new Thread(p1);
        t1.start();
        Thread t2 = new Thread(p1);
        t2.start();
    }
}

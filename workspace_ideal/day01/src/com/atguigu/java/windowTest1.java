package com.atguigu.java;

class window1 implements Runnable{
    private int ticket = 100;

    @Override
    public void run() {
        while(true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + ":卖票,票号为" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}
public class windowTest1  {
    public static void main(String[] args) {
        window1 p1 = new window1();
        Thread t1 = new Thread(p1);
        t1.start();
        Thread t2 = new Thread(p1);
        t2.start();
        Thread t3 = new Thread(p1);
        t3.start();

    }
}

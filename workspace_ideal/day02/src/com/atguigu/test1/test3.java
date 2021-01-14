package com.atguigu.test1;

public class test3 {
    public static void main(String[] args) {
        window12 p1 = new window12();
        Thread t1 = new Thread(p1);
        t1.start();
        Thread t2 = new Thread(p1);
        t2.start();
        Thread t3 = new Thread(p1);
        t3.start();
    }
}
class window12 implements Runnable{
    private int ticket = 100;

    @Override
    public void run() {
        while(true) {
               show();
        }
    }
    public synchronized void show(){
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票,票号为" + ticket);
            ticket--;
        }

    }
}

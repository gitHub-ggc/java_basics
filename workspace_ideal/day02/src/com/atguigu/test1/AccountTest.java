package com.atguigu.test1;


import java.util.concurrent.locks.ReentrantLock;

public class AccountTest {
    public static void main(String[] args) {
        Banks p1 = new Banks();
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p1);

        t1.setName("客户一");
        t2.setName("客户二");

        t1.start();
        t2.start();
    }
}

class Banks implements Runnable{
    private int money = 0;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){

           try {
               lock.lock();
               try {
                   Thread.currentThread().sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               if(money < 10000){
                   money += 1000;
                   System.out.println(Thread.currentThread().getName() + "存钱 , 总账户余额为:" + money);
               }else{
                   break;
               }
           }finally {
               lock.unlock();
           }
        }

    }
}
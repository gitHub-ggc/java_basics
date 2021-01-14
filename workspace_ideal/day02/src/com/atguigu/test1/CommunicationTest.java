package com.atguigu.test1;
/**
 * 线程通信的例子:使用两个线程打印 1-100 线程1,线程2,交替打印
 *
 * 涉及到的三个方法:
 * wait():一旦执行此方法,当前线程就进入阻塞状态,并释放同步监视器.
 * notify():一旦执行此方法,就会唤醒被wait的一个线程.如果有多个线程被wait,唤醒优先级高的
 * notifyAll():一旦执行此方法,就会唤醒所有被wait的线程
 *
 * 说明:
 * 1.wait(),notify(),notifyAll()三个方法必须使用在同步代码块或者同步方法中
 * 2.wait(),notify(),notifyAll()三个方法的调用者必须是同步代码块或同步方法中的同步监视器
 *
 * 面试题:
 *  sleep()和wait()方法的异同
 *  1.相同点:一旦执行此方法,都可以使当前线程进入阻塞状态
 *  2.不同点:(1)两个方法声明的位置不同,Thread类中声明sleep(),Object类中声明wait()
 *           (2)调用的要求不同:sleep()可以在任何需要的场景下调用,wait必须在同步代码中调用
 *           (3)关于是否释放同步监视器的情况:如果两个方法都使用在同步代码块中,sleep()会不会释放同步监视器,wait()能
 *              释放同步监视器
 */

import java.util.concurrent.locks.ReentrantLock;

class Number implements Runnable{
    private int number = 1;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
           synchronized (this){
               notify();
               if(number <= 100){
                   try {
                       Thread.currentThread().sleep(100);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println(Thread.currentThread().getName() + ":" + number);
                   number++;
                   try {
                       wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }else{
                   break;
               }
           }
        }
    }
}
public class CommunicationTest {
    public static void main(String[] args) {
        Number P1 = new Number();
        Thread t1 = new Thread(P1);
        Thread t2 = new Thread(P1);

        t1.setName("甲");
        t2.setName("乙");

        t1.start();
        t2.start();
    }


}

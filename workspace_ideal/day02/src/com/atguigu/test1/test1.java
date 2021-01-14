package com.atguigu.test1;

/**
 * 1.卖票出现重票,错票问题
 * 2.问题出现的原因:当某个线程操作车票过程中,尚未操作完成时,其它线程也进来了
 * 3.如何解决:当一个线程在操作ticket的时候,其它线程不能参与进来,直到线程a操作完ticket
 *            线程才可以操作ticket,
 *  4.解决线程安全问题
 *     synchronized(同步监视器){
 *         //需要被同步的代码
 *     }
 *     说明:1.操作共享数据的代码,即为需要被同步的代码
 *          2.共享数据:多个线程共同操作的变量,比如:ticket就是共享数据
 *          3.同步监视器:俗称 锁,任何一个类的对象,都可以充当锁
 *               要求:多个线程必须要共同用同一把锁
 *         
 */
public class test1 {
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
class window1 implements Runnable{
    private int ticket = 100;
    Object obj = new Object();

    @Override
    public void run() {
        while(true) {
            synchronized (obj){
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票,票号为" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}



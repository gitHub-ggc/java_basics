package com.atguigu.test1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三
 *
 * 1.面试题:synchronized 和 Lock的异同
 *    同:都可以解决线程安全问题
 *    异:synchronized机制在执行完相应的同步代码以后,自动释放同步监视器
 *       Lock需要手动的启动同步(lock),同时结束也需要手动的实现(unlock)
 */
class window implements Runnable{
    private int ticket = 100;
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try {
                lock.lock();
                if(ticket > 0){
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖票,票号为:" + ticket);
                    ticket--;
                }else{
                    break;
                }
            }finally {
                lock.unlock();
            }
        }
    }
}
public class LockTest {
    public static void main(String[] args) {
        window p1 = new window();
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p1);
        Thread t3 = new Thread(p1);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}

package com.atguigu.ggc;

/**
 * 1.画图说明线程的生命周期,以及各个状态切换使用到的方法等
 *    创建(new)  启动(start)           运行     结束
 *                             阻塞
 * 2.同步代码块中涉及到同步监视器和共享数据,谈谈你对同步监视器和共享数据的理解,以及注意点
 *     synchronized(同步监视器),它是一个对象,只能有一把锁.
 *     共享数据:多个线程共享的数据就叫共享数据
 *     同步监视器里面的就是操作共享数据的代码
 * 3.sleep()和wait()的区别
 *    >1.sleep和wait都可以对线程进行阻塞
 *    >区别 : 1.声明的位置不一样,sleep是在Thread中声明,wait是在object
 *            2.使用范围不一样:sleep哪里需要哪里使用,wait只能在同步代码器中
 *            3.sleep仅仅是阻塞,而wait除了阻塞还能释放同步监视器
 * 4.写一个线程安全的懒汉式
 *
 * 5.创建多个线程有哪几种方式
 *   >4种:extends Thread,impelements Runnable,impelements callable,线程池
 *
 *   懒汉式线程安全代码编写
 */
class peson{
    private static peson a = null;
    public static synchronized peson getPeson(){
        if(a == null){
            peson a = new peson();
        }
        return a;
    }
}
public class test1 {
    public static void main(String[] args) {

    }
}

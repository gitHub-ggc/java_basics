package com.atguigu.test1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 1.方法4:利用线程池创建多线程
 * 2.好处: 提高响应速度(减少创建新线程的时间)
 *         降低资源消耗(重复利用线程池中线程,不需要每次创建)
 *         便于线程管理
 *         corePoolSize:核心池的大小
 *         maximumPoolSize:最大线程数
 *         keepAliveTime:线程没有任务时最多保持多长时间停止
 *
 */
class NumberThread implements  Runnable{
    @Override
    public void run() {
        for(int i = 0;i <= 100;i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
class NumberThread1 implements  Runnable{
    @Override
    public void run() {
        for(int i = 0;i <= 100;i++){
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
public class ThreadPool  {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
//        设置线程池的属性
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime();
        //2.执行指定线程的操作,需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new NumberThread());//适用于Runnable
        service.execute(new NumberThread1());//适用于Runnable
//        service.submit();//适用于Callable
        service.shutdown();//回收线程池
    }

}

package com.atguigu.java;

/**
 * 1.谈谈你对程序,进程,线程的理解
 * 程序:为完成任务一群指令的集合
 * 进程:正在运行的一个程序
 * 线程:是一个程序的执行路径,每个线程拥有自己独立的栈,程序计数器,多个线程共享一个进程中的结构:方法区,堆
 * 2.代码完成继承Thread的方式创建分线程,并遍历100以内的自然数
 *
 * 3.代码实现Runnable接口的方法创建分进程,并遍历100以内的自然数
 *
 * 4.对比两种c创建方式
 *1.runnable共享数据
 * 5.说说你对IDEA中Project和Module的理解
 * (1)
 * 二.线程的生命周期
 * 新建:new Thread()
 * 就绪:调用start方法
 * 运行:执行run方法
 * 阻塞:sleep(long time),join(),等待同步锁,wait(),suspend()
 * 死亡:执行完run或调用线程的stop()方法,出现Error/Exception且没有处理
 * */
public class day17 {
}

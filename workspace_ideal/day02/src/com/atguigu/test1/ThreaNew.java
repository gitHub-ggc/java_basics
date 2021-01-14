package com.atguigu.test1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三:实现callable接口   ---JDK5.0新增
 *   1.callable中的call方法可以有返回值
 *   2.可以抛出异常,被外界获取
 *   3.支持泛型
 */
//1.创建一个实现callable的实现类
class NumThread implements Callable{
    //2.实现call方法,将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for(int i = 1;i<=100;i++){
            if(i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
public class ThreaNew {
    public static void main(String[] args) {
        //3.创建callable接口实现类的对象
       NumThread numThread = new NumThread();
       //4将此callable接口实现的对象传提到futuretask的参数中,创建futuretask对象
        FutureTask futureTask = new FutureTask(numThread);
        //5.启动线程
        new Thread(futureTask).start();
        try {
            //get()返回值即为FutureTask构造器参数callable实现类重写的call的返回值
            Object sum = futureTask.get();
            System.out.println("总和为"+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

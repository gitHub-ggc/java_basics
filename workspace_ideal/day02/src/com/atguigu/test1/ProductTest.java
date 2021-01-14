package com.atguigu.test1;

class Clerk{
    private  int productNum = 0;
    public synchronized void produceProduce() {//生产产品
       if(productNum < 20){
           productNum++;
           System.out.println(Thread.currentThread().getName() + "开始生产第" + productNum + "个");
           notify();
       }else{
           try {
               wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }

    public synchronized void consumeProduce() {//消费产品
        if(productNum > 0){
            System.out.println(Thread.currentThread().getName() + "开始消费第" + productNum + "个");
            productNum--;
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Producer extends Thread{
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+"生产产品中......");
        while (true){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduce();
        }
    }
}
class custom extends Thread{
    private Clerk clerk;

    public custom(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+"消费者消费中......");
        while (true){
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduce();
        }
    }
}
public class ProductTest {
    public static void main(String[] args) {
        Clerk p1 = new Clerk();
        Producer t1 = new Producer(p1);
        custom t2 = new custom(p1);
        custom t3 = new custom(p1);

        t1.setName("消费者");
        t2.setName("生产者");
        t3.setName("生产者2");

        t1.start();
        t2.start();
        t3.start();
    }
}

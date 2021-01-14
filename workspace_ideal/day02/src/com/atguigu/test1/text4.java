package com.atguigu.test1;

public class text4 {
    public static void main(String[] args) {
        Window4 p1 = new Window4();
        Window4 p2 = new Window4();
        Window4 p3 = new Window4();

        p1.setName("窗口1");
        p2.setName("窗口2");
        p3.setName("窗口3");

        p1.start();
        p2.start();
        p3.start();
    }
}

class Window4 extends Thread{
    private static int ticket = 100;
    @Override
    public void run() {
        while(true){
                show();
        }
    }
    public static synchronized void show(){
        if(ticket >0){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "买票,票号为:" + ticket);
            ticket--;
        }
    }

}

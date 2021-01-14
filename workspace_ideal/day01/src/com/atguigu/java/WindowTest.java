package com.atguigu.java;

public class WindowTest {
    public static void main(String[] args) {
        Window p1 = new Window();
        Window p2 = new Window();
        Window p3 = new Window();

        p1.setName("窗口1");
        p2.setName("窗口2");
        p3.setName("窗口3");

        p1.start();
        p2.start();
        p3.start();
    }

}
class Window extends Thread{
    private static int ticket = 100;

    @Override
    public void run() {
        while(true){
          if(ticket >0){
              System.out.println(getName() + "买票,票号为:" + ticket);
              ticket--;
          }else{
              break;
          }
        }
    }

}
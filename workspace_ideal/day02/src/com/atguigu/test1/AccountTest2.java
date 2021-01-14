package com.atguigu.test1;

public class AccountTest2 {
    public static void main(String[] args) {
        bank s1 = new bank();
        Custom p1 = new Custom(s1);
        Custom p2 = new Custom(s1);

        p1.start();
        p2.start();
    }
}
class Custom extends Thread{
    private bank  banks;

    public Custom(bank banks) {
        this.banks = banks;
    }

    @Override
    public void run() {
        for(int i=0;i<3;i++){
            banks.deposit(100);
        }
    }
}
class bank{
   private int money = 0;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    public synchronized   void deposit(double amt){
        if(amt > 0){
            money += amt;
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "存钱 , 总账户余额为:" + money );
        }
    }
}

package com.atguigu.test1;

public class BankTest {

}

class Bank{
    private static Bank datea = null;
    public static synchronized  Bank show(){
        if(datea == null){
            Bank datea = new Bank();
        }
        return datea;
    }
}

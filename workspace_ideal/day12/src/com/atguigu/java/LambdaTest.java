package com.atguigu.java;

import org.junit.Test;

public class LambdaTest {
    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };
        r1.run();

        Runnable r2= () ->System.out.println("我爱北京天安门");
        r2.run();
    }
}

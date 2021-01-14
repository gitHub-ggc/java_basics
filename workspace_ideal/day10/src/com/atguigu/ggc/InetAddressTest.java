package com.atguigu.ggc;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    @Test
     public void test() throws UnknownHostException {
        InetAddress iar = InetAddress.getByName("www.baidu.com");
        System.out.println(iar);
    }


}

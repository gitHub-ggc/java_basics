package com.FANXING.ggc;

import java.util.List;

public class ext1Test {
    public static void main(String[] args) {
        ext1<User> ext1 = new ext1();
        ext1.save("1",new User(1001,22,"zhangsan"));
        ext1.save("2",new User(1002,23,"lisi"));
        ext1.save("3",new User(1003,24,"wangwu"));
        ext1.save("4",new User(1004,25,"liuliu"));
        List<User> list = ext1.list();
//        System.out.println(list);
        list.forEach(System.out::println);
    }
}

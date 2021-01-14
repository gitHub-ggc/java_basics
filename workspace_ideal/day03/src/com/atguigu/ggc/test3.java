package com.atguigu.ggc;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test3 {
//    字符串"2020-09-08"转化为java.sql.Date
    @Test
    public void tests() throws ParseException {
        SimpleDateFormat date = new SimpleDateFormat("YYYY-MM-dd");
        Date ss = date.parse("2020-11-24");
        java.sql.Date birthDate = new java.sql.Date(ss.getTime());
        System.out.println(birthDate);
    }
}

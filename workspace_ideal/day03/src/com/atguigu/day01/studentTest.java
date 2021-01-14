package com.atguigu.day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class studentTest{
    public static void main(String[] args) {
        List p = new ArrayList();
        p.add(new students("张三",95));
        p.add(new students("李四",88));
        p.add(new students("王五",99));
        p.add(new students("老六",45));
        p.add(new students("刘七",66));
//        for (Object o : p) {
//            System.out.println(o);
//        }
        Arrays.sort(new List[]{p});
        System.out.println(p);

    }
}
class students implements Comparable{
    private String stu;
    private int sco;

    public students() {
    }

    public students(String stu, int sco) {
        this.stu = stu;
        this.sco = sco;
    }

    public String getStu() {
        return stu;
    }

    public void setStu(String stu) {
        this.stu = stu;
    }

    public int getSco() {
        return sco;
    }

    public void setSco(int sco) {
        this.sco = sco;
    }

    @Override
    public String toString() {
        return "students{" +
                "stu='" + stu + '\'' +
                ", sco=" + sco +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof students){
           students t1 = (students)o;
          if( this.sco > t1.sco){
             return 1;
          }else if(this.sco < t1.sco){
            return -1;
          }else{
             return this.stu.compareTo(t1.stu);
          }
        }
        throw new RuntimeException("传入的数据类型不一致");
    }
}

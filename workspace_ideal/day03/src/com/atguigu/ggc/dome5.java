package com.atguigu.ggc;

/***
 * 使用Enum枚举类列子
 */
public class dome5 {
    public static void main(String[] args) {
        Status spring = Status.SPRING;
        System.out.println(spring);

    }
}
class Status{
    private  final String statusName;
    private  final String StatusDec;

    public String getStatusName() {
        return statusName;
    }

    public String getStatusDec() {
        return StatusDec;
    }
//    私有化类的构造器,并给对象属性赋值
    private   Status(String statusName, String StatusDec) {
        this.statusName = statusName;
        this.StatusDec = StatusDec;
    }
    public static final Status SPRING = new Status("春天","春暖花开");
    public static final Status SUMMER = new Status("冬天","冬天来了,春天还会远吗?");
    @Override
    public String toString() {
        return "Status{" +
                "statusName='" + statusName + '\'' +
                ", StatusDec='" + StatusDec + '\'' +
                '}';
    }

}

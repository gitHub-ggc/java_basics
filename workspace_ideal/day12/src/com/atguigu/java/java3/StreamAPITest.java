package com.atguigu.java.java3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1.Stream关注的是对数据的运算,与CPU打交道
 *   集合关注的是数据的存储,与内存打交道
 *
 * 2.Stream 自己不会存储元素
 *   Stream 不会改变源对象,相反,他们会返回一个持有结果的新Stream
 *   Stream 操作时延迟执行的,这意味着他们会等到需要结果的时候才执行
 *
 * 3.Steam 执行流程
 *    (1)Stream的实例化
 *    (2)一系列的中间操作(过滤,映射,...)
 *    (3)终止操作
 *
 * 4.说明:
 *   1.一个中间操作链,对数据源的数据进行处理
 *   2.一旦执行终止操作,就执行中间操作连,并产生结果,之后不再被使用
 */
public class StreamAPITest {
    @Test
    public void test(){
        int[] arr = {1, 2, 3, 4, 5, 6};
        IntStream stream = Arrays.stream(arr);
    }
    @Test
    public void test2(){
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("张三",18,2000));
        employees.add(new Employee("李四",78,4000));
        employees.add(new Employee("王五",28,3000));
        employees.add(new Employee("刘流",18,7000));
        employees.add(new Employee("张三",19,5000));

        employees.stream().sorted((e1,e2) -> {
           int ageValue = Integer.compare(e1.getAge(),e2.getAge());
           if(ageValue != 0){
               return ageValue;
           }else{
               return -Double.compare(e1.getPrice(),e2.getPrice());
           }
        }).forEach(System.out::println);
        System.out.println("2****************************************");
        boolean b = employees.stream().allMatch(e1 -> e1.getAge() > 15);
        System.out.println(b);
        System.out.println("3********************************************");
        Stream<Integer> integerStream = employees.stream().map(e1 -> e1.getAge());
//        Optional<Integer> max = integerStream.max(Double::compare);
        integerStream.max((e1,e2) -> {
            return e1.compareTo(e2);
        });
//        System.out.println(max);
    }
    @Test
    public void test3(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = integers.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
    }
}

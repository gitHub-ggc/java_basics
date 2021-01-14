package com.atguigu;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之二:转换流的使用
 *  1.转换流:属于字符流
 *  InputStreamReader:将一个字节的输入流转换为字符的输入流
 *  OutputStreamReader:讲一个字符的输出流转换为字节的输出流
 *  2.作用:提供字节流与字符流之间的转换
 *  3.解码:字节,字节数组  -----> 字符数组,字符串
 *    编码:字符数组,字符串 ------>字节,字节数组
 *  4.字符集
 *
 */
public class InputStreamReaderTest {
    @Test
    public void test(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("hellow.txt");

            InputStreamReader isr = new InputStreamReader(fis);
            char[] ch = new char[5];
            int end;
            while ((end=isr.read(ch)) != -1){
                 String str = new String(ch,0,end);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    @Test
    public void test1() throws IOException {
        FileInputStream fis = new FileInputStream("hellow.txt");
        FileOutputStream fos = new FileOutputStream("hellowww");
        InputStreamReader isr = new InputStreamReader(fis,"utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");
        char[] ch = new char[5];
        int end;
        while((end = isr.read(ch)) != -1){
            osw.write(ch,0,end);
        }
        isr.close();
        osw.close();
    }
}

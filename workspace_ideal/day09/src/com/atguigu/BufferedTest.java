package com.atguigu;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 1.缓冲流(处理流)
 *BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 * 2.作用:提供流的读取,写人的速度
 */
public class BufferedTest {
    @Test
    //图片的加密
    public void test(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("4.jpg");
            fos = new FileOutputStream("7.jpg");
            byte[] data = new byte[20];
            int end;
            while ((end = fis.read(data)) != -1){
                for(int i=0;i<end;i++){
                   data[i] =  (byte)(data[i] ^ 5);
                }
               fos.write(data,0,end);
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
           if(fos != null){
               try {
                   fos.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }

        }

    }
    @Test
    //图片解密
    public void test1(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("7.jpg");
            fos = new FileOutputStream("8.jpg");
            byte[] data = new byte[20];
            int end;
            while ((end = fis.read(data)) != -1){
                for(int i=0;i<end;i++){
                    data[i] =  (byte)(data[i] ^ 5);
                }
                fos.write(data,0,end);
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
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
    @Test
    public void test2() throws IOException {
        FileReader fr = new FileReader("hellow.txt");
        HashMap<Character, Integer> map = new HashMap<>();
        int end;
        while ((end = fr.read()) != -1){
           char ch = (char)end;
           if(map.get(ch) ==null){
               map.put(ch,1);
           }else{
               map.put(ch,map.get(ch)+1);
           }
        }
       BufferedWriter bw = new BufferedWriter(new FileWriter("hellow66.txt"));
      Set<Map.Entry<Character,Integer>> entrySet = map.entrySet();
      for(Map.Entry<Character,Integer> entry : entrySet){
          bw.write(entry.getKey() + "=" + entry.getValue() + "\n");
//          switch (entry.getKey()){
//              case ' ':
//                  bw.write("空格=" + entry.getValue());
//                  break;
//              case '\t':
//                  bw.write("tab=" + entry.getValue());
//                  break;
//              default:
//                  bw.write(entry.getKey() + "=" + entry.getValue());
//
//          }
      }
      fr.close();
      bw.close();
    }
}

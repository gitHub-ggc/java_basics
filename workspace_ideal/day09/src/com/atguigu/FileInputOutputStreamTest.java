package com.atguigu;

import org.junit.Test;

import java.io.*;

public class FileInputOutputStreamTest {
    @Test
    public void test() throws IOException {
        FileInputStream fis = null;
        try {
            File file = new File("hellow.txt");

            fis = new FileInputStream(file);

            byte[] data = new byte[5];
            int len;
            while ((len = fis.read(data)) != -1){
               String str = new String(data,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                fis.close();
            }
        }
    }
    @Test
    public void test2(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File file1 = new File("4.jpg");
            File file2 = new File("5.jpg");

            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);

            byte[] data = new byte[5];
            int end;

            while((end = fis.read(data)) != -1){
    //           String str = new String(data,0,end);
               fos.write(data);
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

    public void test3(String srcPath2,String desPath2){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File file1 = new File(srcPath2);
            File file2 = new File(desPath2);

            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);

            byte[] data = new byte[1024];
            int end;

            while((end = fis.read(data)) != -1){
                //           String str = new String(data,0,end);
                fos.write(data);
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
    public void test4(){
        String srcPath1 = "5.jpg";
        String desPath1 = "6.jpg";
        test3(srcPath1,desPath1);
    }
}

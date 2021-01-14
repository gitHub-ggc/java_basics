package com.atguigu;

import org.junit.Test;

import java.io.*;

/**
 * 一.流的分类
 * 1.操作的数据单位:字节流,字符流
 * 2.按数据的流向:输出流,输入流
 * 3.流的角色:节点流,处理流
 * 二.流的体系结构
 * 1抽象基类:InputStream OutputStream Reader Writer
 * 2节点流(文件流):FileInputStream FileOutputStream FileReader FileWriter
 * 3缓冲流(处理流的一种):BufferedInputStream BufferedOutputStream BufferedReader BufferedWriter
 */
public class FileReaderWriterTest {
    public static void main(String[] args) {

    }
    @Test
    public void test(){
        FileReader fr = null;
        try {
            File file = new File("hellow.txt");
            fr = new FileReader(file);
            int num ;
            while((num = fr.read()) != -1){
                System.out.print((char) num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fr != null)
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
  @Test
    public void test2() {
      FileReader fileReader = null;
      try {
          File file = new File("hellow.txt");
          fileReader = new FileReader(file);
          char[] data = new char[5];
          int num;
          while((num = fileReader.read(data)) != -1){
             for(int i =0;i<num;i++){
                 System.out.print(data[i]);
             }
          }
      } catch (IOException e) {
          e.printStackTrace();
      } finally {
          try {
              if(fileReader != null)
                  fileReader.close();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
  }
  @Test
    public void test3(){
      FileWriter fw = null;
      try {
          File file = new File("hellow2");
          fw = new FileWriter(file,true);
          fw.write("I hava a dream \n");
          fw.write("you neede to a dream");
      } catch (IOException e) {
          e.printStackTrace();
      } finally {
          if(fw != null) {
              try {
                  fw.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }
  }
  @Test
    public void test4(){
      FileReader fr = null;
      FileWriter fw = null;
      try {
          File read = new File("hellow.txt");
          File write = new File("hellow.txt");

          fr = new FileReader(read);
          fw = new FileWriter(write,true);

          char[] data = new char[5];
          int end;
          while ((end = fr.read(data)) != -1){
              fw.write(data,0,end);
          }
      } catch (IOException e) {
          e.printStackTrace();
      } finally {
          if(fr != null) {
              try {
                  fr.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
          if(fw != null) {
              try {
                  fw.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }

  }
}

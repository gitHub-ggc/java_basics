package com.atguigu.ggc;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest2 {
    @Test
    public void client() throws IOException {
        InetAddress byName = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(byName, 8887);
        OutputStream outputStream = socket.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream(new File("ceshi.jpg"));
       int end;
       byte[] data = new byte[1024];
       while ((end = fileInputStream.read(data)) != -1){
          outputStream.write(data,0,end);
       }
       fileInputStream.close();
       outputStream.close();
       socket.close();
    }
    @Test
    public void serve() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8887);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("ceshi1.jpg");
        int end;
        byte[] data = new byte[1024];
        while ((end = inputStream.read(data)) != -1){
            fileOutputStream.write(data,0,end);
        }
        fileOutputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
    }
}

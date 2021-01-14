package com.atguigu.ggc;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest3 {
    @Test
    public void client() throws IOException {
        InetAddress byName = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(byName, 8886);
        OutputStream outputStream = socket.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream(new File("ceshi1.jpg"));
        int end;
        byte[] data = new byte[1024];
        while ((end = fileInputStream.read(data)) != -1){
            outputStream.write(data,0,end);
        }

        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int end2;
        byte[] data2 = new byte[1024];
        while ((end2 = inputStream.read(data)) != -1){
          baos.write(data2,0,end);
        }
        System.out.println(baos.toString());

        fileInputStream.close();
        outputStream.close();
        socket.close();
        inputStream.close();
        baos.close();
    }
    @Test
    public void serve() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8886);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("ceshi2.jpg");
        int end;
        byte[] data = new byte[1024];
        while ((end = inputStream.read(data)) != -1){
            fileOutputStream.write(data,0,end);
        }

        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("图我已经收到了,很漂亮!".getBytes());


        fileOutputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
        outputStream.close();
    }
}

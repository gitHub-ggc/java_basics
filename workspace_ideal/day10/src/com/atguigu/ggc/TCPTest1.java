package com.atguigu.ggc;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest1 {
    @Test
    public void client(){
        Socket  socket = null;
        OutputStream os = null;
        try {
            InetAddress id = InetAddress.getByName("127.0.0.1");
            socket = new Socket(id,8888);
            os = socket.getOutputStream();
            os.write("你好,我是客户端的mm".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        }
    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        Socket accept = ss.accept();
        InputStream is = accept.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[5];
        int len;
        while ((len = is.read(buffer)) != -1){
            baos.write(buffer,0,len);
        }
        System.out.println(baos.toString());
        System.out.println("收到了来自于"+accept.getInetAddress().getHostAddress()+"的数据");

        baos.close();
        is.close();
        accept.close();
        ss.close();
    }
    @Test
    public void client2() throws IOException {
        InetAddress byName = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(byName,8889);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("客户端发来的数据了".getBytes());
        socket.close();
        outputStream.close();
    }
    @Test
    public void serve2() throws IOException {
        ServerSocket serverSocket =  new ServerSocket(8889);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int end ;
        byte[] data = new byte[5];
        while ((end=inputStream.read(data)) != -1){
            byteArrayOutputStream.write(data,0,end);
        }
        System.out.println(byteArrayOutputStream.toString());
        System.out.println("客户端的IP地址为"+accept.getInetAddress().getHostAddress());
        byteArrayOutputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
    }
}

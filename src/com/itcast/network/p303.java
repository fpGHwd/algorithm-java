package com.itcast.network;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


class Client{
    public static void main(String[] args) throws IOException{
        Socket s = new Socket("localhost", 10003); // 服务器
        OutputStream out = s.getOutputStream(); // 获取输出流
        out.write("tcp ge men lai le ".getBytes()); // 写数据

        s.close();
    }
}

class Server{
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10003);
        Socket s = ss.accept();

        InputStream in = s.getInputStream(); // net stream

        byte[] buf = new byte[1024];
        int len = in.read(buf);
        System.out.println(s.getRemoteSocketAddress() + ":" + new String(buf, 0 ,len));

        s.close();  // 关闭和服务端的链接
        ss.close(); // 关闭服务器
    }

}


public class p303 {
    // socket socketServer
    // tcp 面向链接，所以connect

    @Test
    public void test(){

    }
}

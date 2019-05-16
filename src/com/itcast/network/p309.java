package com.itcast.network;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ServerDemo{
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10010);

        Socket s = ss.accept();

        System.out.println(s.getInetAddress().getHostAddress()+ ".....connected"); // localhost.....connected

        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
        pw.println("<font color=red size=7>客户端你好</font>");

        s.close();
        ss.close();
    }
}

public class p309 {
    /**
     * 客户端：浏览器(telnet)
     * 自定义服务端
     */

    /**
     * 客户端：浏览器
     * 服务端：Tomcat服务器
     */
}

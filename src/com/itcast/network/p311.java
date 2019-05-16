package com.itcast.network;

import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class ClientP311{
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10011);

        Socket s = ss.accept();

        System.out.println(s.getInetAddress().getHostAddress()+ ".....connected");

        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
        pw.println("<font color=red size=7>客户端你好</font>");

        InputStream in = s.getInputStream();
        byte[] back = new byte[1024];
        int len = in.read(back);
        System.out.println(new String(back,0,len));


        s.close();
        ss.close();
    }
}

class MySHANZHAIFireFox{
    public static void main(String[] args)throws  IOException{
        Socket s = new Socket("45.78.52.19", 8080);
        PrintWriter pw = new PrintWriter( s. getOutputStream(), true);

        pw.println("GET / HTTP/1.1");
        pw.println("Host: localhost:10011");
        pw.println("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        pw.println("Accept-Encoding: gzip, deflate, br");
        pw.println("Accept-Language: en-US,en;q=0.9,zh-CN;q=0.8,zh;q=0.7,el-GR;q=0.6,el;q=0.5");
        pw.println("Connection: keep-alive");
        pw.println();

        BufferedReader bufr = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line;
        while((line = bufr.readLine())!=null){
            System.out.println(line);
        }
        s.close();


        /**
         * HTTP/1.1 200
         * Content-Type: text/html;charset=UTF-8
         * Transfer-Encoding: chunked
         * Date: Thu, 16 May 2019 08:44:06 GMT
         *
         * 2000
         *
         *
         *
         * <!DOCTYPE html>
         * <html lang="en">
         *     <head>
         */
    }
}

public class p311 {
    /**
     * 自定义浏览器
     * Tomcat服务端
     *
     * 要多山寨就有多山寨
     */
}


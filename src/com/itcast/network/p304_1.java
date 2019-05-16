package com.itcast.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class TcpClient2 {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 10005);
        BufferedReader bufr =
                new BufferedReader(new InputStreamReader(System.in)); // 源
        // 目的
//        BufferedWriter bufw =
//                new BufferedWriter(new OutputStreamWriter(s.getOutputStream())); // 转换流，文本采用字符流
        PrintWriter pw = new PrintWriter(s.getOutputStream(),true);

        BufferedReader bufr1 =
                new BufferedReader(new InputStreamReader(s.getInputStream())); // 后续文本，不是键盘

        String line = null;
        while ((line = bufr.readLine()) != null) {
            if("over".equals(line))break;
//            bufw.write(line);
//            bufw.newLine();  // 发送到服务器的readLine方法接受
//            bufw.flush(); // 缓冲区必须要的操作
            pw.println(line);
            String in = bufr1.readLine();
            System.out.println("server: " + in);
        }
        s.close();

    }
}

class TcpServer2 {
    public static void main(String[] args) throws  IOException{
        ServerSocket  ss =new ServerSocket(10005);
        Socket s = ss.accept();

        System.out.println(s.getInetAddress().getHostAddress() + "....connected");

        BufferedReader bufr =
                new BufferedReader(new InputStreamReader(s.getInputStream()));
//        BufferedWriter bufw =
//                new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        PrintWriter pw = new PrintWriter(s.getOutputStream(),true); // 自动刷新，有效的自动刷新

        String str;
        while((str = bufr.readLine())!=null){ // 需要换行符才可以
            System.out.println(s.getInetAddress().getHostName() + ": " + str);
//            bufw.write(str.toUpperCase());
//            bufw.newLine(); // 回车标记，发送给客户端接受
//            bufw.flush();
            pw.println(str.toUpperCase());
        }
        s.close(); // 客户端s.close()时，会发送结束标记-1，所以这边readline会接受到-1然后停止。
        ss.close();
    }
}


/**
 * print writer 目的流：字符流和字节流+自动刷新。
 * 简化带吗
 */

public class p304_1 {
    //
}

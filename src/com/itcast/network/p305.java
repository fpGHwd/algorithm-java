package com.itcast.network;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class TextClient2{
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 10005);

        BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream("res/p305-copy.file")));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true); // true
        // 先发送名字

        String line;
        while((line = bufr.readLine())!=null){
            pw.println(line); // 不是write方法
        }
//        pw.println("over");

        s.shutdownOutput(); // 流中加入结束标记 // 标准方法。。。。 todo: 上传图片，不能用字符流了。

        bufr.close(); // 文件读完了但是没有发送-1

        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream())); // 接受服务器的消息
        String str = bufIn.readLine();
        System.out.println(str);

        bufIn.close();
        s.close();

    }
}

class TextServer2{
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(10005);
        Socket s = ss.accept();

        System.out.println(s.getInetAddress().getHostName() +"......connected" );
        BufferedReader bufr = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("res/p305-copy-copy.file")),true); // 目的


        String line;
        while((line = bufr.readLine())!= null){ // 接受结束标记
//            if("over".equals(line)) // 文件里面有over的话就会停止。但是有问题
//                break;
            pw.println(line);
        }
        pw.close();


        PrintWriter pw1 = new PrintWriter(s.getOutputStream(),true);
        pw1.println("复制文件成功/上传成功");
        pw1.close();

        s.close();
    }
}

public class p305 {
    // 发送一个文件
}

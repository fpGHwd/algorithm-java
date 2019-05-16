package com.itcast.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class TcpClient1  {
    public static void main(String[] args) throws IOException{
           Socket s = new Socket("localhost", 10004);
           byte[] buf = new byte[1024];

           OutputStream out = s.getOutputStream();
           out.write("服务端你好".getBytes());

           InputStream in = s.getInputStream();
           int len = in.read(buf);
           System.out.println(s.getRemoteSocketAddress() + ":" + new String(buf, 0, len));
           s.close();
    }
}

class TcpServer1{
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10004);
//        Socket s = null;
//        while ((s = ss.accept())!=null){
//
//        }
        Socket s = ss.accept();
        InputStream in = s.getInputStream();
        byte[] buf = new byte[1024];
        int len= in.read(buf);
        System.out.println(s.getRemoteSocketAddress() + ":" + new String(buf, 0,len));
        OutputStream out = s.getOutputStream();
        out.write("哥们收到，你也好".getBytes());

        s.close();
        ss.close();
    }
}

public class p304 {

}

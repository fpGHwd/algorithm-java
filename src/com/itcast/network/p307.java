package com.itcast.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class p307 {
    /**
     * 客户端并发上传图片
     */
}


class PictureClient4 implements Runnable{

    public static void main(String[] args){
        for(int i = 0; i <5; i++){
            new Thread(new PictureClient4()).start();
        }

    }

    public void run(){

        try {
            Socket s = new Socket("localhost", 10006);

            BufferedInputStream bis =
                    new BufferedInputStream(new FileInputStream("res/up-half.png"));
            BufferedOutputStream bos =
                    new BufferedOutputStream(s.getOutputStream());

            byte[] buf = new byte[1024];
            int len;
            while ((len = bis.read(buf)) != -1) {
                bos.write(buf, 0, len);
                bos.flush();
            }
            s.shutdownOutput();  // 发送结束标识符-1

            BufferedReader bufr =
                    new BufferedReader(new InputStreamReader(s.getInputStream()));
            String re = bufr.readLine();  // 接受停止符
            System.out.println(re);

            s.close();
            bis.close();
            bufr.close();

        }catch (Exception e){
            throw new RuntimeException("客户端： 上传失败");
        }

    }
}

class PictureServer4 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10006);
        Socket s;

        while((s=ss.accept())!=null){
            new Thread(new Handle(s)).start();
        }
        s.close();  // 发送停止符
    }
}

class Handle implements Runnable{
    private Socket s;
    Handle(Socket s){
        this.s = s;
    }

    public void run(){
        try {
            System.out.println(s.getInetAddress().getHostName() + ".....connected");

            BufferedInputStream bis =
                    new BufferedInputStream(s.getInputStream());
            BufferedOutputStream bos =
                    new BufferedOutputStream(new FileOutputStream("res/"+Thread.currentThread().getName()+"-up-half-copied-by-network.png"));

            byte[] buf = new byte[1024];
            int len;
            while ((len = bis.read(buf)) != -1) { // 需要停止
                bos.write(buf, 0, len);
                bos.flush();
            }

            PrintWriter pw =
                    new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
            pw.println("服务器端"+ Thread.currentThread().getName() + "成功复制并写入文件");

            pw.close();
            bos.close();
        }catch (Exception e){
            throw new RuntimeException("服务端： 上传失败");
        }
    }

    /**
     * 服务端将每个客户端封装到一个车单独的线程中
     * 只要确认每个客户端要在服务端执行的代码即可。将该代码存入run方法中。
     *
     * 所有的服务器原理都是这样。
     */
}

package com.itcast.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class PictureClient3 {
    public static void main(String[] args) throws IOException {
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

    }
}

class PictureServer3 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10006);
        Socket s = ss.accept();

        System.out.println(s.getInetAddress().getHostName() + ".....connected");

        BufferedInputStream bis =
                new BufferedInputStream(s.getInputStream());
        BufferedOutputStream bos =
                new BufferedOutputStream(new FileOutputStream("res/up-half-copied-by-com.network.png"));

        byte[] buf = new byte[1024];
        int len;
        while ((len = bis.read(buf)) != -1) { // 需要停止
            bos.write(buf, 0, len);
            bos.flush();
        }

        PrintWriter pw =
                new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
        pw.println("成功复制并写入文件");

        pw.close();
        s.close();  // 发送停止符
        bos.close();

        /**
         * OK
         */

        // netstat -nap | grep 10003
        // todo 查看端口
    }
}

public class p306 {
    /**
     * 上传图片
     *
     * 还有多人上传的问题。
     */
}

/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/9/19
 * @Time:       2:23 PM
 * @Project:    algorithm
 */

package com.itcast.io;

import org.junit.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;


class Read implements Runnable {
    private PipedInputStream pis;

    Read(PipedInputStream pis) {
        this.pis = pis;
    }

    public void run() {

        // 只能try不能throws
        try {
            byte[] buf = new byte[1024];
            System.out.println("读取前，没有数据阻塞中。");
            int len = pis.read(buf);

//            Thread.sleep(6000);
            String s = new String(buf, 0 ,len );
            System.out.println(s);
            System.out.println("独到数据，阻塞结束.");

        } catch (Exception e) {
            throw new RuntimeException("管道输出流失败！");
        } finally {
            if (pis != null)
                try {
                    pis.close();
                } catch (Exception ie) {

                } finally {

                }
        }

    }
}


class Write implements Runnable {
    private PipedOutputStream pos;

    Write(PipedOutputStream pos) {
        this.pos = pos;
    }

    public void run() {
        try {
            System.out.println("开始写入数据，等待6秒后");
            Thread.sleep(6000);
            pos.write("piped lai la".getBytes());
            pos.close();
        } catch (Exception e) {
            System.out.println("输出管道输出流失败");
        }
    }
}


public class p270 {

    // 可以接到一起的流对象。
    // 多线程技术的IO流对象

    @Test
    public void testPipedStreamDemo()  throws  IOException{
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream();
        pis.connect(pos);

        Read r = new Read(pis);
        Write w = new Write(pos);

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(w);

        t1.start();
        t2.start();

        while(true);

    }

    // todo 总时间 83:56:32， 现在已经看了估计有50个小时了。
}

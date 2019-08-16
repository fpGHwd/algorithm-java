/**
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/4/19
 * @Time:       3:27 PM
 * @Project:    algorithm
 */

package com.network.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class TestSocketChannel {

    // 基于通道的解决方案

    @Test
    public void testSocketChannel(){
//        SocketAddress sa = new InetSocketAddress("cathy.autove.dev" , 61000);
        SocketAddress sa = new InetSocketAddress("localhost" , 61000);
        try {
            SocketChannel sc = SocketChannel.open(sa);
            ByteBuffer b = ByteBuffer.allocate(1024);
            int bytesRead = sc.read(b);
            System.out.print(bytesRead);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

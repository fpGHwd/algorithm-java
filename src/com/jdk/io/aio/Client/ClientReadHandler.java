/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/20/19
 * @Time:       9:06 PM
 * @Project:    HydroCloud
 */

package com.jdk.io.aio.Client;

import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.CountDownLatch;



        import java.io.IOException;
        import java.io.UnsupportedEncodingException;
        import java.nio.ByteBuffer;
import java.nio.channels.CompletionHandler;

public class ClientReadHandler implements CompletionHandler<Integer, ByteBuffer> {
    private AsynchronousSocketChannel clientChannel;
    private CountDownLatch latch;
    public ClientReadHandler(AsynchronousSocketChannel clientChannel,CountDownLatch latch) {
        this.clientChannel = clientChannel;
        this.latch = latch;
    }
    @Override
    public void completed(Integer result,ByteBuffer buffer) {
        buffer.flip();
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);
        String body;
        try {
            body = new String(bytes,"UTF-8");
            System.out.println("客户端收到结果:"+ body);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void failed(Throwable exc,ByteBuffer attachment) {
        System.err.println("数据读取失败...");
        try {
            clientChannel.close();
            latch.countDown();
        } catch (IOException e) {
        }
    }
}

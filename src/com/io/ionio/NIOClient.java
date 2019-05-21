/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/15/19
 * @Time:       4:57 PM
 * @Project:    algorithm
 */

package com.io.ionio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOClient {

    /*标识数字*/
    private static int flag = 0;
    /*缓冲区大小*/
    private static int BLOCK = 4096;
    /*接受数据缓冲区*/
    private static ByteBuffer sendbuffer = ByteBuffer.allocate(BLOCK);
    /*发送数据缓冲区*/
    private static ByteBuffer receivebuffer = ByteBuffer.allocate(BLOCK);
    /*服务器端地址*/
    private final static InetSocketAddress SERVER_ADDRESS = new InetSocketAddress(
            "localhost", 8888);

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        //步骤1  打开socket的通道socketChannel
        SocketChannel socketChannel = SocketChannel.open();
        //步骤2  设置为非阻塞方式，同时设置tcp参数
        socketChannel.configureBlocking(false);
        Selector selector = null;


        // 异步连接服务器
        if (socketChannel.connect(SERVER_ADDRESS)) {

        }
        else {
            //步骤5  注册连接服务端socket动作
            selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }
        // 分配缓冲区大小内存


        Set<SelectionKey> selectionKeys;
        Iterator<SelectionKey> iterator;
        SelectionKey selectionKey;
        SocketChannel client;
        String receiveText;
        String sendText;
        int count=0;
        //步骤6 启动线程
        while (true) {
            //选择一组键，其相应的通道已为 I/O 操作准备就绪。
            //此方法执行处于阻塞模式的选择操作。
            int ret = selector.select();
            //System.out.println(ret);

            //返回此选择器的已选择键集。
            selectionKeys = selector.selectedKeys();
            //System.out.println(selectionKeys.size());
            iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {//7 轮询就绪的key
                selectionKey = iterator.next();
                //4  判断连接结果，如果连接成功，跳到步骤10，如果不成功，执行步骤5
                if (selectionKey.isConnectable()) {
                    System.out.println("client connect");
                    client = (SocketChannel) selectionKey.channel();
                    // 判断此通道上是否正在进行连接操作。
                    // 完成套接字通道的连接过程。8 handle connect()
                    if (client.isConnectionPending()) {
                        client.finishConnect();//9 判断连接完成，完成连接
                        System.out.println("完成连接!");
                        sendbuffer.clear();
                        sendbuffer.put("Hello,Server".getBytes());
                        sendbuffer.flip();
                        client.write(sendbuffer);
                    }
                    //步骤10 向多路复用器注册 OP_READ
                    client.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {//步骤11 handle read() 异步读请求消息到ByteBuffer
                    client = (SocketChannel) selectionKey.channel();
                    //将缓冲区清空以备下次读取
                    receivebuffer.clear();
                    //读取服务器发送来的数据到缓冲区中
                    count=client.read(receivebuffer);
                    if(count>0){
                        receiveText = new String( receivebuffer.array(),0,count);
                        System.out.println("客户端接受服务器端数据--:"+receiveText);
                        client.register(selector, SelectionKey.OP_WRITE);
                    }

                } else if (selectionKey.isWritable()) {//步骤13  异步写ByteBuffer到SocketChannel
                    sendbuffer.clear();
                    client = (SocketChannel) selectionKey.channel();
                    sendText = "message from client--" + (flag++);
                    sendbuffer.put(sendText.getBytes());
                    //将缓冲区各标志复位,因为向里面put了数据标志被改变要想从中读取数据发向服务器,就要复位
                    sendbuffer.flip();
                    client.write(sendbuffer);
                    System.out.println("客户端向服务器端发送数据--："+sendText);
                    client.register(selector, SelectionKey.OP_READ);
                }
            }
            selectionKeys.clear();
        }
    }
}
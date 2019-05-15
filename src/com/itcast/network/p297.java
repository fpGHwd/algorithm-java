package com.itcast.network;

import org.junit.Test;

import java.net.*;
import java.util.Arrays;

public class p297 {
    /**
     * Socket：插座
     * UDP Demo
     */
    @Test
    public void UdpSend() throws Exception {
        DatagramSocket ds = new DatagramSocket(9999);
        byte[] data = "udp ge men lai le".getBytes();
        DatagramPacket dp = new DatagramPacket(data, data.length,
                InetAddress.getByName("localhost"), 10000);
        ds.send(dp);
        ds.close();
    }


    @Test
    public void UdpReceive() throws Exception {
        DatagramSocket ds = new DatagramSocket(10000);
        byte[] data = new byte[1024];
        DatagramPacket dp = new DatagramPacket(data, data.length);
        int count = 0;
        while(++count <= 5){
            ds.receive(dp); // 阻塞方法，就算是true也不是死循环
            System.out.println(dp.getAddress().getHostAddress()
                    + "/" + dp.getPort() + ": " + new String(dp.getData(),
                    0,dp.getLength()));
//            count++;
        }
//        ds.close();

    }
}

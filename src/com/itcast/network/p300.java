/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/15/19
 * @Time:       11:29 PM
 * @Project:    algorithm
 */

package com.itcast.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

class UdpSend2{
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = bufr.readLine())!=null){
            if("886".equals(line))
                break;
            byte[] buf = line.getBytes();
            DatagramPacket dp = new DatagramPacket(buf,buf.length, InetAddress.getByName("localhost"), 10001);
            ds.send(dp);
        }
        ds.close();
    }
}

public class p300 {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(10001);
        while(true){
            byte[] buf = new byte[1024]; // 64k = 64 * 1024
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            ds.receive(dp);
            String ip = dp.getAddress().getHostAddress();
            String data =  new String(dp.getData(), 0,dp.getLength());

            System.out.println(ip+"::"+data);
        }
    }

    // 广播地址：192.168.1.255 / 192.168.0.255

}

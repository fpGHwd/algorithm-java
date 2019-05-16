/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/15/19
 * @Time:       11:41 PM
 * @Project:    algorithm
 */

package com.itcast.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

class Send implements Runnable{

    private DatagramSocket ds;

    Send(DatagramSocket ds){
        this.ds = ds;
    }

    public void run(){
        try{
            BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            while((line = bufr.readLine())!= null){
                if("886".equals(line)){
                    break;
                }
                byte[] buf = line.getBytes();

                try {
                    DatagramPacket dp = new DatagramPacket(buf,buf.length, InetAddress.getLocalHost(),10001);
                    ds.send(dp);
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Receive implements Runnable{
    private DatagramSocket ds;

    Receive(DatagramSocket ds){
        this.ds  =ds;
    }

    public void run(){
        try{
            while(true){
                byte[] buf = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buf,buf.length);
                ds.receive(dp);
                String ip = dp.getAddress().getHostName();
                String data = new String(dp.getData(),0,dp.getLength());
                System.out.println(ip + ":" + data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class p301 {
    public static void main(String[] args) throws SocketException {
        DatagramSocket sendSocket = new DatagramSocket();
        DatagramSocket receiveSocket = new DatagramSocket(10001);
        new Thread(new Send(sendSocket)).start();
        new Thread(new Receive(receiveSocket)).start();
    }
}

/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/20/19
 * @Time:       9:03 PM
 * @Project:    HydroCloud
 */

package com.jdk.io.aio.Client;


        import java.util.Scanner;
public class Client {
    private static String DEFAULT_HOST = "127.0.0.1";
    private static int DEFAULT_PORT = 12345;
    private static AsyncClientHandler asyncClientHandler;
    public static void start(){
        start(DEFAULT_HOST,DEFAULT_PORT);
    }
    public static synchronized void start(String ip,int port){
        if(asyncClientHandler !=null)
            return;
        asyncClientHandler = new AsyncClientHandler(ip,port);
        new Thread(asyncClientHandler,"Client").start();
    }
    //向服务器发送消息
    public static boolean sendMsg(String msg) throws Exception{
        if(msg.equals("q")) return false;
        asyncClientHandler.sendMsg(msg);
        return true;
    }
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception{
        Client.start();
        System.out.println("请输入请求消息：");
        Scanner scanner = new Scanner(System.in);  // 阻塞在这里
        while(Client.sendMsg(scanner.nextLine()));
    }
}

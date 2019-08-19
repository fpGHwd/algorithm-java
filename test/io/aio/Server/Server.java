/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/20/19
 * @Time:       9:00 PM
 * @Project:    HydroCloud
 */

package io.aio.Server;


/**
 * AIO服务端
 * @author yangtao__anxpp.com
 * @version 1.0
 */
public class Server {
    private static int DEFAULT_PORT = 12345;
    private static AsyncServerHandler asyncServerHandle;
    public volatile static long clientCount = 0;
    public static void start(){
        start(DEFAULT_PORT);
    }
    public static synchronized void start(int port){
        if(asyncServerHandle!=null)
            return;
        asyncServerHandle = new AsyncServerHandler(port);
        new Thread(asyncServerHandle,"Server").start();
    }
    public static void main(String[] args){
        Server.start();
    }
}

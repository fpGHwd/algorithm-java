/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/20/19
 * @Time:       8:53 PM
 * @Project:    HydroCloud
 */

package com.jdk.io.nio;


public class Server {
    private static int DEFAULT_PORT = 12345;
    private static ServerHandle serverHandle;
    public static void start(){
        start(DEFAULT_PORT);
    }
    public static synchronized void start(int port){
        if(serverHandle!=null)
            serverHandle.stop();
        serverHandle = new ServerHandle(port);
        new Thread(serverHandle,"Server").start();
    }
    public static void main(String[] args){
        start();
    }
}

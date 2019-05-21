/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/20/19
 * @Time:       9:07 PM
 * @Project:    HydroCloud
 */

package com.io.aio;


import com.io.aio.Client.Client;
import com.io.aio.Server.Server;

import java.util.Scanner;

/**
 * 测试方法
 *
 * @author yangtao__anxpp.com
 * @version 1.0
 */
public class TestAio {
    //测试主方法
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
        //运行服务器
        Server.start();
        //避免客户端先于服务器启动前执行代码
        Thread.sleep(100);
        //运行客户端
        Client.start();
        System.out.println("请输入请求消息：");
        Scanner scanner = new Scanner(System.in);
        while (Client.sendMsg(scanner.nextLine())) ;
    }

    /**
     * 服务器异步：
     * 1. 接收客户端连接异步，客户端异步，异步客户端
     * 2.
     *
     * 客户端异步：
     * 1. 发送服务器信息异步 -> 概率的或者说无法控制的描述
     * 2. 读取服务器信息异步 -> 概率的或者说无法空值的描述
     */
}

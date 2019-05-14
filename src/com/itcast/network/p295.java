/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/13/19
 * @Time:       11:55 PM
 * @Project:    algorithm
 */

package com.itcast.network;

import org.junit.Test;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class p295 {
    /**
     * IP地址
     *
     * 只要概念多了，会区分出来就可以了。你根本不需要记住那么多细节
     */

    @Test
    public void test() throws UnknownHostException {

//        InetAddress ia = new InetSocketAddress("")

        /**
         * 面向对象复杂事情简单化
         */
        InetAddress ia = InetAddress.getLocalHost();
        System.out.println(ia.toString());
        System.out.println("hostname: " + ia.getHostName() +"\n"+ "address: " + ia.getAddress().toString()) ;

        InetAddress ia1 = InetAddress.getByName("www.baidu.com");
        System.out.println(ia1.toString());

        InetAddress ia2 = InetAddress.getByName("www.google.com");
        System.out.println(ia2.toString());

        InetAddress ia3 = InetAddress.getByName("www.twitter.com");
        System.out.println(ia3.toString());

        InetAddress ia4 = InetAddress.getByName("www.facebook.com");
        System.out.println(ia4.toString());


        /**
         * suzumiya-pc/127.0.1.1
         * hostname: suzumiya-pc
         * address: [B@63c12fb0
         * www.baidu.com/111.13.100.91
         * www.google.com/31.13.65.1
         * www.twitter.com/69.171.233.24
         * www.facebook.com/69.63.176.15
         */

        /**
         * 负载均衡，
         * 一个域名对应多个服务器。所以可能有多个IP地址，是一个组
         */
    }
}

/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/10/19
 * @Time:       5:20 PM
 * @Project:    algorithm
 */

package com.itcast.io;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class p275 {

    /**
     * 编码：
     * 字符串-》字节数组
     * str.getBytes()
     *
     *
     * 解码：
     * 字节数组-》字符串
     * new String(byte[])
     */

    /**
     * 编码解码都在String里面，这样就比较方便
     */

    @Test
    public void testGetBytes() throws Exception{
        String s = "你好";
        byte[] b = s.getBytes("GBK");
        System.out.println(Arrays.toString(b));
        byte[] b1 = s.getBytes("UTF-8");
        System.out.println(Arrays.toString(b1));
        String s1 = new String(b, "GBK");
        System.out.println(s1);
        String s2 = new String(b1, "GBK");
        System.out.println(s2);
        String s3 = new String(b1, "UTF-8");
        System.out.println(s3);
        // 都是序列化
    }


    @Test
    public void testHandleWrongCode() throws UnsupportedEncodingException {
        // 码不知道但是数字知道

        String s = "你好";
        System.out.println("s: " + s);
        byte[] b1 = s.getBytes("GBK");
//        System.out.println(b1.toString());
        System.out.println("b2: " + Arrays.toString(b1));
        String s1 = new String(b1, "ISO8859-1");
        System.out.println("s1： " + s1);

        byte[] b2 = s1.getBytes("ISO8859-1");
        System.out.println("b2: " + Arrays.toString(b2));
        String s2 = new String(b2, "GBK");
        System.out.println("s2: " + s2);

        // 开发过程中，tomcat的编码就是ISO8859-1
        // 服务端只能先解码然后，再使用源解码。
        // 服务器的码表改称GBK，但是服务器不能随便变
        // 一个服务器提供很多服务。
        // 服务端的环境编码变了不能解决不同服务编码不一样的问题。

    }

    @Test
    public void testHandleWrongCode1() throws UnsupportedEncodingException {

        String s = "你好";
        System.out.println("s: " + s);
        byte[] b1 = s.getBytes("GBK");
        System.out.println("b2: " + Arrays.toString(b1));
        String s1 = new String(b1, "UTF-8");
        System.out.println("s1： " + s1);

        byte[] b2 = s1.getBytes("UTF-8");
        System.out.println("b2: " + Arrays.toString(b2));
        String s2 = new String(b2, "GBK");
        System.out.println("s2: " + s2);

/*      结果：
        s: 你好
        b2: [-60, -29, -70, -61]
        s1： ���
        b2: [-17, -65, -67, -17, -65, -67, -17, -65, -67]
        s2: 锟斤拷锟�*/

// UTF-8有未知字符区域，UTF-8和GBK都识别中文造成的。


    }
}

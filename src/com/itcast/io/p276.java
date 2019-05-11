/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/10/19
 * @Time:       5:53 PM
 * @Project:    algorithm
 */

package com.itcast.io;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class p276 {
    // 飘过我也不会


    @Test
    public void test1() throws UnsupportedEncodingException {
        String s = "联通";
        System.out.println("s: " + s);

        // 确定字节数
        // 字符流GBK是两个两个读
        // UTF-8读的字节数有标识。
        byte[] b1 = s.getBytes("GBK");
        for(byte b : b1){
            System.out.println( Integer.toBinaryString(b & 0xff)); // 后八位。
            // 11000001
            // 10101010
            // 两个字节作为一个汉字
            // 11001101
            // 10101000

            /**
             * s: 联通
             * 11111111111111111111111111000001
             * 11111111111111111111111110101010
             * 11111111111111111111111111001101
             * 11111111111111111111111110101000
             *
             * s: 联通
             * 11000001
             * 10101010
             * 11001101
             * 10101000
             */

            // GBK的编码形式刚好符合UTF-8的格式。
            // 头不符合GBK就用UTF-8解决。。。这都是windows的记事本的本身的逻辑。
        }
    }


    /**
     *
     *
     */
    // p277
    public static void main(String[] args){
        System.out.println("hello world");



    }
}

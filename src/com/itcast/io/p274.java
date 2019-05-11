/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/10/19
 * @Time:       4:11 PM
 * @Project:    algorithm
 */

package com.itcast.io;

import org.junit.Test;

import java.io.*;

public class p274 {

    @Test
    public void testWriteTextGBK() throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("res/gbk.txt"), "GBK");
        osw.write("你好"); // 4B gbk 2个字节
        osw.close();
    }

    @Test
    public void testWriteTextUTF_8() throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("res/utf.txt"), "UTF-8");
        osw.write("你好"); // 6B uft-8 3个字节
        osw.close();
    }

    @Test
    public void testReadTextGBK() throws IOException{
        InputStreamReader isr = new InputStreamReader(new FileInputStream("res/gbk.txt"),"GBK");
//        BufferedReader br = new BufferedReader(isr);
//        String s =null;
//        while((s = br.readLine())!=null){
//
//            System.out.println(s);
//        }

        char[] buf = new char[10];
        int len = isr.read(buf);
        String str = new String(buf, 0, len); // todo 这一部的变化不懂
        System.out.println(str);
        isr.close();

        // 采用utf-8: ���
    }

    @Test
    public void testReadTextUTF_8() throws IOException{
        InputStreamReader isr = new InputStreamReader(new FileInputStream("res/utf.txt"), "UTF-8");
//        BufferedReader br = new BufferedReader(isr);
//        String s =null;
//        while((s = br.readLine())!=null){
//            System.out.println(s);
//        }

        char[] buf = new char[10];
        int len = isr.read(buf);
        String str = new String(buf, 0, len); // todo 这一部的变化不懂
        System.out.println(str);
        isr.close();

        // 采用GBK：浣犲ソ
        // 默认是UTF-8
    }
}

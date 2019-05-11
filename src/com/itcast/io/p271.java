/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/9/19
 * @Time:       5:50 PM
 * @Project:    algorithm
 */

package com.itcast.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class p271 {
    // RandomAccessFile
    // 操作数据必然是流
    // 字节流，不是字节流。（byte数据）
    // 只操作文件


    public static void main(String[] args){
        System.out.println(Integer.toBinaryString(258)); // 最低八位
    }

    @Test
    public void testWriteFile() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("res/ran.txt", "rw");

        raf.write("李四".getBytes());
        raf.writeInt(97); // write int
//        raf.writeInt(258); // 这样就可以写进取， utf-8码
        raf.write("王五".getBytes());
        raf.writeInt(99);

        raf.close();
    }

    @Test
    public void testReadFile() throws IOException{
        RandomAccessFile raf = new RandomAccessFile("res/ran.txt", "r");
        byte[] buf = new byte[4];
//        raf.write("haha".getBytes()); // 只读不能调用写方法
        raf.read(buf);
        String name = new String(buf);
//        System.out.println("name")
        int age = raf.readInt();
        System.out.println(name + ": "+age);

        // todo 问题？没有成功，后一个。
    }


    // seek可以实现多文件写入，多线程。
    // 一班可以实现多线程写入。随机读写访问。
    // seek和skipBytes两个方法的共同点：向后跳读


    // 273
    // ByteArrayInputStream：数据资源是一个字节数组
    // ByteArrayOutputStream:自己创建一个字节数组
    //


    @Test
    public void testByteArrayInputSteram() throws IOException{
        ByteArrayInputStream bais = new ByteArrayInputStream("ABCDEF".getBytes());
//        System.out.println("bais size: " + bais.available()); // 6

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int by = 0;
        while((by = bais.read())!=-1){
            baos.write(by);
            baos.flush();
        }


        System.out.println("baos size: " + baos.size());
        System.out.println("baos: " + baos.toString());

        bais.close();
        baos.close();
    }


    /**
     * 源设备：
     *      键盘system.in，硬盘file，内存byte[](获取和设置：读/写)
     *
     * 目的设备：
     *      控制台system.out，硬盘file，内存byte[]
     *
     *      // 源
     */

    // 274 转换流的字符编码
    /**
     * 还是那种序列化
     *
     * 编码表： 1100101->字符 一章表
     *
     * 如果没有形成直线理解，那么说明没有理解。
     */

}

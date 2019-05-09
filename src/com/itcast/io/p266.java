/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/9/19
 * @Time:       11:23 AM
 * @Project:    algorithm
 */

package com.itcast.io;

import java.io.*;

public class p266 {

    public static void main(String[] args) throws IOException {

//        File f = new File("info.txt");
//        PrintWriter pw = new PrintWriter(f);
        // System.in; 属于Ssytem的一个InputStream
        // 那么System.out属于system的一个OutputStream，中间有一个转化流。


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // InputStreamReader就是转换流，那么ReaderInputStream也是吗？
        // ReaderInputStream，当然不是，只有字节流转换为字符流。。。没有字符流转换为字节流，如果药用字节流，那么直接也字节流就性了。
        // 字节流代表的是硬盘上的字节格式，不是人们能读的格式。一般情况下用的少。

        PrintWriter pw = new PrintWriter(new FileWriter("a.txt"), true);

        String line = null;

        while((line = br.readLine()) != null){
            if("over".equals(line)){
                break;
            }
            pw.println(line.toUpperCase());
        }

        pw.close();
        br.close();

    }

}

/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/9/19
 * @Time:       11:45 AM
 * @Project:    algorithm
 */

package com.itcast.io;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

public class p267 {
    public static void main(String[] args) throws IOException { // 抛IOException是为了省事。

        // 小说一章一章的出

        Vector<FileInputStream> v = new Vector<FileInputStream>();
        v.add(new FileInputStream("1.txt"));
        v.add(new FileInputStream("2.txt"));
        v.add(new FileInputStream("3.txt"));
        Enumeration<FileInputStream> eis = v.elements();
        SequenceInputStream sis = new SequenceInputStream(eis);

        FileOutputStream fos = new FileOutputStream("4.txt");

        byte[] buf = new byte[1024];

        int len = 0;
        while((len = sis.read(buf))!= -1){ // sis.read(buf)
            fos.write(buf,0,len);
        }
        fos.close();
        sis.close();
    }

    // 打印流，序列流，操作对象。
}

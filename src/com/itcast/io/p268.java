/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/9/19
 * @Time:       11:58 AM
 * @Project:    algorithm
 */

package com.itcast.io;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

public class p268 {

    // 切割流

    public static void main(String[] args)throws IOException {

        // 一个读取流对应三个输出流 —— 切割流
        // 资源的切割。，资源文件切割好然后发送。

        // 应用就是目的
        // 碎片文件

        FileInputStream fis = new FileInputStream("up-half.png");
        FileOutputStream fos = null;
        byte[] buf = new byte[100*1024];

        int len = 0, c = 0;

        while((len = fis.read(buf))!=-1){
            fos = new FileOutputStream(++c + ".part");
            fos.write(buf,0,len);;
            fos.close();
        }

        fis.close();


    }

    @Test
    public void merge() throws IOException{
        ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();  // vector效率低

        for(int x = 1; x<=5; x++){
            al.add(new FileInputStream(x+".part"));
        }
        // fis -> efis
        // arraylist -> iteraton
        Iterator<FileInputStream> ifis = al.iterator();
        Enumeration<FileInputStream> efis = new Enumeration<FileInputStream>() {
            @Override
            public boolean hasMoreElements() {
                return ifis.hasNext();
            }

            @Override
            public FileInputStream nextElement() {
                return ifis.next();
            }
        };
        SequenceInputStream sis = new SequenceInputStream(efis);

        FileOutputStream fos = new FileOutputStream("merge-up-half.jpg"); // 必须用字节流，因为不是字符类数据
        byte[] buf = new byte[1024];
        int len;
         while((len = sis.read(buf))!=-1){
             fos.write(buf, 0,len);
//             fos.flush();
         }

         fos.close();
         sis.close();

         // OK 文件能够打开

        // 切割电影大文件的问题，不需要建一个100M的buf，只需要往一个文件流中写10次
    }
}

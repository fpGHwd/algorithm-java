/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/9/19
 * @Time:       9:45 AM
 * @Project:    algorithm
 */

package com.itcast.io;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

public class p264 {
    // baseDir /home/suzumiya/IdeaProjects/algorithm

    public static void main(String[] args){



    }


    // 用一个流和info.txt关联
    // 读取一行数据，用=切割
    // 左建右值

    @Test
    public void testImportFileAsProperties() throws IOException {
        // 文件转换成一个InputStream
        // 操作系统，，，abstract connection
//        Properties p = new Properties(new BufferedReader(new FileReader("info.txt")));

        // 来劲

        BufferedReader br = new BufferedReader(new FileReader("info.txt"));

        Properties p = new Properties();
        String l = null;
        while((l = br.readLine()) != null){
            String arr[] = l.split("=");
            p.setProperty(arr[0], arr[1]);
//            System.out.println(l);
        }

        br.close();

        System.out.println(p); // {.... }
    }


    @Test
    public void testLoadDemo() throws IOException{
        Properties p = new Properties();
        FileInputStream fis =  new FileInputStream("info.txt");
        p.load(fis);

//        System.out.println(p);

        p.list(System.out);

/*        -- listing properties --
        zhangsan=30
        lisi=57
        wangwu=99*/
    }


    // store 内存的properties存储到文件中
    @Test
    public void testStrore() throws IOException{
        Properties p = new Properties();
        FileInputStream fis =  new FileInputStream("info.txt");
        p.load(fis);

//        System.out.println(p);

        p.setProperty("wangwu",39+"");
        FileOutputStream fos = new FileOutputStream("info-outputstream.out");
        p.store(fos, "this is comments");

        p.list(System.out);


/*        #this is comments
        #Thu May 09 10:03:05 CST 2019
        zhangsan=30
        lisi=57
        wangwu=39*/

    }


    @Test
    public void test() throws IOException{

//        return;
        FileInputStream fis = new FileInputStream("info.txt");
        FileReader fr = new FileReader("info.txt");


        /**
         * Reader
         * Writer
         *
         *
         * InputStreamReader
         * OutputStreamWriter
         */

//        Session session = new Session


        // 要分清楚字节和字符

        /**
         *
         *          字符：
         *          FileReader
         *          FileWriter
         *
         *          BufferedReader
         *          BufferedWriter
         *

         *          字节：
         *          FileInputStream
         *          FileOutputStream
         *
         *          BufferedInputStream
         *          BufferedOutputStream
         */
    }



    // 有层次的建制对xml，xml的封装形式
    // dom4j： dom for java
    // log4j: log for java

}

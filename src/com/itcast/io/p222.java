/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/7/19
 * @Time:       12:53 PM
 * @Project:    algorithm
 */

package com.itcast.io;

import org.junit.Test;

import java.io.*;

public class p222 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("demo.txt");
        // 写到流中，就是内存中
        fw.write("this a string to be stored in to demo.txt.");
        fw.flush();
        fw.close(); // close自带刷新
        //        System.out.println("hello, io");


    }


    //p224
    @Test
    public void testWriteCatch(){
        FileWriter fw = null;
        try{
            fw = new FileWriter("/home/suzumiya/IdeaProjects/algorithm/haha/demo.txt");
            fw.write("write content to file demo.txt");
        }catch (IOException ioe){
//            ioe.printStackTrace();
            System.out.println(ioe);
        }finally {
            if(fw!=null) {
                try {
                    fw.close();
                } catch (IOException e) {
//                    e.printStackTrace();
                    System.out.println(e.toString());
                }
            }
        }
    }

    //p224
    // reuse this class via test method
    @Test
    public void testWriteContinue() throws IOException{
        FileWriter fw = new FileWriter("demo.txt",true);
        fw.write("\nadd string content for demo.txt");
        fw.write("\nHatsune Miku is virtual singer IDOL!!!");
        fw.write("\n写入中文的一个测试");
        fw.close();
    }

    // p226
    @Test
    public void testReadFile() throws IOException{
        FileReader fr = new FileReader("demo.txt");
        int c  = fr.read();
        System.out.println("ch = " + (char)c);
        int d  = fr.read();
        System.out.println("ch = " + (char)d);
//        Reader r = new Reader();
    }

    //p231
    @Test
    public void testBufferedREaderDemo() throws IOException{
        FileReader fr = new FileReader("demo.txt");
        BufferedReader bfrd =  new BufferedReader(fr);
//        String l1 = bfrd.readLine();

        String l1 = null; int i = 1;

        while((l1 = bfrd.readLine())!=null){ // 文件末尾是空值
            System.out.println("LINE " + i++  + ": " + l1);
        }

        bfrd.close();
    }


    // p232
    @Test
    public void testCopyFileByBuffer(){

        BufferedReader bfrd = null;
        BufferedWriter bfwt = null;

        try {
            bfrd = new BufferedReader(new FileReader("demo.txt"));
            bfwt = new BufferedWriter(new FileWriter("demo-copy.txt"));

            String line = null;
            while((line = bfrd.readLine())!= null){ // not including any line-termination characters or null if the end of the stream has been reached
                bfwt.write(line);
                bfwt.newLine();
                bfwt.flush();
            }
        }catch (IOException ioe){
//            System.out.println(ioe.toString());
            throw new RuntimeException("读写失败");
        }finally {
            if(bfrd !=null)
                try{
                    bfrd.close();
                }catch (IOException ioe){
                    System.out.println(ioe.toString());
                }
            if(bfwt != null){
                try{
                    bfwt.close();
                }catch (IOException ioe){
                    System.out.println(ioe.toString());
                }
            }
        }

    }

    // p233
    // readLine方法原理：无论是读一行还是多个字符，最终还是在硬盘上一个一个读取。所以最终使用的还是read方法。
    // readLine为什么彼read要高校

    class MyBufferdReader{

        private FileReader fr = null;

        MyBufferdReader(FileReader fr){
            this.fr = fr;
        }

        public String myReadLine() throws IOException{
            StringBuilder sb =new StringBuilder();
            int ch = 0;
            while((ch = fr.read())!= -1){
                if(ch == '\r')
                    continue;
                if(ch == '\n')
                    return sb.toString();
                else
//                    sb.append((char)ch); // 这个都是ascii码
                    sb.append((char)ch);

            }
            if(sb.length() != 0)return sb.toString();
            return null;
        }
    }

    // p234
    @Test
    public void testMyReadLine() throws  IOException{

        FileReader fr = new FileReader("demo.txt");
        MyBufferdReader mbr = new MyBufferdReader(fr);
        String l = null;
        while(( l = mbr.myReadLine()) != null){
            System.out.println(l);
        }
    }

    // p235 mybuffer就是对FileReader的功能的一种增强，就是装饰设计模式。
    // 自定义的类是装饰类
    // 基于原有东西不断优化起来的东西。
    // 哦了把，哦了、

    class Person{
        void chifan(){
            System.out.println("吃饭");
        }
    }

    class SuperPerson{
        private Person p;
        SuperPerson(Person p){
            this.p = p;
        }

        void superChifan(){
            System.out.println("开胃酒");
            p.chifan();
            System.out.println("甜点");
            System.out.println("来一根");
        }
    }

    @Test
    public void testDecoratingMode(){

        Person p = new Person();
        SuperPerson sp = new SuperPerson(p);

        sp.superChifan();
    }


    // p236
    // 装饰和继承的区别
    /**
     * 继承具有继承体系
     *
     *
     * MyReader
     *      |-- MyTextReader
     *          |--MyBufferTextReader
     *      |-- MyMediaReader
     *          |--MyBufferMediaReader
     *      |-- MyDataReader
     *          |--MyBufferDataReader
     * 这个结构的拓展性很差
     *
     * 没有继承降低类与类之间的关系
     *
     * 装饰类增强已有对象
     *
     * 通过多台来增加拓展性
     *
     *
     * 装饰设计模式和继承的区别
     *
     */
    public void testDecoratingMophor(){

    }

    @Test
    // p238 带行号的装饰类
    public void testLineReaderDecorate() throws IOException{
        FileReader fr = new FileReader("demo.txt");
        LineNumberReader lnr = new LineNumberReader(fr);lnr.setLineNumber(50);
        String line = null;
        while((line = lnr.readLine()) != null){
            System.out.println(lnr.getLineNumber() + ": " + line);
        }
    }


    // p239 实现自己的带行号的装饰类
    class MyLineNumberReaderDemo{
        private FileReader fr;
        private int lineNumber = 0;
        MyLineNumberReaderDemo(FileReader fr){
            this.fr = fr;
        }

        public void setLineNumber(int ln){
            this.lineNumber = ln;
        }

        public int getLineNumber(){
            return lineNumber;
        }

        public String myReadLine() throws IOException {

            StringBuilder sb = new StringBuilder(lineNumber++);
            int c;
            while((c = fr.read()) != -1){
                if(c == '\r')
                    continue;
                if(c == '\n')
                    return sb.toString();
                else
                    sb.append((char)c);
            }
            if(sb.length()!=0)return sb.toString();
            return null;
        }
    }

    @Test
    public void testMyLineNumberReader() throws IOException{
        FileReader fr = new FileReader("demo.txt");
        MyLineNumberReaderDemo mnrd = new MyLineNumberReaderDemo(fr);
        String line = null;
        while((line = mnrd.myReadLine())!=null){
            System.out.println(mnrd.getLineNumber() + ": " + line);
        }
    }

    // p240 repetition to the most - repetition has much the same as in reuse
    // change file

}
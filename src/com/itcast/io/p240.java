/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/7/19
 * @Time:       7:19 PM
 * @Project:    algorithm
 */

package com.itcast.io;

import org.junit.Test;

import java.io.*;

public class p240 {

    /*
    依旧说到字节和字符的问题。
    字节流和字符流不一样。字节流定义各种协议比较友好。
    字符流容易可以转换成文字便于人的辨认和书写。

    不操作文本，就操作字节流
     */


    // p240 字节流File读写问题
    @Test
    public void testWriteFileOutput() throws IOException {
        FileOutputStream fos = new FileOutputStream("fos.txt");

        byte[] wbs1 = "abcdefg".getBytes();
        byte[] wbs = {0x30, 0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37,
                0x38, 0x39, 0x3a, 0x3b, 0x3c, 0x3d, 0x3e};
        fos.write(wbs1);

        fos.close();
    }

    @Test
    public void testReadFileOutput() throws IOException {
        FileInputStream fis = new FileInputStream("fos.txt");
        byte[] r = new byte[4];
        int n;
        while ((n = fis.read(r, 0, 4)) != -1) {
            System.out.println("has read lenght: " + n);
        }

//          output:
//        has read lenght: 4
//        has read lenght: 3
        fis.close();
    }

    @Test
    public void testReadFileOutput2() throws IOException {
        FileInputStream fis = new FileInputStream("fos.txt");
        int ch;
        while ((ch = fis.read()) != -1) {
            System.out.println("has read char: " + (char) ch);
        }

//        has read char: a
//        has read char: b
//        has read char: c
//        has read char: d
//        has read char: e
//        has read char: f
//        has read char: g
        fis.close();
    }

    /* available 是读取信息的一种映射，并不是什么更加奇怪和不能理解的东西。 */
    @Test
    public void testReadFileOutput3() throws IOException {
        FileInputStream fis = new FileInputStream("fos.txt");
        int num = fis.available();
        System.out.println("available length: " + num); // available length: 7

        byte[] recv = new byte[7];
        fis.read(recv, 0, num);
        for (int i = 0; i < recv.length; i++) {
            System.out.println("receive char: " + (char) recv[i]);
        }
        fis.close(); // 但是感觉总有问题。
        // 如果定义一个刚刚大小好的缓冲区，那就不用循环了，直接读完就行，此时的缓冲区大小正好是需要的结果。
        // 在不知道要读多少东西之前，是不存在这样一个缓冲区的东小的。
    }


    @Test
    public void testReadFileOutput4() throws IOException {

        FileInputStream fis = new FileInputStream("fos.txt");
//        int a = fis.available();
        byte[] b = new byte[fis.available()];

        fis.read(b, 0, fis.available());

        fis.close();
        // 这种方式一定要慎用
        // 常规方法还是用1024的缓冲区来存储来的东西。

    }

    // p241
    // 复制一个文件，文件是字节流。
    // 文本是字符流，媒体文件是字节流。就是这么一个差别。
    // 也许是现在理解力高了，现在是真的还不错。

    @Test
    public void testCopyPicture() throws IOException {
        FileInputStream fis = new FileInputStream("up-half.png");
        FileOutputStream fos = new FileOutputStream("up-half-copy.png");

        byte[] b = new byte[1024];
        int n;
        while ((n = fis.read(b, 0, 1024)) != -1) {
            fos.write(b, 0, n);
        }

        fis.close();
        fos.close();
    }
    // 字符流也可以复制，但是可能可能打开也读取不了。。。。this time you need courage
    // 不要拿字符流去处理媒体文件


    // p242
    @Test
    public void testCopyMediaByBuffer() throws IOException {
//        FileInputStream fis = new FileInputStream("up-half-copy.png");
//        BufferedInputStream bis = new BufferedInputStream(fis);
//        FileOutputStream fos = new FileOutputStream("up-half-copy-copy.png");
//        BufferedOutputStream bos = new BufferedOutputStream(fos);

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("up-half-copy-copy-copy.png"));
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("up-half-copy-copy.png"));

        byte[] b = new byte[1024];
        int l;
        long start = System.currentTimeMillis();


        // method 1： 2毫秒
        while ((l = bis.read(b)) != -1) {
//            System.out.println(l); // 如果打印出来将会有很多的1024的段子。
            bos.write(b);
//            bos.flush();
        }


        // method 2: 28毫秒
/*        int r;
        while((r = bis.read())!=-1){
            bos.write(r);
        }*/

        long end = System.currentTimeMillis();

        System.out.println((end - start) + "毫秒");
        bis.close();
        bos.close();
    }
    /*
    如果说fis/bis或者FileInputStream/BufferedInputStream代表 待copy 的东西。
    那么fos/bos或者FileOutputStream/BufferedOutputStream代表 copy后的东西。
    这样就很容易理解了。
     */


    // p243: 自定义字节流的缓冲区
    class MyBufferedInputStream {
        private InputStream is;
        private byte[] buff = new byte[1024];
        private int pos = 0, count = 0;     // pos是已经读到的位置，count是buff中还没有读的字节数，都差不多。

        MyBufferedInputStream(InputStream is) {
            this.is = is;
        }

        // 一次一个字节，从缓冲区（字节数组）获取
        public int myRead() throws IOException{
            if(count == 0){
                count = is.read(buff);
//                byte b= buff[pos];
                if(count < 0)
                    return -1;
                pos = 0;
                count--;
//                pos++;
                return buff[pos++]&0xff;
            }else if(count > 0){
                count--;
//                return buff[pos++];
                return buff[pos++]&0xff;
            }
            return -1;
        }

        public void close() throws IOException {
            is.close();
        }
    }

    @Test
    public void testMyselfBufferedInputStream() throws IOException {
        MyBufferedInputStream mbos = new MyBufferedInputStream(new FileInputStream("up-half-copy-copy-copy.png"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("up-half-copy-copy-copy-copy.png"));

        int l;


        long start = System.currentTimeMillis();
        // method 1： 2毫秒
        while (((l = mbos.myRead())) != -1) {
            bos.write(l); // 只写低八位
        }


        long end = System.currentTimeMillis();

        System.out.println((end - start) + "毫秒");
        bos.close();
        bos.close();
    }
    // 并没有复制成功System
    /*
    mp3都是二进制数据，当前面都是11111111，读一个字节时代表-1，while循环停止。
    上升类型（byte->int)时作符号拓展

    修改了返回类型。
     */



    //p244
    /*
    字节流：
    FileReader
    FileWriter

    BufferedReader
    BufferedWriter

    字符流
    FileInputStream
    FileOutputStream

    BufferedInputStream
    BufferedOutputStream

    问题来了，如何读取键盘录取。
    哪里都有C语言的影子。还是要学啊。
    为什么学java不学c就是因为这个啊。。。。为什么要学其他的语言，java啥都影射了。
    就算没有显式映射，自己理解的映射都感觉很机制啊。其实这就是变通，这就是人。抽象的东西，理解和联系起来就是那么有成就感。
     */

    public void testSystemIn() throws IOException{
        InputStream is = System.in; // system.in就是系统输入
        int i;
        while((i = is.read())!=-1){
            System.out.println(i);
        }

        // control+c就是在输入中加入结束标记 // 一定要抽象的想。不要死记硬背
    }


    /*public static void main(String[] args) throws IOException {
        InputStream is = System.in;
        StringBuilder sb = new StringBuilder();
        int ch;
        while(true){

            ch = is.read();
            if(ch == '\r')
                continue;
            if(ch == '\n') {
                if ("over".equals(sb.toString()))
                    break;
                else{
                    System.out.println(sb.toString());
//                    sb = new StringBuilder(); // 这样对象太多了
                    sb.delete(0,sb.length()); // 标准清空。把缓冲器清空就可以了。
                }
            }else{
                sb.append((char)ch);
            }
        }
    }*/

    // 键盘录入一行数据并打印其大写，其实就是读一行的要素
    // readLine方法
    // 读入转换流
    // 字节流转化成字符流，然后用字符流缓冲区的readLine方法


    // p246
//    @Test
//    public void testInputTransferStream()
    public void testInputTransferStream() throws IOException{
/*        InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*OutputStream os = System.out;
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);*/
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String l = null;
        while((l = br.readLine()) !=null){
            if("over".equals(l))break;
//            System.out.println(l.toString());
            bw.write(l);
            bw.newLine(); // 跨平台
            bw.flush(); // 不flush不会出来的


        }
        // 比其他简单的多。
    }


    // 247:找到关键的地方，而不是补全（细节）
    //
    @Test
    public void testInToFile() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("system-in-to-file.txt")));
        String line;
        while((line = br.readLine())!= null){
            if("over".equals(line))
                break;
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        br.close();
        bw.close();

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("fos.txt")));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        while((line = br.readLine())!= null){
            if("over".equals(line))
                break;
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        br.close();
        bw.close();

    }

}


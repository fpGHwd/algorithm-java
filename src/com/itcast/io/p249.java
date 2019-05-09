/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/8/19
 * @Time:       9:33 PM
 * @Project:    algorithm
 */

package com.itcast.io;

import java.io.*;

public class p249 {

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("algorithm.iml"));
        System.setOut(new PrintStream("algorithm-out.iml"));

        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = null;

        while((line = bufr.readLine())!=null){
            if("over".equals(line))
                break;
            bufw.write(line.toUpperCase());
            bufw.newLine();
            bufw.flush();
        }

        bufr.close();
        bufw.close();
    }
}

package com.itcast.regex;

import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p323_1 {
    /**
     * 获取邮箱
     */

    public static void main(String[] args)  {

    }

    @Test
    public void getMailsFormFile() throws IOException {

        BufferedReader bufr = new BufferedReader(new FileReader("res/mail.txt"));

        String line;

        while((line = bufr.readLine())!=null){
            Pattern p = Pattern.compile("\\w+@\\w+(\\.\\w+)+");
            Matcher m = p.matcher(line);
            while(m.find()){
                System.out.println(m.group());
            }
        }

        bufr.close();
    }
    /**
     * abc123@gmail.com
     * abc123@gmail.com
     * abc123@gmail.com
     * abc123@gmail.com
     * abc123@gmail.com
     * abc123@gmail.com
     * abc123@gmail.com
     * abc123@whu.edu.cn
     * abc123@gmail.com
     * abc123@gmail.com
     * abc123@gmail.com
     * abcwe123@gmail.com
     * abc123we@gmail.com
     * ab123c123@gmail.com
     */


    @Test
    public void getMailsFormWebPage() throws IOException {
        URL url = new URL("https://suzumi1a.github.io/about/");
        URLConnection urlc = url.openConnection();
        BufferedReader bufr = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
        // 这一部比较关键

        String line;

        while((line = bufr.readLine())!=null){
            Pattern p = Pattern.compile("\\w+@\\w+(\\.[\\w&&[^\\d]]+)+");
            Matcher m = p.matcher(line);
            while(m.find()){
                System.out.println(m.group());
            }
        }

        bufr.close();
    }
    /**
     * \w+@\w+(\.\w+)+
     *
     * html5shiv@3.7.3
     * js@1.4.2
     * 284320213@qq.com
     *
     *
     * \w+@\w+(\.[\w&&[^\d]]+)+
     * 284320213@qq.com
     *
     * // 核心是表达方法
     */
}

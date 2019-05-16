/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/16/19
 * @Time:       11:02 PM
 * @Project:    algorithm
 */

package com.itcast.regex;

import org.junit.Test;

import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p322 {

    /**
     * ip地址进行地址段的排序（A,B,C,D,E）
     *
     * 192.68.1.254 102.49.23.013 10.10.10.10 2.2.2.2 8.109.90.30
     *
     * A 1-126.0.0.0
     * B 128.1-191.255
     * C 192.0.1-223.255.255
     */

    @Test
    public void test(){
        String ips = "192.68.1.254 102.49.23.013 10.10.10.10 2.2.2.2 8.109.90.30";
        String reg_ip = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";

//        Pattern p =  Pattern.compile(reg_ip);
//        Matcher m = p.matcher(ips);
//        while(m.find()){
//            System.out.println(m.group());
//        }
        /**
         * 192.68.1.254
         * 102.49.23.013
         * 10.10.10.10
         * 2.2.2.2
         * 8.109.90.30
         */


        String reg_add0 = "(\\d{1,3})";
        ips = ips.replaceAll(reg_add0, "00$1");
        System.out.println(ips);

        String reg_trim3 = "0+(\\d{3})";
        ips = ips.replaceAll(reg_trim3,"$1");
        System.out.println(ips);

        String[] ips_s =  ips.split(" ");
        TreeSet<String> ts = new TreeSet<>();
        for(String s:ips_s){
            ts.add(s);
        }
        for(String s:ts){
            System.out.println(s.replaceAll("0+(\\d+)", "$1"));
            /**
             * 2.2.2.2
             * 8.19.90.30
             * 10.10.10.10
             * 12.49.23.13
             * 192.68.1.254
             */
        }

//        Pattern
    }

    @Test // 必须要掌握，对邮件地址进行校验。
    public void testCheckMail(){
        String mail = "abc12@sina.com";
        String mail2 = "abc12@sina.com.cn";
//        String reg_mail = "\\b\\w+@\\w+\\.\\w+\\b"; // 下划线
        String reg_mail = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+\\.[a-zA-Z]+"; // 封装组重用。
        String reg_mail2 = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+){1,2}"; // mai2 匹配 reg_mail2 可以
        // \w	A word character: [a-zA-Z_0-9]

        System.out.println(mail2.matches(reg_mail2)); // 验证匹配方法
    }
}

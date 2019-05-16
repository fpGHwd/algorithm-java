/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/16/19
 * @Time:       10:47 PM
 * @Project:    algorithm
 */

package com.itcast.regex;

import org.junit.Test;

public class p321 {


    /**
     * 需求：
     * 将下列字符串转成： 我要学编程。
     *
     */

    @Test
    public void test_1(){
        String str = "我我...我我...我要..要要...要要..." +
                "学学学...学学...编编编...编程..程.程程...程...程";
        // 磕巴
        String reg1 = "\\.+";
        str = str.replaceAll(reg1,"");
        System.out.println(str);
//        String reg2 = "(\\W)\\1+"; // 汉字是\\\W，这是我写的
         String reg2 = "(.)\\1+"; // 这是老师的答案
        str = str.replaceAll(reg2, "$1");
        System.out.println(str);

        /**
         * 我我我我我要要要要要学学学学学编编编编程程程程程程
         * 我要学编程
         */

        //正则的力量很爽啊。
        // 说起来之前自己的自己看了这么久也才学点皮毛。看视频是真的不错。。所以视频是20%的时间解决80%的问题。
        // 而自己看是80%的时间解决20%的问题。
        // 问问自己处在那个阶段。如果指向解决80%的问题，那么就看视频类就可以了。
        // 其实很多情况只需解决80%的问题就醒了。不要成为20%的奴隶。

    }



}

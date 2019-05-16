/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/16/19
 * @Time:       7:29 PM
 * @Project:    algorithm
 */

package com.itcast.regex;

/**
 * 能否理解一个东西的判断方法和标准是是不是数字化和代码化。。。哈哈哈，就是这么暴力。
 *
 * 数字化为所有东西相互的联系预备了认知的条件。
 * 谁说要上升到数字上面来着？认识才是进步了。
 */

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * 用于Java web中标签的判断。。。原来如此。
 * web技术的解析建立在正则表达式之上啊。
 *
 * 这种包含的关系用数学都能解释。
 *
 * 比如你可以理解为正则表达式类型就是不同的函数，把函数这一个东西抽象出来楽
 * 很奇怪的，为什么没有更早一点坚持这一个原则呢。
 */

public class p317 {
    /**
     * 具体的操作功能
     */

    /**
     *
     *
     * 集合[]
     * 运算 &&（两个集合的且，并形成一个大集合） ||（没有显式，排列在一起即可） ^(非)
     *
     * 任何字符      .
     * 数字字符     \d
     * 非数字      \D
     * 空白        \s
     * 非空白      \S
     * 单词       \w          邮箱
     * 非单词      \W
     *
     * 重复次数     {m}
     * 一次或没有    ?
     * 零次或者多次   *
     * 一次或多次    +
     */



    @Test
    public void test(){
        Pattern p = Pattern.compile("[0-9]");
        System.out.println("\\0x0b"); // 垂直制表符号。
        System.out.println((char)11);
    }

    @Test
    public void test1(){

        // ?


        // ?
        String str = "b23a";
        String reg= "[a-zA-Z]\\d?";

        System.out.println(str.matches(reg)); // false
        // ?
        String str1 = "b23";
        String reg1= "[a-zA-Z]\\d?";
        System.out.println(str1.matches(reg1)); // false

        // ?
        String str3 = "b2";
        String str4 = "b";
        String reg3= "[a-zA-Z]\\d?";
        System.out.println(str3.matches(reg3)); // true
        System.out.println(str4.matches(reg3)); // true

        // \w
        String str5 = "b2";
        String str6 = "b";
        String str7 = "b2";
        String str8 = "b";
        String reg4= "\\w\\d?";
        System.out.println(str5.matches(reg4)); // true
        System.out.println(str6.matches(reg4)); // true

        String reg5 = "\\w\\d?";
        System.out.println(str5.matches(reg5)); // true
        System.out.println(str6.matches(reg5)); // true


        System.out.println("判断qq");
        String reg6_1 = "[\\d&&^0]\\d{4,14}"; // 5~15位的qq号
        /**
         * 判断qq
         * true
         * false
         * false
         * false
         * false
         */
        String reg6 = "[1-9]\\d{4,14}"; // 这个没有问题
        /**
         判断qq
         false
         false
         false
         false
         true
         */
        String qq1 = "0123456";
        String qq2 = "1234531231233123";
        String qq3 = "123a4324";
        String qq3_1 = "1234";
        String qq4 = "284320213";
        System.out.println(qq1.matches(reg6));
        System.out.println(qq2.matches(reg6));
        System.out.println(qq3.matches(reg6));
        System.out.println(qq3_1.matches(reg6));
        System.out.println(qq4.matches(reg6));


        System.out.println("检查手机号");
        String tel = "1384732874r";
        String tel1 = "12343243445";
        String tel2 = "138a8747823";
        String tel3 = "18682111035";
        String tel4 = "15972073235";
        String tel5 = "+17015660338";
        String phone_num_reg = "1[358]\\d{9}";
        System.out.println(tel.matches(phone_num_reg));
        System.out.println(tel1.matches(phone_num_reg));
        System.out.println(tel2.matches(phone_num_reg));
        System.out.println(tel3.matches(phone_num_reg));
        System.out.println(tel4.matches(phone_num_reg));
        System.out.println(tel5.matches(phone_num_reg)); // false 出国吧，不是中国号
        /**
         * 检查手机号
         * false
         * false
         * false
         * true
         * true
         */


        /**
         * Greedy       贪心
         * Reluctant    不情愿 - 非贪心
//         * Possessive   todo:这个是什么。
//         */

        // 如果说web建立载正则表达式之上，那么这里的todo的一些东西也很有用。机器学习的识别分词法，也可能是其中的一种表达吧。
    }


}

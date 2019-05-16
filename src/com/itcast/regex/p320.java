/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/16/19
 * @Time:       10:00 PM
 * @Project:    algorithm
 */

package com.itcast.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p320 {
    /**
     * 正则表达式的第四个功能：获取
     *
     * 按照规则把符合规则的子串取出来
     * 这个好像也比较重要。
     *
     * 1.先把正则表达式封装成对象
     * 2.把字符串和正则表达式关联
     * 3.获取正则表达式引擎
     * 4.把符合要求的子串取出。
     *
     * 也就是Pattern的作用
     *
     */

    @Test
    public void testGetSubStr(){
        String test = "ming tian jiu yao fang jia le, da jia";
        String reg = "\\b\\w{3}\\b";

        Pattern p = Pattern.compile(reg); // 封装成对象：为什么，要做复杂的操作
        // 让正则对象和要作用的字符串相关联
        Matcher m  = p.matcher(test);
        System.out.println(m.matches()); // java.util.regex.Matcher[pattern=\w{3} region=0,37 lastmatch=]

        /**
         * Attempts to match the entire region against the pattern.
         * If the match succeeds then more information can be obtained via the start, end, and group methods.
         *
         * Returns:
         * true if, and only if, the entire region sequence matches this matcher's pattern
         */


//        boolean b = m.find();
//        System.out.println(b);
//        System.out.println(m.group());
//        boolean b1 = m.find();
//        System.out.println(b1);
//        System.out.println(m.group());
        // 类似于迭代器，用while改写
        while(m.find()){
            System.out.println(m.group());
        }
        /**
         * jiu
         * yao
         * jia
         * jia
         */

        // 单词边界
        // \\b

        // 注意matches的行为特征。有点搞笑。是匹配整个字符串，还会影响指针




    }
}

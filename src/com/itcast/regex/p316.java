package com.itcast.regex;

import org.junit.Test;

import java.io.IOException;
import java.util.regex.Pattern;

public class p316 {
    /**
     * 核心的东西抽象，亚索的，集成的，数字类型的，然后延伸连接就行了。
     */

    /**
     * 正则表达式：符合一定规则的表达式
     * 操作字符串
     *
     * java自带的STring操作起来太简单
     */

    public static void main(String[] args){
        System.out.println("hello world");
    }

    /**
     * 对qq号码进行校验：5～15位数字，就是把文字的离散信息，变成代码类的东西。可以理解成为数字的一种中间形式。
     * 其实所有的东西可以转化成代码，也可以是数字。但是代码可以理解成为数字和不整齐东西的一种中间形式。
     * 数字化，伪代码化，代码化。
     * 不能纳入数字体系和为代码体系，还有代码体系的东西。只能用更多文字去写清楚。
     * 没有什么特别的。会浪费你更多的时间和空间。
     */

    @Test
    public void testRegexDemo() throws IOException {
        Pattern p = Pattern.compile("^[1-9][0-9]{4,9}");
        String s1= "013213";
        String s2 = "12321312323";
        String s3 = "1233";
        String s4= "284320213";
        String s5= "1000012312";
        String s6= "100001";
        String s7 = "123123a32";

        System.out.println(s1.matches("^[1-9][0-9]{4,9}"));
        System.out.println(s2.matches("^[1-9][0-9]{4,9}"));
        System.out.println(s3.matches("^[1-9][0-9]{4,9}"));
        System.out.println(s4.matches("^[1-9][0-9]{4,9}"));
        System.out.println(s5.matches("^[1-9][0-9]{4,9}"));
        System.out.println(s6.matches("^[1-9][0-9]{4,9}"));
        System.out.println(s7.matches("^[1-9][0-9]{4,9}"));

        /**
         * false
         * false
         * false
         * true
         * true
         * true
         * false
         *
         * 可以节省很多代码，这就是类似数字的力量。。。。
         * 学习和使用数字可以让你获得强大的力量
         * 应该说不是C++很强，而是逻辑和数字的力量太过强大。也可以说文字和字母很强大。
         */

    }


}

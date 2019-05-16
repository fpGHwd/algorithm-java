/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/16/19
 * @Time:       8:48 PM
 * @Project:    algorithm
 */

package com.itcast.regex;

import org.junit.Test;

public class p318 {
    /**
     * 如果只是自己原来的理解，可能想不到还有切割的功能。
     * 只是以为正则表达式的功能是判别字符串。
     *
     * 当然切割功能其实比较容易想到。
     * 看视频是让你能够往这方面想。不联系外界是不行的。
     * 你要有自己特别的东西，也要积极联系外界。
     */

    /**
     * 正则表达式的切割功能
     * String 的 split函数的切割功能。
     * 其实string和regex的关系很紧密，因为它们经常用到一起啊。
     * 如何去理解这种紧密性是最重要的？？？如何理解呢
     */

    /**
     * 当然上面的匹配演示和这里的切割关系更紧密也是容易想到的
     */

    @Test
    public void testSplit(){
//        String str = "zhangsan,lisi,wangwu,zhaoliu";
//        String splitReg = ",";
        /**
         * zhangsan
         * lisi
         * wangwu
         * zhaoliu
         */

//        String str = "zhangsan,lisi wangwu zhaoliu";
//        String splitReg = "[,\\s]";
        /**
         * zhangsan
         * lisi
         * wangwu
         * zhaoliu
         */

//        String str = "zhangsan,,lisi  ,wangwu  ,  zhaoliu";
//        String splitReg = "[,\\s]+";
        /**
         * zhangsan
         * lisi
         * wangwu
         * zhaoliu
         */

        /**
         * 有些东西不能太过细节 。
         * 好的老师讲的东西一定是重要的概率性和可能性比较高
         */

//        String str = "zhangsan,,lisi  ,wangwu  ,  zhaoliu";
//        String splitReg = "[,\\s]+";
//        String reg = "\\."; // 用点切的表达式。

        /**
         * 正则表达式也意味着找到关键的东西。意味着搜索
         */


//        String str = "c:\\abc\\a.txt";
//        String splitReg = "\\\\";
        /**
         * c:
         * abc
         * a.txt
         */

        /**
         *
         * String splitReg = "\\{2}";
         * c:\abc\a.txt
         */


        String str = "erkktyqquizzzzzok";
        String splitReg = "(\\w)\\1"; // 怎么按叠词切呢
        String splitReg1 = "(.)\\1+";
        /**
         * 所以我想到了为什么看视频
         * 那就是，复杂度的一种体现。外界的复杂度。
         * 也是代表一种目标吧。外界本身就是一种目标
         *
         * 图书馆来多了，阈值也增强了。可能是弥补小时候少这种面对人的经历吧。
         */
        /**
         * 正则表达式概念的组：很吊的概念。。。确实吊啊
         *
         * ((())())
         * 几组：有几个左括号
         * 第几个左括号就是第几组
         * 组零始终表达着整个表达式
         *
         */

        /**
         * 字符串的运算，正则表达式。。。意义简直和数字的运算同样重大啊
         *
         * 理解重要的关键而不是细节的概念。
         * 细节的东西要往重要的核心的极少数的时空上靠近去理解。
         */

        /**
         * 可以完全胡略老师用文字将给其他人听。
         */

        /**
         * 结果：
         * er
         * ty
         * ui
         * ok
         */


        // https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
        // 里面有分组的概念
        // Groups and capturing
        // 21分钟38秒此处有毕老师魔性笑声。。。

        // 符号越多，正则越长，阅读性越差 // 好处是简化操作。别人写个正则你看不懂。

        // 正则就是识别和操作字符串

        String[] ret = str.split(splitReg1);

        for(String s: ret){
            System.out.println(s);
        }



    }
}

/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/16/19
 * @Time:       9:31 PM
 * @Project:    algorithm
 */

package com.itcast.regex;

import org.junit.Test;

public class p319 {
    /**
     * 替换，仍然是和搜索一样的东西
     */

    @Test
    public void test(){
        String str = "wer15343ufdau94232fsd347hgj4328asf94444arew8644444444447rweaf"; // 数字替换成#符号
        String reg = "\\d{5,}"; // 除开数量次描述，连续超过5次的替换成#号
//        str = str.replaceAll(reg, "#");
//        System.out.println(str);
        // wer#ufdau#fsd347hgj4328asf#arew##447rweaf // 后一部分是错误的
        // 添加一个逗号"\\d{5,}"
        System.out.println(str.replaceAll(reg, "#"));
        // wer#ufdau#fsd347hgj4328asf#arew#rweaf


        String str1 = "abcdfsdifkkkkksdfishsshfdsuhfsudukrhhrhhrhhrhhhhhkkkkkkianzxhjhfdsjk";
        String reg2 = "(\\w)\\1+";
//        System.out.println(str1.replaceAll(reg2,"#"));
        // abcdfsdif#sdfish#hfdsuhfsudukr#r#r#r##ianzxhjhfdsjk
        // 完全OK，还是TM看视频学得快，自己看找不到重点（当然是细节深入不够），当然有人带你更容易深入一些是真的。不管什么方面。
        // 替换成$符号为什么错误呢
        System.out.println(str1.replaceAll(reg2,"#")); // 当替换的是$时，会报错:Illegal group



        // 将重叠的字母替换成单个的字母。。。这个又有点厉害了。
        String str2 = "abcdfsdifkkkkksdfishsshfdsuhfsudukrhhrhhrhhrhhhhhkkkkkkianzxhjhfdsjk";
        String reg3 = "(\\w)\\1+";
        System.out.println(str2.replaceAll(reg3,"$1")); // 如何引用组里的内容。。。这个沟通有点厉害的。
        /**
         * result
         * abcdfsdifksdfishshfdsuhfsudukrhrhrhrhkianzxhjhfdsjk
         */

        // 原来如此
        // 拿前面的规则中的第一个组
        // 前面只写一个$符号时，默认取0组，整个字符串。


    }
}

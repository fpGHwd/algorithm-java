/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       19-5-11
 * @Time:       上午10:03
 * @Project:    algorithm
 */

package com.itcast.string;

import org.junit.Test;

class StringMethodDemo{


}

public class p159 {
    @Test
    public void method_sub(){
        String s = "abcdef";
        System.out.println(s.substring(2));
        System.out.println(s.substring(2,4));
    }

    @Test
    public void method_split(){

    }

    @Test
    public void testUpperAndLowerCase(){
        String s = "   Hello Java";
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());
        System.out.println(s.trim());
        /**
         * trim
         *
         * returns a string whose value is this string
         * with any leading and trailing whitespace
         * removed
         */
    }

    @Test
    public void testCompare(){
        String s1 = "aaa";
        String s2 = "abc";
        System.out.println(s1.compareTo(s2)); // -1，字典徐 s1在s2之前
        System.out.println(s2.compareTo(s1)); // 1， 字典序 s2载s1之后

        String s3 = "acc"; // 49+ 48  = 97
        String s4 = "aaa";

        System.out.println(s3.compareTo(s4)); // 2
        /**
         * doc says this.charAt(k)-anotherString.charAt(k)
         * 知道不是最要紧的，如何知道和如何理解，数字化和序列化让你能看到更多
         *
         */

        String s5 = "a1c"; // 49+ 48  = 97
        String s6 = "aaa";
        System.out.println(s5.compareTo(s6)); // -48
        // todo 49+48这个原因只能从前面的视频中知道
    }
}

/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       19-5-11
 * @Time:       上午10:22
 * @Project:    algorithm
 */

package com.itcast.string;

// 字符串练习

import org.junit.Test;

public class p160 {
    // 获取子串

    public static void sop(String s){
        System.out.println(s);
    }

    /**
     * 字符串转数组
     * 数组reverse
     * 数组再转化成字符串
     *
     * 功能分开写，改起来很方便
     *
     * @param str
     * @return
     */
    public static String myTrim(String str){
        int start =0, end = str.length()-1;
        while(start < end && str.charAt(start) == ' '){
            start++;
        }

        while(start < end && str.charAt(end) == ' ')end--;

        return str.substring(start, end);
    }

    @Test
    public void testSubString(){
        String strToBeTrimed = "  Hello MyTrim   ";
        sop(strToBeTrimed);
        sop(myTrim(strToBeTrimed)); // OK.
        // 必须不借助IDE能手写，才有开发经验就
    }
}

/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/18/19
 * @Time:       10:52 AM
 * @Project:    algorithm
 */

package com.leetcode;

import org.junit.Test;

public class p008 {

    public int myAtoi(String str) {
//        String str1 = str.replaceAll("\\s+", ""); // +0 123 -> 0
        String str1 = str;
        if (str1.length() == 0) return 0;
        int i =0;
        char ch = str.charAt(i);
//        while(Character.isAlphabetic(ch)){
//            ++i;
//            if(i >= str1.length())
//                return 0;
//            else
//                ch = str1.charAt(i);
//        }
        while(i< str1.length() && ((ch = str1.charAt(i))==' ')){
            i++;
        }
        if(i >= str1.length())return 0;
        boolean n= true;
        if(ch == '-'){n = false;i++;}
        if(ch == '+'){n = true;i++;}

        if(i >= str1.length())return 0;
        ch = str1.charAt(i);
        if(!Character.isDigit(ch))return 0;
        int ret = 0;
        for(int j = i; j < str1.length() && Character.isDigit(str1.charAt(j)); j++){
            if((ret > Integer.MAX_VALUE/10) || (ret == Integer.MAX_VALUE/10 && str1.charAt(j)-'0' > 7)){
                if(n)return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            ret = ret*10 + (str1.charAt(j)-'0'); // 会有一次运算发生溢出 //
        }
        return n?ret:-ret;

    }

    @Test
    public void test() {
        System.out.println(myAtoi("  -34 23"));
        System.out.println(myAtoi("-6147483648"));  // 优雅如果不能抽象，那只能成为浪费时间的代名词
        System.out.println(myAtoi("   -42"));
    }

//    执行用时 : 8 ms, 在String to Integer (atoi)的Java提交中击败了88.50% 的用户
//    内存消耗 : 35 MB, 在String to Integer (atoi)的Java提交中击败了95.23% 的用户
}

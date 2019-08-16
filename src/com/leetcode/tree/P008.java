/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/16/19 3:50 PM
 */

package com.leetcode.tree;

public class P008 {
    public static int myAtoi(String str) {
        int idx = 0, len = str.length();
        if(len == 0)return 0;
        while(idx < len && str.charAt(idx)== ' ')idx++;
        if(idx < len && Character.isLetter(str.charAt(idx)))return 0;
        boolean negative = false;
        if(idx < len && (str.charAt(idx) == '-' || str.charAt(idx) == '+')){
            if(str.charAt(idx) == '-')negative = true;
            idx++;
        }

        long result = 0;
        if(idx < len && Character.isDigit(str.charAt(idx))){
            char c;
            while( idx < len && Character.isDigit(c = str.charAt(idx))){
                result = result * 10 + (c - '0');
                // 判断整数的乘法的溢出（溢出因素） // 要溢出和阶段，不可预知，用long代价
                if((int)result != result)
                    return negative?(Integer.MIN_VALUE):Integer.MAX_VALUE;
                idx++;
            }
            return (int)result * (negative?-1:1);
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        String str = "-4193 with words", str1 = "+",str2=
                "-6147483648",str3 =
                "2147483646";
//        System.out.println(myAtoi(str));
//        System.out.println(myAtoi(str1));
        System.out.println(myAtoi(str3));
    }
}

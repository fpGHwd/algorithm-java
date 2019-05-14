/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/6/19
 * @Time:       9:27 PM
 * @Project:    algorithm
 */

package com.leetcode;


import java.util.ArrayList;
import java.util.Arrays;

public class P043 {

    public static String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2))return "0";
        int len1 = num1.length(), len2 = num2.length();
        char[] ca = new char[len1+len2];
        int carry = 0;
        for(int i = 1; i<= len1+len2-1; i++){
            int n = carry;
            for(int j = 1;j<=len1;j++){
                if(i+1-j < 1 || i+1-j > len2)continue;
                int n1 = len1-j, n2 = (len2-1) - (i-j);
                n += (num1.charAt(n1) - '0')*(num2.charAt(n2) -'0');
            }
            carry = n/10;
            ca[i-1] = (char)(n%10 + '0');
        }
        int len = len1+len2-1;
        if(carry!=0){
            ca[len1+len2-1] = (char)(carry+'0');
            len++;
        }
        StringBuilder sb = new StringBuilder();
        while(len>0){
            sb.append(ca[len-1]);
            len--;
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String s1 = "25", s2 = "30";
        System.out.println(multiply(s1,s2));
    }
}

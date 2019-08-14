/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/13/19 5:02 PM
 */

package com.leetcode;

public class P038 {
    public static String countAndSay(int n) {
        if(n == 1)return "1";
        else{
            String up = countAndSay(n-1);
            int len = up.length();
            char now = up.charAt(0);
            int prefix = 0;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < len; i++){
                if(up.charAt(i) == now){
                    prefix++;
                }else{
                    sb.append(prefix);
                    sb.append(now);
                    now = up.charAt(i);
                    prefix = 1;
                }
            }
            sb.append(prefix);
            sb.append(String.valueOf(now));
            return sb.toString();
        }
    }


    public static void main(String[] args) {
        System.out.println(countAndSay(4));
        System.out.println( Integer.MIN_VALUE);
    }
}

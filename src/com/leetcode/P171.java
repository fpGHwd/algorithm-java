/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/16/19 2:49 PM
 */

package com.leetcode;

public class P171 {
    public static int titleToNumber(String s) {

        int len = s.length(), result = 0;
        for(int i = 0; i< len; i++){
            result =  result * 26 + (s.charAt(i) - 'A' + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        String str ="ZY";
        System.out.println(titleToNumber(str));
//        System.out.print(1);System.out.print(2);
    }
}

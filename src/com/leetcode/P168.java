/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/16/19 2:29 PM
 */

package com.leetcode;

public class P168 {

    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.insert(0, (char)('A'+(n-1)%26));
            n = (n-1)/26;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }
}

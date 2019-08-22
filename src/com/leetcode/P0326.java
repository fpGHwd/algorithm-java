/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/22/19 4:34 PM
 */

package com.leetcode;

public class P0326 {
    public boolean isPowerOfThree(int n) {
        if(n <= 0)return false;
        return 1162261467%n == 0;
    }

    public static void main(String[] args) {

        System.out.println("hello gjfdijfdif");

        System.out.println(new P0326().isPowerOfThree(0));

        int i = 1;
        while(i*3 > i){
            i *= 3;
        }
        System.out.println(i);

        System.out.println(Math.sqrt((double)Integer.MAX_VALUE));
    }
}

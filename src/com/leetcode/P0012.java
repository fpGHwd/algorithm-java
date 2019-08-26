/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/24/19 7:20 PM
 */

package com.leetcode;

public class P0012 {
    public String intToRoman(int num) {
        StringBuilder sb =new StringBuilder();
            String[] strs = {"M", "CM", "D","DC","C", "XC", "L","LX", "X","IX", "V","IV", "I"};
            int[] nums = {1000, 900, 500,400,100,90,50,40,10,9, 5,4,1};

        for(int i = 0; i<nums.length && num > 0 ; i++){
            while(num >= nums[i]){
                sb.append(strs[i]);
                num -= nums[i];
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new P0012().intToRoman(4));
    }
}

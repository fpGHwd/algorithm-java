/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/15/19 9:45 PM
 */

package com.leetcode;

public class p136 {
    public static int singleNumber(int[] nums) {
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            result = result ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {4,1,2,1,2};
//        System.out.println(2 ^ 3 ^ 2);
        System.out.println(singleNumber(arr));
    }
}

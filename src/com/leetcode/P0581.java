/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/17/19 10:40 AM
 */

package com.leetcode;

import java.util.Arrays;

public class P0581 {

    public int findUnsortedSubarray(int[] nums){
        int copy[] = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int left = nums.length-1, right = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != copy[i]){
                left = Math.min(i,left);
                right = Math.max(i, right);
            }
        }
        return (right > left )? (right -left + 1): 0;
    }

    public static void main(String[] args) {
        int arr[] = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(new P0581().findUnsortedSubarray(arr));
    }
}

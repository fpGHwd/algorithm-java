/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/23/19 11:20 AM
 */

package com.leetcode;

import java.util.Arrays;

public class P0645 {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int result[] = new int[2];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(i != 0 && nums[i] == nums[i-1]){
                result[0] = nums[i];
            }
            sum+= nums[i];
        }
        result[1] = (nums.length + 1) * nums.length /2 -(sum- result[0]);
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {1,5,3,2,2,7,6,4,8,9};
        int nums1[] = {2,2};
        int nums2[] = {3,2,3,4,6,5};
        System.out.println(new P0645().findErrorNums(nums));
        System.out.println(new P0645().findErrorNums(nums1))
        ;
        System.out.println(new P0645().findErrorNums(nums2));
    }
}

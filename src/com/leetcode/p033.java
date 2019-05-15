/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/15/19
 * @Time:       7:03 PM
 * @Project:    algorithm
 */

package com.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class p033 {
    public int search(int[] nums, int target) {
        if(nums.length == 0)return -1;
        if(nums.length == 1){
            if(nums[0] != target)return -1;
            else
                return 0;
        }
        int max = 0;
        while(max+1 < nums.length && nums[max+1] > nums[max])max++;
        if(max+1 == nums.length) {
            int num0 = Arrays.binarySearch(nums, 0, nums.length, target);
            if(num0 <0)return -1;
            else return num0;
        }
        if (target >= nums[max+1] && target <= nums[max]) {
            if(target >= nums[0]){
                int num2 = Arrays.binarySearch(nums, 0, max + 1, target);
                if(num2 < 0)return -1;
                else return num2;
            }else{
                int num1 =  Arrays.binarySearch(nums, max+1, nums.length, target);
                if(num1 < 0)return -1;
                else return num1;
            }

        }else{
            return -1;
        }
    }

    @Test
    public void test() {
        // nums = [4,5,6,7,0,1,2], target = 0
//        int nums[] = {4, 5, 6, 7, 0, 1, 2}, target = 0;
//        int nums[] = {1,3}, target = 1;
        int nums[] = {3,5,1}, target = 3;
        System.out.println(search(nums, target));
    }


//    执行用时 : 2 ms, 在Search in Rotated Sorted Array的Java提交中击败了93.04% 的用户
//    内存消耗 : 35.2 MB, 在Search in Rotated Sorted Array的Java提交中击败了89.67% 的用户
}

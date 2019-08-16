/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/16/19 2:41 PM
 */

package com.leetcode;

public class P169 {

    // 摩尔投票法

    public static int majorityElement(int[] nums) {
        int candidate = nums[0],count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == candidate){
                count++;
            }else{
                if(count == 0){
                    candidate = nums[i];
                    count = 1;
                }else{
                    count--;
                }
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        int arr1[] = {3,2,3}, arr2[] = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr1));
        System.out.println(majorityElement(arr2));
    }
}

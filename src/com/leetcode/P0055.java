/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/16/19 6:51 PM
 */

package com.leetcode;

public class P0055 {
    public static boolean canJump(int[] nums) {
        if(nums.length == 1)return true;
        int max = 0;
        for(int i = 0; i < nums.length-1; i++){
            if(max < i){
                return false;
            } else{
                if(i + nums[i] > max)max = i+nums[i];
                if(i+nums[i] >= nums.length-1)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[] = {0,2,3};
        System.out.println(canJump(nums));
    }
}

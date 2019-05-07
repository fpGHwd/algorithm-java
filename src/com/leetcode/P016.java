/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/6/19
 * @Time:       9:07 PM
 * @Project:    algorithm
 */

package com.leetcode;

import java.util.Arrays;

public class P016 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length-2; i++){
            int l = i +1, r = nums.length-1;
            while(l < r){
                int s = nums[i] + nums[l] + nums[r];
                if(Math.abs(s - target) < Math.abs(closest - target)){
                    closest = s;
                }
                if(s > target){
                    r--;
                }else if(s < target){
                    l++;
                }else{
                    return target; // return s;
                }
            }
        }
        return closest;
    }
}

// 和找给定的数的相同的数并没有什么特别大的区别。
// 双指针和单指针也没有什么区别。。。双指针和排序往往会结合起来。

// 有趣的东西
// 没有循环是不会讨论时空复杂度的。只有O(1)时间复杂度和O(1)的空间复杂度。
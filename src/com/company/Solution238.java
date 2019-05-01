/**
 * @author suzumiya
 * @data 5/2/19 12:34 AM
 */

package com.company;

import java.util.ArrayList;

public class Solution238 {
    public static int[] productExceptSelf(int[] nums) {
        if(nums.length == 2){
            return new int[]{nums[1], nums[0]};
        }

        int mul = 1;
        for(int i = 0; i<nums.length; i++){
            mul *= nums[i];
        }
        int[] ret = new int[nums.length];
        if(mul ==0){
            int countZero = 0, idx = 0;
            for(int i =0; i<nums.length; i++){
                if(nums[i] == 0){
                    countZero++;
                    idx = i;
                }
            }
            mul = 1;
            for(int i = 0; i<ret.length; i++){
                ret[i] =0;
                if(i != idx)mul *= nums[i];
            }
            if(countZero ==1)ret[idx] = mul;
            return ret;

        }

        for(int i = 0; i< nums.length; i++){
            ret[i] = mul/nums[i];
        }
        return ret;
    }

    public static void main(String[] args){
//        int[] input = {1,2,3,4};
        int[] input = {9,0,-2};
        int[] ret = Solution238.productExceptSelf(input);
        System.out.println();
    }
}

// 竟然没有乘法溢出

//执行用时 : 3 ms, 在Product of Array Except Self的Java提交中击败了75.04% 的用户
//        内存消耗 : 51.1 MB, 在Product of Array Except Self的Java提交中击败了23.92% 的用户
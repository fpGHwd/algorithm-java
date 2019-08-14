/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/13/19 5:21 PM
 */

package com.leetcode;

public class P053 {
    public static int maxSubArray(int[] nums) {
        /**
         * f(i) = a[i], f(i-1)<0; else f(i) = f(i-1) + a[i]
         */
        int[] f = new int[nums.length];
        f[0] = nums[0];
        int max = f[0];
        for(int i = 1; i < nums.length; i++){
            if(f[i-1] <0){
                f[i] = nums[i];
            }else{
                f[i] = f[i-1] + nums[i];
            }
            if(f[i] > max){
                max = f[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(A));
    }
}
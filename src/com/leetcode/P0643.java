/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/18/19 3:42 PM
 */

package com.leetcode;

public class P0643 {
    public double findMaxAverage(int[] nums, int k) {
        if( k == 0)return 0;
        double max, sum = 0;
        for(int i = 0; i < k; i++){
            sum+= nums[i];
        }
        max = sum/k;

        for(int i = 1; i <= nums.length - k; i++){
            sum = 0;
            for(int j = 0; j < k; j++){
                sum += nums[i + j];
            }
            if(sum/k >= max)max = sum/k;
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] = {0,1,1,3,3}, k = 4;
        System.out.println(new P0643().findMaxAverage(nums,k));
    }
}

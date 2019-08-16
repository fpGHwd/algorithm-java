/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/16/19 9:09 PM
 */

package com.leetcode;

import java.util.Arrays;

public class P0532 {

    public int findPairs(int[] nums, int k) {
        if(nums.length == 1 || nums.length == 0 || k < 0)return 0;
        Arrays.sort(nums);
        int low = 0, high = low+1, count = 0;
        while( low < nums.length && high < nums.length){
            if(nums[high] - nums[low] > k){
                do{
                    low++;
                }while(low < nums.length && nums[low] == nums[low-1]);
                high = low+1;
            }else if(nums[high] - nums[low] == k){
                count++;
                do{
                    low++;
                }while(low < nums.length && nums[low] == nums[low-1]);
                high = low+1;
            }else{ // nums[high] -nums[low] < k
                // low
                do {
                    high++;
                }while(high < nums.length && nums[high] == nums[high -1]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5}, k =1;
        int nums1[] = {3, 1, 4, 1, 5}, k1 =2;
        int nums2[] = {1, 3, 1, 5, 4}, k2= 0;
        P0532 p0532 = new P0532();
        System.out.println(p0532.findPairs(nums, k));
        System.out.println(p0532.findPairs(nums1, k1));
        System.out.println(p0532.findPairs(nums2,k2));

        int arr[][] = new int[3][4];
    }
}

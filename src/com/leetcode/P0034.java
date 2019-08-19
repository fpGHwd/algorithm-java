/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/18/19 1:28 PM
 */

package com.leetcode;

public class P0034 {
    public int[] searchRange(int[] nums, int target) {
        int res[] = new int[2];
        res[0] = -1; res[1] = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                res[0] = (res[0]==-1)?i:(Math.min(i,res[0]));
                res[1] = (res[1]==-1)?i:(Math.max(i,res[1]));
            }
        }
        return res;
    }

    public int[] searchRange1(int[] nums, int target){
        int res[] = new int[2];
        res[0] = -1; res[1] = -1;
        int leftIdx = findTargetIndex(nums,target,true);

        if(leftIdx == nums.length || nums[leftIdx] != target){
            return res;
        }

        res[0] = leftIdx;
        res[1] = findTargetIndex(nums,target,false)-1;

        return res;
    }

    // 二分查找
    public static int findTargetIndex(int[] nums, int target, boolean left){
        int low = 0, high = nums.length,mid;

        while(low < high){
            mid = (low + high)/2;
            if(nums[mid] > target || (left && target == nums[mid])){
                high = mid;
            }else{
                low = mid +1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int nums[] = {5,7,7,8,8,10}, target = 8;
        P0034 p0034 = new P0034();
        int arr[] = p0034.searchRange1(nums,target);
        System.out.println(arr[0]+" "+arr[1]);

        int nums1[] = {2,2},target1 = 3;
        int arr1[] = p0034.searchRange1(nums1, target1);
        System.out.println(arr1[0]+" "+arr1[1]);

        System.out.println(Double.MIN_VALUE);
    }
}

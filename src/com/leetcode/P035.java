/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/13/19 9:19 PM
 */

package com.leetcode;

import org.junit.Test;

public class P035 {
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length -1,mid,midData;
        while(left < right){
            mid = (left + right)/2;
            midData = nums[mid];
            if(midData == target){
                if(mid > 0 && nums[mid - 1 ] < target ){
                    return mid;
                }else{
                    right = mid -1;
                }
            }else if(midData>target){
                if(mid > 0  && nums[mid - 1] < target){
                    return mid;
                }else{
                    right = mid -1;
                }
            }else{
                left = mid + 1;
            }
        }
        if(target > nums[nums.length-1])return left+1;
        else
            return left;
    }

    public static void main(String[] args) {
        int[] A = {1,3,5,6};
        int target =7;
        System.out.println(searchInsert(A, target));
    }

    @Test
    public void test(){
        String s1 = "aaaaa",needle = "bba";
        System.out.println(s1.indexOf(needle));
    }
}
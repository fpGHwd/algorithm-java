/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/16/19 6:56 PM
 */

package com.leetcode;

public class P0189 {

    public void func1(){

    }

    public void func2(){
        func1(); // 实例方法可以调用实例方法,也可以调用静态方法
    }

    public void rotate(int[] nums, int k){
        if(nums.length == 0)return;
        if(nums.length < k)k = k %nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public void reverse(int [] nums, int start, int end){
        if(start >= end)return;
        int tmp;
        for(int i = start; i <= (start + end)/2 ; i++){
            tmp = nums[start + end - i];
            nums[start + end - i] = nums[i];
            nums[i] = tmp;
        }
    }

    public static void main(String[] args) {
        P0189 p = new P0189();
        int nums[] = {1,2,3,4,5,6,7}, k = 3;
        p.rotate(nums, k);

        int nums1[] = {-1,-100,3,99}, k1 = 2;
        p.rotate(nums1, k1);

        int nums2[] = {-1}, k2 = 2;
        p.rotate(nums2, k2);
    }
}

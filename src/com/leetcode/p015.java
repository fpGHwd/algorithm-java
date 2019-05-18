/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/16/19
 * @Time:       6:53 PM
 * @Project:    algorithm
 */

package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p015 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lli = new ArrayList<>();
        for(int i = 0; i< nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                for(int k = j+1; k<nums.length; k++){
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> li = new ArrayList<>();
                        li.add(nums[i]);li.add(nums[j]);li.add(nums[k]);
                        lli.add(li);
                    }
                }
            }
        }
        return lli;
    }

    public List<List<Integer>> threeSum1(int[] nums){
//        if(nums.length <= 2)return lli;
        Arrays.sort(nums);
        List<List<Integer>> lli = new ArrayList<>();
        int left, right, t,temp = -1;
        for(int i =0; i< nums.length-1; i++){
            if(i==0 || (i > 0 &&(nums[i-1] != nums[i] || (nums[i-1]==nums[i] && temp!= -1 &&nums[temp] != nums[i])))) {
                left = i - 1;
                right = i + 1;
                while (left >= 0 && right < nums.length) {
                    t = nums[left] + nums[i] + nums[right];
                    if (t > 0) {
                        left--;
                    } else if (t == 0) {
                        lli.add(Arrays.asList(nums[left], nums[i], nums[right]));
                        temp=i;
                        while (left >= 0 && nums[left] == nums[left + 1]) left--;
                        while (right < nums.length && nums[right] == nums[right - 1]) right++;
                        left--;
                        right++;
                    } else {
                        right++;
                    }
                }
            }
        }
        return lli;

    }

    public  static List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {  // 跳过可能重复的答案

                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        while (l < r && nums[l] == nums[l + 1]) l++;   // 跳过重复值
                        l++;
                    } else {
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    }
                }
            }
        }
        return ls;
    }


    @Test
    public void test(){
        int[] nums = {-1,0,1,2,-1,-4};
        int[] nums1 = {0,0,0,0};
//        List<List<Integer>> lli = threeSum1(nums1);
//        System.out.println(lli);

        List<List<Integer>> lli2 = threeSum3 (nums);
        System.out.println(lli2);
        List<List<Integer>> lli3 = threeSum3(nums1);
        System.out.println(lli3);

        List<List<Integer>> lli4 = threeSum1 (nums);
        System.out.println(lli4);
        List<List<Integer>> lli5 = threeSum1(nums1);
        System.out.println(lli5);


        int[] nums2 = {0,0,0};
        List<List<Integer>> lli6 = threeSum3(nums2);
        System.out.println(lli6);

        List<List<Integer>> lli7 = threeSum1(nums2);
        System.out.println(lli7);
    }

}

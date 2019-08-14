/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/13/19 9:43 PM
 */

package com.leetcode;

import java.util.Stack;

public class P026 {
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 1) return 1;
        int temp = nums[0], idx=1;
        for(int i = 1; i < nums.length; i++){
            if(temp != nums[i]){
                nums[idx++]=temp;
                temp = nums[i];
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
        String s = "{}";
        int len = s.length();
        s.equals("");

        Stack<Character> sc = new Stack<>();
        sc.peek();
    }
}

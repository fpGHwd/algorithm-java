/**
 * @author suzumiya
 * @data 5/2/19 5:01 PM
 */

package com.leetcode;

public class P011 {

    // 动态规划 几个字的理解， 到底动态和规划到哪里。外延和内涵的理解。
    // 很简单理解，如果动态是指从前到后的过程，那么规划就是指过程。。。其实这两个词的意思差不多。

    // 公式
    // ma[n-1] = ma[n]
    // 没有写过暴力法，动态规划就如同空中楼阁，意义不大。


//  Area = Max(min(height[i], height[j]) * (j-i)) {其中0 <= i < j < height,size()}
    public int maxArea(int[] height){
        int aR = (height.length-1) * Math.min(height[0], height[height.length-1]), left = 0, right = height.length-1;

        while(left < right){
            int aT = (right-left) * Math.min(height[left] , height[right]);
            if(aT > aR)aR = aT;
            if(height[left] <= height[right]){
                left++;
            }else{
                right--;
            }
        }
        return aR;
    }

    public static void main(String[] argv){
        int[] a = {1,8,6,2,5,4,8,3,7};
        int r = new P011().maxArea(a);
        System.out.println(r);
    }
}


//  执行用时 : 5 ms, 在Container With Most Water的Java提交中击败了94.59% 的用户
//  内存消耗 : 43.7 MB, 在Container With Most Water的Java提交中击败了76.09% 的用户
/**
 * @author suzumiya
 * @data 5/2/19 12:59 PM
 */

package com.leetcode;

public class Solution215 {

    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 1)return nums[0];
        return findKthLargest(nums, k, 0, nums.length-1);
    }

//    public void heapfy(int[] a, int hs) {
//        for(int i = hs; i>=2; i--){
//            if(a[i] > a[i/2]){
//                int t = a[i];
//                a[i] = a[i/2];
//                a[i/2] = t;
//            }
//        }
//    }
    public int findKthLargest(int[] nums, int k, int l, int r){ // 这里的序号很麻烦，写了号长时间
        if(l == r)return nums[l];
        int t = partion(nums, l, r);
        if(t - l == k - 1)return nums[l+ k-1];
        else if(t - l > k - 1)return findKthLargest(nums, k, l,t-1);
        else return findKthLargest(nums, k-(t-l+1), t+1, r);
    }

    public int partion(int[] nums, int l, int r) {
        if (l == r) return l;
        else {
            int t = nums[l];
            while (l < r) {
                while (l < r && nums[r] <= t) { // 两个地方都要等号
                    r--;
                }
                nums[l] = nums[r];
                while (l < r && nums[l] >= t) { // 等号
                    l++;
                }
                nums[r] = nums[l];
            }
            nums[l] = t;
            return l;
        }
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4}, nums2={99,99};
        int[] nums3 = {3,2,3,1,2,4,5,5,6};
        int k3 = 4;
        int k = 2, k2 =1;
        int[] nums4 = {-1,-1}; int k4 =2;

        int z = new Solution215().findKthLargest(nums4, k4);
//        new Solution215().heapfy(h, hs);
        System.out.println(z);
    }
    // 0 - 1
    // 数组 -> 最大的第K个


//    执行用时 : 40 ms, 在Kth Largest Element in an Array的Java提交中击败了37.52% 的用户
//    内存消耗 : 39.9 MB, 在Kth Largest Element in an Array的Java提交中击败了43.13% 的用户
}

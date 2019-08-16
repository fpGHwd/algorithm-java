/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/16/19 7:14 PM
 */

package com.leetcode;

import java.util.Arrays;

public class P0217 {



/*    public boolean containsDuplicate(int[] nums) {
        // 快速排序已经包含了答案,只是没有尽快返回而已
        // copy is fast and time-saving
        if(nums.length == 0)return false;
        quickSort(nums, 0, nums.length -1);
        int tmp = nums[0];
        for( int i = 1; i < nums.length; i++){
            if(nums[i] == tmp){
                return true;
            }else{
                tmp = nums[i];
            }
        }
        return false;
    }*/

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1])return true;
        }
        return false;
    }

    // 书能激发的独立思考的程度是有限的

/*    void quickSort(int arr[], int low, int high)
    {
        int pi;
        if (low < high)
        {
            pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    int partition (int arr[],int low, int high)
    {
        int pivot = arr[high];

        int i = (low - 1);

        for (int j = low; j <= high- 1; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return (i + 1);
    }

    void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }*/

    public static void main(String[] args) {
        int nums[] = {1,1,1,3,3,4,3,2,4,2};
        P0217 p0217 = new P0217();
        System.out.println(p0217.containsDuplicate(nums));
    }
}

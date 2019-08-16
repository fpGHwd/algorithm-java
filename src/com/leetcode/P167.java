/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/16/19 2:17 PM
 */

package com.leetcode;

public class P167 {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        while(left < right){
            if(target > numbers[left] + numbers[right]){
                left++;
            }else if(target < numbers[left] + numbers[right]){
                right--;
            }else{
                break;
            }
        }
        int result[] = new int[2];
        if(left != right){
            result[0] = left+1;result[1] = right+1;
            return result;
        }else{
            return null;
        }
    }

    public static void main(String[] args) {
        int numbers[] = {2,7,11,15}, target=9;
        System.out.println(twoSum(numbers,target));
    }
}

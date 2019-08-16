/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/15/19 9:03 PM
 */

package com.leetcode;

public class p122 {

    public static int maxProfit(int[] prices) {

        int profit = 0;
        boolean showHand = false; // show hand
        for(int i = 1; i < prices.length ; i++){
            profit += (prices[i] > prices[i-1]?(prices[i] - prices[i-1]):0);
        }

        return profit;
    }

    public static void main(String[] args) {
        int arr1[] = {7,1,5,3,6,4};
        int arr2[] = {1,2,3,4,5};
        int arr3[] = {7,6,4,3,1};
        System.out.println(maxProfit(arr1));
        System.out.println(maxProfit(arr2));
        System.out.println(maxProfit(arr3));
    }
}


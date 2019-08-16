/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/15/19 8:42 PM
 */

package com.leetcode;

public class p121 {

    public static int maxProfit(int[] prices) {
        if(prices.length == 1 || prices.length == 0)return 0;
        int minPrice = prices[0], maxProfit = 0;
        for(int i= 1; i< prices.length; i++){
            if(prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int arr1[] = {7,1,5,3,6,4};
        int arr2[] = {7,6,4,3,1};

        System.out.println(maxProfit(arr1));
        System.out.println(maxProfit(arr2));
    }
}

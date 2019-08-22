/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/22/19 7:39 PM
 */

package com.leetcode;

public class P0441 {
    public int arrangeCoins(int n) {
        if(n == 0)return 0;
        int threshold = (int)Math.sqrt(2L * Integer.MAX_VALUE); // 自己改好的
        long start = 1,end = threshold,mid;
        while(start <= end){
            mid = (start + end)/2;
            if(mid * (mid + 1) /2 > n){
                if((mid-1) * mid /2 <= n){
                    return (int)mid -1;
                }else{
                    end = mid - 1;
                }
            }else if(mid * (mid + 1) / 2 == n){
                return (int)mid;
            }else{
                if((mid + 1) * (mid + 2)/2 > n){
                    return (int)mid;
                }else{
                    start = mid+1;
                }
            }
        }
        return (int)start;
    }

    public static void main(String[] args) {
        int n = 1804289383;
        System.out.println(new P0441().arrangeCoins(n));
    }
}

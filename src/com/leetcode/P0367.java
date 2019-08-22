/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/22/19 5:06 PM
 */

package com.leetcode;

public class P0367 {

    public boolean isPerfectSquare(int num) {
        int end = 46340, start = 0, mid;
        while(end < start){
            mid = (end+start)/2;
            if(mid * mid == num){
                return true;
            }else if(mid * mid > num){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new P0367().isPerfectSquare(16));
    }
}

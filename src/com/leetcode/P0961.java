/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/22/19 10:40 AM
 */

package com.leetcode;

public class P0961 {

    public int repeatedNTimes(int[] A) {
        int n = A.length;
        for(int i=0; i<n; i++){
            if ((A[i] == A[(i+n+1)%n]) || (A[i] == A[(i+n+2)%n])){
                return A[i];
            }
        }
        return 0;
    }

    // there are N+1 unique elements,
    public static void main(String[] args) {
        int A[] = {5,6,6,6,3,3,3,3}; // 这组数据不符合题目的说明
        // 题目的条件多,操作就可以少一点
        System.out.println(new P0961().repeatedNTimes(A));
    }

}

/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 9/12/19 5:08 PM
 */

package com.leetcode.DP;

// https://www.bilibili.com/video/av16544031?from=search&seid=2958132823898912817

public class Problem1 {

    int maxIncome(int[][] task, int[] pays)
    {
        // OPT(i) = max(OPT(i-1), i-task[i][]


        return 0;
    }

    public static void main(String[] args) {
        int[][] task = new int[8][2];
        task[0][0] = 1;task[0][1] = 4;
        task[1][0] = 3; task[1][1] = 5;
        task[2][0] = 0; task[2][1] = 6;
        task[3][0] = 4; task[3][1] = 7;
        task[4][0] = 3; task[4][1] = 8;
        task[5][0] = 5; task[5][1] = 9;
        task[6][0] = 6; task[6][1] = 10;
        task[7][0] = 8; task[7][1] = 11;

        int[] pays = {5,1,8,4,6,3,2,4};
    }
}

/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/21/19 8:05 PM
 */

package com.leetcode;

public class P0746 {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 0)return 0;
        if(cost.length == 1)return cost[0];

        int minCost[] = new int[cost.length];
        minCost[0] = cost[0];
        minCost[1] = Math.min(cost[0], cost[1]);
        for(int i = 2; i < cost.length; i++){
            minCost[i] = Math.min(minCost[i-2],minCost[i-1])+cost[i]; // 这个地方的理解
        }
        return Math.min(minCost[cost.length-1], minCost[cost.length-2]);

        // minCost[i] 走了 cost[i]的最小cost
        // minCost[i-1] 走了 cost[i-1]的最小cost
        // minCost[i-2] 走了 cost[i-2]的最小cost
        // 所以前面的minCost[0] = cost[0], minCost[1] = cost[1]
        // 最后的结果也需要在minCost[cost.length-1]和minCost[cost.length-2]中取一个最小值
    }

    public static void main(String[] args) {
        int cost[] = {0,0,1,1}, result = 1;
        int cost1[] = {0,0,0,1}, result1 = 0;
        System.out.println(new P0746().minCostClimbingStairs(cost1));
    }
}

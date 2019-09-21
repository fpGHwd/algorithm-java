/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 9/18/19 3:04 PM
 */

package com.leetcode;

public class P0134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int[] gasTotal = new int[len];
        int[] costTotal = new int[len];

        gasTotal[0] = gas[0];
        costTotal[0] = cost[0];
        for(int i = 1; i < len; i++){
            gasTotal[i] =  gasTotal[i-1]+ gas[i];
            costTotal[i] = costTotal[i-1] + cost[i];
        }

        int result = -1;
        for(int i = 0; i < len; i++){
            boolean flag = true;
            for(int j = i; j < i + len; j++){
                int t = (j < len)?(gasTotal[j] - gasTotal[i]):(gasTotal[len-1]-gasTotal[i] + gasTotal[j%len]);
                int c = (j < len)?(costTotal[j] - costTotal[i]):(costTotal[len-1]-costTotal[i] + costTotal[j%len]);
                if(t -c < cost[j%len]){
                    flag = false;
                    break;
                };
            }

            if(flag){
                result = i;
               break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int gas[] = {1,2,3,4,5};
        int cost[] = {3,4,5,1,2};
        System.out.println(new P0134().canCompleteCircuit(gas,cost));
    }
}

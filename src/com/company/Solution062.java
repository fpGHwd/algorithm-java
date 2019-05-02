/**
 * @author suzumiya
 * @data 5/2/19 3:45 PM
 */

package com.company;

public class Solution062 {

    // int n function(int k); 具有函数的通用特征，而且容易被用到。

    // 动态规划 如何从其他的某些（？）现象中转化过来，公式是什么，比较重要的

    public int uniquePaths(int m, int n) {
        if(m==1 || n ==1)return 1;
        int[][] r = new int[m][n]; r[0][0] = 0;
        // 从图形就能理解了
        for(int i = 0; i< m; i++){
            r[i][0] = 1; // 这个东西和内存也有联系的
        }
        for(int i = 0; i<n; i++){
            r[0][i] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                r[i][j] = r[i-1][j] +r[i][j-1];
            }
        }
//        for(int i = 2; i <= m+n; i++){
//            for(int a = 1; a<= i-1 && a <= m &&  i-a <= n; a++){
//                if(a!=1 && i-a!=1)
//                    r[a-1][i-a-1] = r[a-2][i-a-1]+r[a-1][i-a-2];
//
//            }
//        }
        return r[m-1][n-1];
    }

    public static void main(String[] args){

        int r = new Solution062().uniquePaths(7,3);

    }
}

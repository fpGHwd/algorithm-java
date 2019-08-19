/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/18/19 4:22 PM
 */

package com.leetcode;

public class P0661 {

    public int[][] imageSmoother(int[][] M) {
        int rows = M.length, cols = M[0].length,count;
        int res[][] = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j <  cols; j++){
                count = 0;
                for(int m = i-1; m <= i+1; m++){
                    for(int n = j-1; n <= j+1; n++){
                        if(m >= 0 && m < rows && n >= 0 && n < cols){
                            res[i][j] += M[m][n];
                            count++;
                        }
                    }
                }
                res[i][j] /= count;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int M[][] = {{1,1,1},{1,0,1},{1,1,1}};
        System.out.println(new P0661().imageSmoother(M));
        System.out.println("end");
    }
}

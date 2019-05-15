/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/15/19
 * @Time:       7:51 PM
 * @Project:    algorithm
 */

package com.leetcode;

import org.junit.Test;
import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

public class p054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> li = new ArrayList<>();
        if(matrix.length == 0)return li;
        int x = matrix.length, y = matrix[0].length;
        int a = 0, b = 0;
        int ci = 0; // Circle Index
        while(ci * 2 < Math.min(x,y)){
            for(; b < y - ci; b++){
                li.add(matrix[a][b]);
            }
            b--;
            if(a+1 < x-ci)a++;
            else break;
            for(;a<x-ci;a++){
                li.add(matrix[a][b]);
            }
            a--;
            if(b-1 > ci-1 )b--;
            else break;
            for(;b>ci-1; b--){
                li.add(matrix[a][b]);
            }
            b++;
            if(a-1 > ci)a--;
            else break;
            for(;a>ci;a--){
                li.add(matrix[a][b]);
            }
            a++;
            if(b+1 < y-ci)b++;
            else break;
            ci++;
        }

        return li;
    }

    @Test
    public void test(){
        int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> ret = spiralOrder(matrix);
    }

//    执行用时 : 1 ms, 在Spiral Matrix的Java提交中击败了95.07% 的用户
//    内存消耗 : 33.6 MB, 在Spiral Matrix的Java提交中击败了96.76% 的用户
}

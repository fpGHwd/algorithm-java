/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/19/19
 * @Time:       11:59 AM
 * @Project:    algorithm
 */

package com.DP;

import com.leetcode.Tree;
import com.leetcode.TreeNode;

public class NumberTriangle {
    /**
     * 1.用i和j来描述所有的元素.这一步是必须的,如果能全部描述,那么问题就可以描述.问题描述是问题求解的先决条件. // 整个结构和树相似,用树来描述
     * 2.i表示层,j表示层的每一个元素,从左到有. 就如动态规划的核心是状态和状态转移方程.这就是描述状态
     * 3.状态转移方程:就是各个元素之间的联系(就是那些箭头,如果结合空间关系想象的话概念会更清楚) d(i,j) = a(i,j) + max(d(i+1,j), d(i+1,j+1));
     *
     *
     * // 要解决递归重复的重复计算,就必须要看顺序计算,然后重复利用计算好了数据. -- 全局数组要知道每一个状态是否已经计算过.
     * // 如果要利用已经计算好了的数据,就必须要利用全局数组..(记忆化memoization)
     * //
     *
     * 有向无环图的动态规划是学习动态规划的基础
     */

    public static void main(String[] args){
        TreeNode root;
        int[] data = {1,3,2,4,10,1,4,3,2,20};
//        root = Tree.creatTree(data, 0);
    }

    public static int maxValue(TreeNode root){

        return -1;
    }


}

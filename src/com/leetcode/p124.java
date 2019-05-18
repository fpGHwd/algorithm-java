/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/17/19
 * @Time:       11:13 PM
 * @Project:    algorithm
 */

package com.leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class p124 {
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxPathSum(root.left), right = maxPathSum(root.right);
        return (left>right)?left+root.val:right+root.val;
    }
}

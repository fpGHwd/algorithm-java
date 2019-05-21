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

    private static int max = Integer.MIN_VALUE;

    public static  int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        int max_candidate = maxPathSum1(root);
        if(max_candidate > max)max = max_candidate;

        return max;
    }

    public static int maxPathSum1(TreeNode root) {
        if(root == null)return 0;
//        System.out.println("进入节点："+root.val);
        int left = maxPathSum1(root.left), right = maxPathSum1(root.right);
        if(left + right + root.val > max) max = left+right+root.val;
        if(root.val > max)max = root.val;
        if(((left>right)?left:right)+root.val > max)max = ((left>right)?left:right)+root.val;
        int t = ((left > right)?left:right); // 返回的值和加入全局的值的内容不一致。。。当然返回的值一定要包含root的
        return (t>0)?(t+root.val):root.val;

    }

    public static void main(String[] args){


        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(-2);
        System.out.println(maxPathSum(root));


        TreeNode root1 = new TreeNode(1);
        System.out.println(maxPathSum(root1));

        TreeNode root2 = new TreeNode(-2);
        root2.left = new TreeNode(6);
        root2.left.left = new TreeNode(0);
        root2.left.right = new TreeNode(-6);
        System.out.println(maxPathSum(root2));

        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);
        System.out.println(maxPathSum(root3));


//        执行用时 : 3 ms, 在Binary Tree Maximum Path Sum的Java提交中击败了81.51% 的用户
//        内存消耗 : 42.6 MB, 在Binary Tree Maximum Path Sum的Java提交中击败了48.91% 的用户

    }
}

/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/5/19
 * @Time:       10:34 PM
 * @Project:    algorithm
 */

package com.leetcode;



import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class P236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> tnl1 = new ArrayList<>(), tnl2 = new ArrayList<>();
        findNode(tnl1, root, p);
        findNode(tnl2,root,q);
        int i = 0;
        while(tnl1!=null && tnl2!=null && tnl1 == tnl2){
            i++;
        }
        return tnl1.get(i-1);
    }

    public void findNode(List<TreeNode> p, TreeNode root, TreeNode n){
        if(root.val==n.val)return;
        p.add(root);
        if(root.left!= null){
            findNode(p, root.left, n);
            if(p.contains(n))return;
        }
        if(root.right!= null){
            findNode(p,root.right,n);
            return;
        }
        p.remove(root);
    }

    public TreeNode makeTree(int[] a){
        TreeNode r = null;
//        if(r == null)r
        return null;
    }

    public static void main(String[] args){

         int[] tree = {3,5,1,6,2,0,8,-1,-1,7,4};
         TreeNode t = Tree.creatTree(tree, 0);
         TreeNode p = new TreeNode(5), q = new TreeNode(1);
         TreeNode r = new P236().lowestCommonAncestor(t,p,q);
         System.out.println(r);
    }
}

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

//        List<TreeNode> tnl1 = new ArrayList<>(), tnl2 = new ArrayList<>();
//        findNode(tnl1, root, p);
//        findNode(tnl2,root,q);
//        int i = 0;
//        while(tnl1!=null && tnl2!=null && tnl1 == tnl2){
//            i++;
//        }
//        return tnl1.get(i-1);

        if(root==null||root==p||root==q)return root;
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right,p ,q);
        if(l==null && r== null)return null;
        if(l!=null && r!=null)return root;
        else return l==null?r:l;

    }

/*    public void findNode(List<TreeNode> p, TreeNode root, TreeNode n){
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
    }*/

    public static void main(String[] args){

         int[] tree = {3,5,1,6,2,0,8,-1,-1,7,4};
         TreeNode t = Tree.creatTree(tree, 0);
         TreeNode p = new TreeNode(5), q = new TreeNode(1);
         TreeNode r = new P236().lowestCommonAncestor(t,p,q);
         System.out.println(r.val);
    }
}

// 注意，这里的p和q是两个对象，并不是值而已。所以判断对象的地址是否相等就可以。


//执行用时 : 15 ms, 在Lowest Common Ancestor of a Binary Tree的Java提交中击败了78.04% 的用户
//        内存消耗 : 39.1 MB, 在Lowest Common Ancestor of a Binary Tree的Java提交中击败了5.43% 的用户
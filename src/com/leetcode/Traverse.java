/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/14/19 4:15 PM
 */

package com.leetcode;

import java.util.Stack;

public class Traverse {
    public void postOrder(TreeNode root){
        if(root == null){
            return;
        }

        Stack<TreeNode> stn = new Stack<>();
        TreeNode currentNode = root, lastVisitedNode = null;

        while(currentNode != null){
            stn.push(currentNode);
            currentNode = currentNode.left;
        }

        while(!stn.isEmpty()){
            currentNode = stn.pop();
            if(currentNode.right != null && currentNode.right != lastVisitedNode){
                stn.push(currentNode);
                currentNode = currentNode.right;
                while(currentNode != null){
                    stn.push(currentNode);
                    currentNode = currentNode.left;
                }
            }else{
                System.out.println(currentNode.val + ",");
                lastVisitedNode = currentNode;
            }
        }
    }

    public static void main(String[] args) {
        Tree t = new Tree();
        TreeNode tn = t.getTree();
    }
}

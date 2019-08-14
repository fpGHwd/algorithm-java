/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/14/19 4:31 PM
 */

package com.leetcode.tree;

// [3,9,20,null, null, 15,7]
public class Tree {
    public static final Integer[] treeList = {3,9,20,null,null,15,7};
    public static TreeNode tree = null;
    Tree(){
        int len = treeList.length;
        if(len == 0)return;
        for(int i = 0; (2*i < len) ||(2*i + 1 < len); i++){
            if(treeList[i] == null) continue;
            else{
                TreeNode tn = new TreeNode(treeList[i]);
                if(i == 0) tree = tn;
                if(2*i +1 < len && treeList[2*i +1] != null){
                    tn.leftChild = new TreeNode(treeList[2*i +1]);
                }
                if(2*i+2 < len && treeList[2*i + 2] != null){
                    tn.rightChild = new TreeNode(treeList[2*i + 2]);
                }
            }
        }
    }

    public TreeNode getTree(){return tree;}

}

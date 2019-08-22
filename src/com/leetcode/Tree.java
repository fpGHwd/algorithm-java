/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/14/19 4:31 PM
 */

package com.leetcode;

import java.util.ArrayList;
import java.util.List;

// [3,9,20,null, null, 15,7]
public class Tree {
    public static final Integer[] treeList = {3,9,20,null,null,15,7};
    public static TreeNode tree = null;
    Tree(){
        List<TreeNode> ltn = new ArrayList<>();
        for(int i = 0; i < treeList.length; i++){
            if(treeList[i] == null)ltn.add(null);
            else ltn.add(new TreeNode(treeList[i]));
        }
        for(int i = 1;(2*i + 1 < ltn.size()) || (2*i+2 < ltn.size()); i++){
            if(treeList[i] == null) continue;
            else{
                if(2*i + 1 < ltn.size()){
                    ltn.get(i).left = ltn.get(2*i + 1);
                }
                if(2 * i + 2 < ltn.size()){
                    ltn.get(i).right = ltn.get(2* i + 2);
                }
            }
        }
        tree = ltn.get(0);
    }

    public TreeNode getTree(){return tree;}

}

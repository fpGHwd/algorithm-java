/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Date: 5/23/19
 * @Time: 4:42 PM
 */

package com.jzoffer;

import com.leetcode.ListNode;
import com.leetcode.TreeNode;

public class P6 {

    public static TreeNode rebuildTree(int[] arrayPre, int preS, int preE,  int[] arrayPos, int posS, int posE){
        if(preS == preE) return new TreeNode(arrayPre[preS]);
        if(preS > preE || posS > posE) return null;

        int val = arrayPre[preS], i;
        for(i = posS; val != arrayPos[i] && i< posE; i++);
        TreeNode root = new TreeNode(arrayPos[i]);
        root.left = rebuildTree(arrayPre, preS+1,preS+i-posS,arrayPos, posS, i-1);
        root.right = rebuildTree(arrayPre, preS+ i -posS+1, preE, arrayPos,i +1,posE);
        return root;
    }

    public static void main(String[] args) {
        int[] arrayPre = {1,2,4,7,3,5,6,8}, arrayPos ={ 4,7,2,1,5,3,8,6};
        TreeNode root = rebuildTree(arrayPre, 0, arrayPre.length-1, arrayPos, 0 , arrayPos.length-1);
        System.out.println(root);
    }
}

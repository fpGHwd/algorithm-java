/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/5/19
 * @Time:       11:06 PM
 * @Project:    algorithm
 */

package com.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;


//二叉树的建树，前中后 递归非递归遍历 层序遍历

public class Tree {

    // creat tree from array

    /**
     * 创建树,data是所有元素值的数组,i是从数组的位置开始建树
     * @param data
     * @param i
     * @return
     */
    public static TreeNode creatTree(int[] data, int i) {
        if (i >= data.length || data[i] == -1)
            return null;
        TreeNode temp = new TreeNode(data[i]);
        temp.left = creatTree(data, i * 2 + 1);
        temp.right = creatTree(data, i * 2 + 2);

        return temp;
    }

    // pre前序遍历递归
    public static void pre(TreeNode temp) {
        if (temp == null)
            return;
        System.out.print(temp.val + "  ");
        pre(temp.left);
        pre(temp.right);

    }

    // mid中序遍历递归
    public static void mid(TreeNode temp) {
        if (temp == null)
            return;
        mid(temp.left);
        System.out.print(temp.val + "  ");
        mid(temp.right);
    }

    // last后序遍历递归
    public static void last(TreeNode temp) {
        if (temp == null)
            return;
        last(temp.left);
        last(temp.right);
        System.out.print(temp.val + "  ");
    }

    // pre1前序遍历非递归
    public static void pre1(TreeNode temp) {
        Stack<TreeNode> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                System.out.print(temp.val + "  ");
                temp = temp.left;
            }
            if (!stack.isEmpty()) {
                temp = stack.pop().right;
            }
        }
    }

    // mid1中序遍历非递归
    public static void mid1(TreeNode temp) {
        Stack<TreeNode> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            if (!stack.isEmpty()) {
                temp = stack.pop();
                System.out.print(temp.val + "  ");
                temp = temp.right;
            }
        }
    }

    // last1后序遍历非递归
    public static void last1(TreeNode temp) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                stack2.push(temp);
                temp = temp.right;
            }
            if (!stack.isEmpty()) {
                temp = stack.pop().left;
            }
        }
        while (!stack2.isEmpty())
            System.out.print(stack2.pop().val + "  ");
    }

    // ceng层序遍历
    public static void ceng(TreeNode temp) {
        if (temp == null)
            return;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(temp);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            System.out.print(temp.val + "  ");
            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
        }
    }
    //Demo
    public static void main(String[] args) {

        int[] array = { 1, 2, 3, 4, 5, 6, 7, -1, -1, 10, -1, -1, 13 };
        TreeNode tree = creatTree(array, 0);
        pre(tree);
        System.out.println();
        pre1(tree);
        System.out.println();
        mid(tree);
        System.out.println();
        mid1(tree);
        System.out.println();
        last(tree);
        System.out.println();
        last1(tree);
        System.out.println();
        ceng(tree);

    }

}

//https://blog.csdn.net/idealemail/article/details/51382114

// int select(int maxfdp,fd_set *readfds,fd_set *writefds,fd_set *errorfds,struct timeval*timeout);
// https://blog.csdn.net/u010889616/article/details/48142483
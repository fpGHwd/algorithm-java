/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/6/19
 * @Time:       9:25 PM
 * @Project:    algorithm
 */

package com.leetcode;

// 旋转链表

public class P061 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        ListNode w =  head, tail, head1;
        int len, c = 0;
        while(w.next != null){
            c++;
            w = w.next;
        }
        tail = w;
        len = c+1;

        if(k % len == 0)return head;

        int r = len - (k % len);

        w = head;
        while(r-1>0){
            r--;
            w = w.next;
        }
        head1 = w.next;
        w.next = null;
        tail.next = head;

        return head1;
    }


    public static void main(String[] args){

    }
}


//执行用时 : 2 ms, 在Rotate List的Java提交中击败了98.75% 的用户
//        内存消耗 : 35.3 MB, 在Rotate List的Java提交中击败了86.97% 的用户

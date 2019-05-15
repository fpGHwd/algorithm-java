/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/15/19
 * @Time:       7:58 PM
 * @Project:    algorithm
 */

package com.leetcode;

import org.junit.Test;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class p002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 加法顺序。题意是不是没看清。
        int carry = 0;
        ListNode h1 = l1, h2 = l2;
        ListNode h= new ListNode(0), w = h;
        int value = 0;
        while(h1!=null && h2 !=null){
            value = h1.val + h2.val + carry;
            h.next = new ListNode(value %10);
            h=h.next;
            carry = value/10;
            h1=h1.next;
            h2=h2.next;
        }
        while(h1!=null){
            value = h1.val + carry;
            h.next = new ListNode(value%10);
            h = h.next;
            carry = value /10;
            h1=h1.next;
        }
        while(h2!=null){
            value = h2.val + carry;
            h.next = new ListNode(value%10);
            h = h.next;
            carry = value /10;
            h2=h2.next;
        }
        if(carry!=0)h.next = new ListNode(carry);
        return w.next;
    }

    @Test
    public void test(){

//        执行用时 : 10 ms, 在Add Two Numbers的Java提交中击败了88.44% 的用户
//        内存消耗 : 40.7 MB, 在Add Two Numbers的Java提交中击败了95.50% 的用户

    }
}

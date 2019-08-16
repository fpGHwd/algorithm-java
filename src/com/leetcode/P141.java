/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/15/19 9:53 PM
 */

package com.leetcode;

public class P141 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next==null )return false;

        ListNode fast = head, slow = head;
        while(fast != null && slow != null){
            slow = slow.next;
            if(fast.next == null)return false; // 防止fast.next在没有循环的时候溢出
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}

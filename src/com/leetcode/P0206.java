/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/22/19 11:50 AM
 */

package com.leetcode;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class P0206 {

    // iteratively
    public ListNode reverseList1(ListNode head) {
        ListNode preHead = new ListNode(0);
        ListNode work = head, temp;

        while(work != null){
            temp = work.next;
            work.next = preHead.next;
            preHead.next = work;
            work = temp;
        }

        return preHead.next;
    }

    // recursively
    public ListNode reverseList(ListNode head) {
        if(head == null)return null;
        else{
            ListNode temp = reverseList(head.next);
            head.next = temp.next;
            temp.next = head;
            return temp;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1), temp;
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode reversedList = new P0206().reverseList(head);
    }
}

/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/22/19 2:12 PM
 */

package com.leetcode;

public class P0234 {

    public boolean isPalindrome(ListNode head) {
        // O(1) space
        ListNode work = head;
        int len = 0;
        while(work != null){
            len++;
            work = work.next;
        }
        int i = len/2;
        ListNode midNode = head;
        while(i-- > 0){
            midNode = midNode.next;
        }

        ListNode reversedHead = reverse(midNode);

        ListNode first = head, second = reversedHead;
        while(first != null && second != null){
            if(first.val != second.val){
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        if(head == null)return null;
        return reverseRecursively(null, head);
    }

    // O(1) space
    public ListNode reverseRecursively(ListNode prev, ListNode curr)
    {
        if(curr == null)return prev;
        ListNode next = curr.next;
        curr.next = prev;
        return reverseRecursively(curr, next);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        ListNode head1 = new ListNode(0);
        head1.next = new ListNode(0);

        System.out.println(new P0234().isPalindrome(head));

        System.out.println(new P0234().isPalindrome(head1));
    }
}

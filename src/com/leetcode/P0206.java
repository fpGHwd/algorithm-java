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
        if(head.next != null)return head;
        else{
            ListNode temp = reverseList(head.next); // 返回最后一个元素
            head.next = temp.next;
            temp.next = head;
            return temp.next;
        }
    }

    /**
     *
     * @param head 链表本身
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        return reverse(null, head);
    }

    /**
     * todo 这个比较有意思 在确定函数的原型之前确定好递归函数,然后确定原型,然后细化内部
     * @param prev 尾节点,转置后放在最后面的那个节点(已经转置好的节点的head节点)
     * @param curr 当前的需要转置的节点list的头节点(待转置的节点组的head节点)
     * @return
     */
    public ListNode reverse(ListNode prev, ListNode curr) {
        if (curr == null) return prev;
        ListNode next = curr.next; // 后面需要转置的节点 // 应该是当前节点的后一个节点
        curr.next = prev; // prev是已经转置好的节点 // 然后把已经转置好的节点prev接在curr后面,然后转置后面的curr还有未转化的部分
        return reverse(curr, next); //
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1), temp;
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode reversedList = new P0206().reverseList2(head);
    }
}

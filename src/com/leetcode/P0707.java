/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/22/19 2:58 PM
 */

package com.leetcode;



// todo

public class P0707 {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    ListNode head;

    /** Initialize your data structure here. */
    public P0707() {
        head = null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        ListNode work = head;
        while(index-- > 0 && work != null){
            work = work.next;
        }
        if(work == null)return -1;
        else return work.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if(head == null){
            head = new ListNode(val);
        }else{
            ListNode temp = head;
            head = new ListNode(val);
            head.next = temp;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(head == null)head = new ListNode(val);
        else{
            ListNode tail = head;
            while(tail.next != null){
                tail = tail.next;
            }
            tail.next = new ListNode(val);
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode headA = pre;
        while(index > 0 && pre != null){
            pre = pre.next;
            index--;
        }
        if(pre == null) return;
        else{
            ListNode temp = new ListNode(val);
            temp.next = pre.next;
            pre.next = temp;
        }
        head = headA.next;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(head == null)return;
        if(index == 0){
            head = head.next;
            return;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        while(index >0 && pre!=null){
            index--;
            pre = pre.next;
        }

        if(pre== null)return;
        else{
            pre.next= pre.next.next;
        }
    }

    public static void main(String[] args) {
        P0707 p0707 = new P0707();
        p0707.addAtHead(1);
        p0707.addAtTail(3);
        p0707.addAtIndex(1,2);
        System.out.println(p0707.get(1));
        p0707.deleteAtIndex(1);
        System.out.println(p0707.get(1));

        P0707 p07071 = new P0707();
        p07071.addAtHead(1);
        p07071.deleteAtIndex(0);
    }
}

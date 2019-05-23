/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Date: 5/23/19
 * @Time: 4:08 PM
 */

package com.jzoffer;

import com.leetcode.ListNode;

import java.util.Arrays;
import java.util.List;

public class P5 {

    public static void printList(ListNode head){
        if(head == null)return;
        printList(head.next);
        System.out.println(head.val);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        printList(head);
    }}

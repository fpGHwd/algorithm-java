/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: HydroCloud
 * @Date: 6/4/19
 * @Time: 7:17 PM
 */

package com.vivo;


import org.junit.Test;

import java.io.*;
import java.util.List;

/**
 * Welcome to vivo !
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arrA = parseInts(br.readLine().split(" "));
        int[] arrB = parseInts(br.readLine().split(" "));
        int m = arrA[0];
        int n = arrA[1];
        ListNode head = null;
        ListNode pre = null;
        for (int v : arrB) {
            ListNode listNode = new ListNode(v);
            if (head == null) {
                head = listNode;
            }
            if (pre != null) {
                pre.next = listNode;
            }
            pre = listNode;
        }
        solution(head, m, n);

    }

    @Test
    public void main1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        solution1(head, 1, 6);
    }

    private static void solution(ListNode head, int m, int n) {

        // TODO write your code here
        if(m >= n)return;
        // head
        int i = 1;
        ListNode w = head, h, t;
        while(i+1 < m){
            w = w.next;
            i++;
        }
        h = w;
        while(i < n){
            w = w.next;
            i++;
        }
        t = w.next;

        ListNode[] r = reverseList(h.next, 1, n-m+1);
        h.next = r[0];
        r[1].next = t;
    }

    private static void solution1(ListNode head, int m, int n) {

        if(head == null)return;
        ListNode vh = new ListNode(0);
        vh.next = head;

        // TODO write your code here
        if(m >= n)return;
        // head
        int i = 1;
        ListNode w = vh, h, t;
        while(i+1 < m){
            w = w.next;
            i++;
        }
        h = w;
        while(i < n){
            w = w.next;
            i++;
        }
        t = w.next;

        ListNode[] r = reverseList(h.next, 1, n-m+1);
        if(m != 1) {
            h.next = r[0];
            r[1].next = t;
        }else{
            vh.next = r[0];
            r[1].next = t;
        }

        w = vh.next;
        i = 0;
        while(w != null){
            if( i != 0)System.out.print(" ");
            i++;
            System.out.print(w.val);
            w = w.next;
        }
    }

    static ListNode[] reverseList(ListNode head, int m, int n){

        if(m +1 == n ){
            ListNode t, he, ta;
            t = head.next.next;
            he = head.next;
            ta = head;
            he.next = ta;
            ta.next = t;
            return new ListNode[]{he, ta};
        }else{
            ListNode[] ns = reverseList(head.next, m+1, n);
            ListNode t = ns[1].next;
            ns[1].next = head;
            head.next = t;
            return new ListNode[]{ns[0], head};
        }
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int v) {
            val = v;
            next = null;
        }

        public String toString() {
            String str = val + " ";
            ListNode node = next;
            while (node != null) {
                str += node.val + " ";
                node = node.next;
            }
            return str;
        }
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

}

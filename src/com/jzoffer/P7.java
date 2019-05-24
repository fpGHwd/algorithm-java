/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Date: 5/24/19
 * @Time: 10:54 AM
 */

package com.jzoffer;

import java.util.Stack;

/**
 * 两个栈模拟一个队列
 */
public class P7 {
    static Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();

    static void enqueue(int a) {
        s1.push(a);
    }

    static int dequeue() {
        if (s2.empty()) {
            if (s1.empty())
                return -1;
            while (!s1.empty())
                s2.push(s1.pop());
        }
        return s2.pop();
    }

    public static void main(String[] args) {
        int[] arrray = {0, 1, 2, 3, 4, 5, 6};
        for (int i = 0; i < arrray.length; i++) {
            enqueue(arrray[i]);
        }
        int a;
        while ((a = dequeue()) != -1) {
            System.out.println(a);
        }
    }
}

/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/15/19 10:13 PM
 */

package com.leetcode;

// 如何思考,盲区
// 怎么想是关键

import java.util.Stack;

public class P155 {

    Stack<Integer> ori,min;

    /** initialize your data structure here. */
    public P155() {
        ori = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        ori.push(x);
        if(min.isEmpty()){
            min.push(x);
        }else{
            if(x < min.peek()){
                min.push(x);
            }else{
                min.push(min.peek());
            }
        }
    }

    public void pop() {
        if(!ori.isEmpty()){
            ori.pop();
            min.pop();
        }else{
            return;
        }
    }

    public int top() {
        return ori.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
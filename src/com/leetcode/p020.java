/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/14/19 11:45 AM
 */

package com.leetcode;

import java.util.Stack;

public class p020 {
    public static boolean isValid(String s) {
        if(s == null){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        int len = s.length();
        char c;
        for(int i = 0; i < len; i++){
            c = s.charAt(i);
            if(c == '{' || c == '(' || c == '['){
                stack.push(c);
            }else{
                if(!stack.empty()){
                    if(c == ']'){
                        if(stack.peek() == '['){
                            stack.pop();
                        }else{
                            return false;
                        }
                    }else if(c == '}'){
                        if(stack.peek() == '{'){
                            stack.pop();
                        }else{
                            return false;
                        }
                    }else if(c == ')'){
                        if(stack.peek() == '('){
                            stack.pop();
                        }else{
                            return false;
                        }
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        if(stack.size() == 0)
            return true;
        else return false;
    }

    public static void main(String[] args) {
        String test = "()";
        System.out.println(isValid(test));
    }
}

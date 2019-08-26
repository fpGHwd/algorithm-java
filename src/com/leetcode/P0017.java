/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/24/19 8:13 PM
 */

package com.leetcode;

import java.util.*;

public class P0017 {
    private static String[] nums = {"abc","def","ghi","jkl","mno","pqrs","tuv", "wxyz"};


    public List<String> letterCombinations(String digits) {

        return letterCombinationsRecursive(digits);
    }

    public List<String> letterCombinationsRecursive(String digits){
        List<String> result = new ArrayList<>();
        if(digits.length() == 1){
            String s = nums[digits.charAt(0)-'2'];
            for(int i = 0;i < s.length(); i++){
                result.add(String.valueOf(s.charAt(i)));
            }
            return result;
        }
        List<String> tmp;
        for(int i = 0; i < nums[digits.charAt(0)-'2'].length(); i++){
            tmp = letterCombinationsRecursive(digits.substring(1));
            for(String s:tmp){
                result.add(nums[digits.charAt(0)-'2'].charAt(i) + s);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(new P0017().letterCombinations(digits));

        /*
        Stack<Integer> si = new Stack<>();
        si.push(5);
        if(si.isEmpty()) System.out.println("false");

        Queue<Integer> queue1 = new LinkedList<>();
        queue1.add(1);queue1.add(2);
        System.out.println(queue1);
//        System.out.println(queue1.offer());
        System.out.println(queue1.isEmpty());
        System.out.println(queue1.size());
        queue1.remove();
        */

        System.out.println(Integer.MAX_VALUE);
    }
}

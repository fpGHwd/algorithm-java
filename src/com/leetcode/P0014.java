/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/24/19 7:13 PM
 */

package com.leetcode;

public class P0014 {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        boolean flag = true;
        char c;
        while(flag){
            c = 0;
            for(String s:strs){
                if(s.length()-1 < i){
                    flag = false;
                    break;
                }
                if(c == 0) c = s.charAt(i);
                else{
                    if(s.charAt(i) != c){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag){
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow","flight"};
        System.out.println(new P0014().longestCommonPrefix(strs));
    }
}

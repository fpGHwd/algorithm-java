/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/21/19 7:20 PM
 */

package com.leetcode;

public class P0392 {

    // 比较有双指针,一个指向t串,一个指向s串,如果完了,驾驶假

    public boolean isSubsequence(String s, String t)
    {

        int sIdx = 0, tIdx = 0;
        if(t.length() == 0 || s.length() == 0)return false;

        while (sIdx < s.length() && tIdx < t.length()){
            if(s.charAt(sIdx) == t.charAt(tIdx)){
                if(sIdx == s.length() -1){
                    return true;
                }else{
                    sIdx++;tIdx++;
                }
            }else{
                tIdx++;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        String s = "abc", t = "ahbgdc";

        System.out.println(new P0392().isSubsequence(s,t));
    }
}

/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/22/19 11:34 AM
 */

package com.leetcode;

public class P0389 {

    // 389. Find the Difference

    public char findTheDifference1(String s, String t) {
        int[][] hashTables = new int[2][26];
        for(int i = 0; i < s.length(); i++){
            hashTables[0][s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++){
            hashTables[1][t.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(hashTables[1][i] - hashTables[0][i] == 1)
                return (char)('a' + i);
        }
        return 'a';
    }

    public char findTheDifference(String s, String t) {
        int r = 0, i = 0;
        for(; i <s.length(); i++){
            r += t.charAt(i) - s.charAt(i);
        }

        return (char)(r + t.charAt(i));
    }


    public static void main(String[] args) {

        String s = "abcd", t = "abcde";
        System.out.println(new P0389().findTheDifference(s,t));

    }

}

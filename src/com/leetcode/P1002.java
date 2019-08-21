/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/21/19 9:07 PM
 */

package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P1002 {
    public List<String> commonChars(String[] A) {
        int len = A.length;
        int[][] hashTables = new int[len][26];

        for(int i = 0; i < len; i++){
            for(int j = 0; j < A[i].length(); j++){
                hashTables[i][A[i].charAt(j)-'a']++;
            }
        }

        List<String> result = new ArrayList<>();
        int min;
        for(int i = 0; i < 26; i++){
            min = hashTables[0][i];
            for(int j = 0; j < len; j++){
                if(hashTables[j][i] < min)min = hashTables[j][i];
            }
            for(int k = 0; k < min; k++){
                result.add(String.valueOf((char)('a' + i)));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String A[] = {"bella","label","roller"};
        List<String> result = new P1002().commonChars(A);
        for(String s:result){
            System.out.println(s);
        }
        System.out.println("hello world\n");
    }
}

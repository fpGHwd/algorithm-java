/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/15/19 7:55 PM
 */

package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lli = new ArrayList<>();
        if(numRows == 0)return lli;
        Integer arr[] = {1};
        lli.add(Arrays.asList(arr));
        if(numRows == 1)return lli;

        for(int i = 1; i < numRows; i++){
            List<Integer> li = new ArrayList<>();
            li.add(1);
            for(int j = 1; j < i; j++){
                li.add(lli.get(i-1).get(j-1) + lli.get(i-1).get(j));
            }
            li.add(1);
            lli.add(li);
        }
        return lli;
    }

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> lli = generate(numRows);
        System.out.println(lli);
    }
}

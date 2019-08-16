/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/15/19 8:19 PM
 */

package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p119 {
    public static List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0)return Arrays.asList(new Integer[]{1});
        if(rowIndex == 1)return Arrays.asList(new Integer[]{1,1});
        List<Integer> li= Arrays.asList(new Integer[]{1,1}), temp;
        for(int i = 0; i<=rowIndex; i++){
            temp = new ArrayList<>(i+1);
            temp.add(1);
            for(int j = 1;j< i; j++){
                temp.add(li.get(j-1) + li.get(j));
            }
            temp.add(1);
            li = temp;
        }
        return li;
    }

    public static void main(String[] args) {
        int rowIndex = 3;
        List<Integer> li = getRow(rowIndex);
        System.out.println(li);
    }
}

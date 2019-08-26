/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/23/19 1:55 PM
 */

package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P0728 {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> li = new ArrayList<>();
        for(int i = left; i<=right; i++){
            if(selfDividingNumber(i)){
                li.add(i);
            }
        }
        return li;
    }

    public boolean selfDividingNumber(int num){
        int tmp, n = num;
        while(n > 0){
            tmp = n % 10;
            if(tmp == 0 || num % tmp!=0){
                return false;
            }
            n = n/10;
        }
        return true;
    }

    public static void main(String[] args) {
        int left = 1, right = 22;
        List<Integer> li = new P0728().selfDividingNumbers(left,right);
        System.out.println(li);
    }
}

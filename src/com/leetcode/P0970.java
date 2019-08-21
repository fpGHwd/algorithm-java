/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/21/19 9:56 PM
 */

package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P0970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> result = new HashSet<>();

        int a = 1,b;
        while(true){
            if(a>bound)break;
            b = 1;
            while(true){
                if(a+b <= bound){
                    result.add(a+b);
                }else{
                    break;
                }
                b *= y;
                if(y==1)break;
            }
            a *= x;
            if(x == 1)break;
        }

        return new ArrayList<>(result); // 这种写法也可以
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }
}

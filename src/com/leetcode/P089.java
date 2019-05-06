/**
 * @author suzumiya
 * @data 5/2/19 1:27 AM
 */

package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class P089 {

    /**
     * n = 0
     * 0
     *
     * ------ n = 1
     * 0
     * 1
     *
     * 00
     * 01
     *
     * 10
     * 11
     *
     * ------ n = 2 adjust
     *
     * 00
     * 01
     * 11
     * 10
     * ------ n = 3 before adjusting
     * 001
     * 000
     * 010
     * 011
     *
     * 101
     * 100
     * 110
     * 111
     * ----- adjust
     * 001
     * 000
     * 010
     * 011
     * 111
     * 110
     * 100
     * 101
     * ------  n = 4
     *
     * 0001
     * 0000
     * 0010
     * 0011
     * 0111
     * 0110
     * 0100
     * 0101
     *
     * 1001
     * 1000
     * 1010
     * 1011
     * 1111
     * 1110
     * 1100
     * 1101
     * -------  adjust
     *
     * 0001
     * 0000
     * 0010
     * 0011
     * 0111
     * 0110
     * 0100
     * 0101
     * 1101
     * 1100
     * 1110
     * 1111
     * 1011
     * 1010
     * 1000
     * 1001
     *
     * ----------
     */

    @Test // 必须空参数，test并没有人提供空参数
    public void test(){
        System.out.print("this is a test");
    }

    public List<Integer> grayCode(int n){
        List<Integer> g = new ArrayList<>();
        if(n==0){
            g.add(0);
        }else if(n == 1){g.add(0);g.add(1);}
        else{
            List<Integer> r = grayCode(n-1);
            for(int i = 0; i < r.size(); i++)
                g.add(r.get(i)); // 正向
            for(int i = r.size(); i > 0; i--)
                g.add((1<<(n-1)) + r.get(i-1)); // 反向拼接
        }
        return g;
    }

    // 能用公式写是最好的形式el
    public List<Integer> grayCode2(int n){ // 顺序是一样的
        List<Integer> r = new ArrayList<>();
        for(int i = 0; i <(1<<n); i++){
            r.add(i ^ (i >>1));
        }
        return r;
    }

    public static void main(String[] args){
        int t1 = 2, t2 = 3;
        List<Integer> r = new P089().grayCode2(3);
        System.out.println();
    }

//    执行用时 : 2 ms, 在Gray Code的Java提交中击败了39.82% 的用户
//    内存消耗 : 33.3 MB, 在Gray Code的Java提交中击败了76.03% 的用户
    // 完全自己做的

    // 固定格式的编码（虽然不只一种）的索引和值
    //  索引 i * (i >> 1)
    // 索引指的是结果的话（最直观），然后（i>>1)指的就是我的递归的里面的东西。然后得到编码值。
    // 实际上 索引和编码值并没有什么两样。
}

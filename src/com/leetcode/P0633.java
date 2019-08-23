/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/23/19 10:20 AM
 */

package com.leetcode;

public class P0633 {

    public boolean judgeSquareSum(int c) {
        if(c == 1)return true;
        int tmp, tmp1;
        for(int i = 1; i<= Math.sqrt((c+1)/2); i++){
            tmp = c - i*i;
            tmp1 = (int)Math.sqrt(tmp);
            if(tmp1*tmp1 == tmp)return true;
        }
        return false;
    }

    public boolean judgeSquareSum1(int c) {
        long a = 0, b = (int)Math.sqrt(c);
        while (a <= b) {
            if (a * a + b * b == c) return true;
            else if (a * a + b * b < c) ++a;
            else --b;
        }
        return false;
    }

    public boolean judgeSquareSum3(int c) {
        // if(c == 0 || c == 1)return true;
        // int tmp, tmp1;
        // for(int i = 0; i<= Math.sqrt((c+1)/2); i++){
        //     tmp = c - i*i;
        //     tmp1 = (int)Math.sqrt(tmp);
        //     if(tmp1*tmp1 == tmp)return true;
        // }
        // return false;

        // long a = 0, b = (int)Math.sqrt(c);
        // while (a <= b) {
        //     if (a * a + b * b == c) return true;
        //     else if (a * a + b * b < c) ++a;
        //     else --b;
        // }
        // return false;

        for (int i = 2; i * i <= c; ++i) {
            if (c % i != 0) continue; // i is not factor
            int cnt = 0;
            while (c % i == 0) { // i is factor比较小
                ++cnt; // factor number
                c /= i; //是否含有其他的factor
            }
            if (i % 4 == 3 && cnt % 2 != 0) return false; // 形如4k+3 i因子的个数 为奇数个,否则返回false
        }
        return c % 4 != 3;

    }

    public static void main(String[] args) {
        System.out.println(new P0633().judgeSquareSum1(8));
    }
}

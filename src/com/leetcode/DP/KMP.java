/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       19-5-11
 * @Time:       下午12:03
 * @Project:    algorithm
 */

package com.leetcode.DP;

/**
 * https://zh.wikipedia.org/wiki/%E5%85%8B%E5%8A%AA%E6%96%AF-%E8%8E%AB%E9%87%8C%E6%96%AF-%E6%99%AE%E6%8B%89%E7%89%B9%E7%AE%97%E6%B3%95
 * <p>
 * 在计算机科学中，Knuth-Morris-Pratt字符串查找算法（简称为KMP算法）可在一个主文本字符串S内查找一个词W的出现位置。
 * 此算法通过运用对这个词在不匹配时本身就包含足够的信息来确定下一个匹配将在哪里开始的发现，从而避免重新检查先前匹配的字符。
 */

public class KMP {

    public static int kmp(String s, String p) {

        int[] k_table = kmp_table(p);

        int pi = 0, si = 0;
        while (si < s.length() && pi < p.length()) {
            if (s.charAt(si) == p.charAt(pi)) {
                pi++;
                si++;
            } else {
                pi = k_table[pi];
                if (pi == -1) {
                    si++;
                    pi = 0;
                }
            }
        }

        if (pi == p.length()) return si - pi;
        else

            return -1;
    }

    public static int[] kmp_table(String S) {
        /**
         * algorithm kmp_table:
         *     input:
         *         an array of characters, W (the word to be analyzed)
         *         an array of integers, T (the table to be filled)
         *     output:
         *         nothing (but during operation, it populates the table)
         *
         *     define variables:
         *         an integer, pos ← 2 (the current position we are computing in T)
         *         an integer, cnd ← 0 (the zero-based index in W of the next
         * character of the current candidate substring)
         *
         *     (the first few values are fixed but different from what the algorithm
         * might suggest)
         *     let T[0] ← -1, T[1] ← 0
         *
         *     while pos < length(W) do
         *         (first case: the substring continues)
         *         if W[pos - 1] = W[cnd] then
         *             let cnd ← cnd + 1, T[pos] ← cnd, pos ← pos + 1
         *
         *         (second case: it doesn't, but we can fall back)
         *         else if cnd > 0 then
         *             let cnd ← T[cnd]
         *
         *         (third case: we have run out of candidates.  Note cnd = 0)
         *         else
         *             let T[pos] ← 0, pos ← pos + 1
         */

        int pos = 2, cnd = 0;
        int[] T = new int[S.length()];
        T[0] = -1;
        T[1] = 0;
        while (pos < S.length()) {
//            if(S.charAt(pos-1) == S.charAt(cnd)){
//                cnd = cnd+1;
//                T[pos] = cnd;
//                pos = pos+1;
//            }else if(cnd > 0){
//                cnd = T[cnd];
//            }else{
//                T[pos] = 0;
//                pos = pos+1;
//            }
            if (S.charAt(pos - 1) == S.charAt(T[pos - 1])) {
                T[pos] = T[pos - 1] + 1;
            } else {
                T[pos] = 0; // 公式出来了就好了，感觉wiki讲的好复杂
            }
            pos++;
        }

        /**
         * T[n] = 1.T[n-1] + 1 if W[n-1] = W[T[n-1]] 2.
         */

        return T;

    }

    public static void main(String[] args) {
        System.out.println("hello dp");

        String S = "ABC ABCDAB ABCDABCDABDE";
        String W = "ABCDABD";

        int r = kmp(S, W);

        String test_k_table = "PARTICIPATE IN PARACHUTE";
        int[] r_test_k_table = kmp_table(test_k_table);

        int[] W_k_table = kmp_table(W);


        System.out.println(kmp(S, W));

    }
}

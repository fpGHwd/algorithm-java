/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/15/19
 * @Time:       9:58 PM
 * @Project:    algorithm
 */

package com.leetcode;


public class p005 {
    public static String longestPalindrome(String s) {
        if(s.length() == 0)return "";
        if(s.length() == 1)return s;
        int len = s.length();
        // 添加字符
        StringBuilder sb = new StringBuilder();
        sb.append("$#");
        for (int i = 0; i < len; i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        sb.append("^");
        String s1 = sb.toString();

        int[] p = new int[2 * len + 1 + 2]; // 0 ~ 2*len
        int max_p_index = 1;
        p[max_p_index] = 1;
        int mx = max_p_index + p[max_p_index];
        for (int i = 2; i <= 2 * len + 1; i++) {
            if(i >= mx) {  // mx是外边界
                p[i] = 1;
                int left = i-1,right = i+1;
                while(left >= 1 && right <= 2*len+1 && s1.charAt(left) == s1.charAt(right)){
                    left--;right++; p[i]++;
                }
            }else{ // i < mx
                if(mx-i > p[2*max_p_index-i]){
                    p[i] = p[2*max_p_index-i];
                }else if(mx-i < p[2*max_p_index-i]){
                    p[i] = mx-i;
                }else{
                    // 需要继续匹配
                    p[i] = p[2*max_p_index-i];
                    int left = 2*i - mx, right = mx;
                    while(left >= 1 && right <= 2*len +1 && s1.charAt(left) == s1.charAt(right)){
                        left--; right++; p[i]++;
                    }
                }
            }
            if(p[i] + i > mx){
                max_p_index = i;
                mx = max_p_index + p[max_p_index];
            }
        }

        StringBuilder sbr = new StringBuilder();

        int maxp = 1, maxN = 1;
        for(int i = maxp; i < 2*len + 1; i++){
//            if(p[i] > p[maxp])maxp = i;
            if(s1.charAt(i) == '#'){
                if( (p[i] + 1)/2 * 2 > maxN){
                    maxp = i;
                    maxN = (p[i] + 1)/2 * 2;
                }
            }else{ //
                if(p[i] /2 * 2 + 1 > maxN){
                    maxp = i;
                    maxN = (p[i] /2 * 2  + 1);
                }
            }
        }

        for(int t = maxp - p[maxp] + 1; t < maxp + p[maxp] -1; t++){
            if(s1.charAt(t)!='#')sbr.append(s1.charAt(t));
        }

        return sbr.toString();
    }

    public static void main(String[] args) {
        String test = "babad";
        String test2 = "cbbd";
        String result = longestPalindrome(test);
        System.out.println(result);

        String result2 = longestPalindrome(test2);
        System.out.println(result2);

//        执行用时 : 21 ms, 在Longest Palindromic Substring的Java提交中击败了76.77% 的用户
//        内存消耗 : 36.9 MB, 在Longest Palindromic Substring的Java提交中击败了88.38% 的用户
    }
}

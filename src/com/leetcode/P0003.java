/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/31/19 4:46 PM
 */

package com.leetcode;

import sun.misc.PostVMInitHook;

import java.util.HashSet;
import java.util.Set;

public class P0003 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null)return 0;
        if(s.length()==0 || s.length() == 1)return 1;
        int i = 0, j = i;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(i));
        int max = 0;
        while(j < s.length() && i < s.length()){

            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                max = Math.max(max, j-i+1);
                j++;
            }else{
                set.remove(s.charAt(i));
                i++;
            }

/*            while(j < s.length() && j-i+1 == set.size()){
                if(j-i+1 > max)max = j-i + 1;
                j++;
                if(j < s.length())
                    set.add(s.charAt(j));
                else
                    break;
            }

            while(i < j && i < s.length() && j-i+1 > set.size()){
                set.remove(s.charAt(i)); // 当i和j的字符是一样的时候
                i++;
            }*/
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(new P0003().lengthOfLongestSubstring(s));
    }
}

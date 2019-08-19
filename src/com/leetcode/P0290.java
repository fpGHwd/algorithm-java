/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/17/19 1:43 PM
 */

package com.leetcode;

// word pattern

public class P0290 {
    public boolean wordPattern(String pattern, String str) {
        String split[] = str.split(" ");
        if(pattern.length() != split.length)return false;
        int p_s[] = new int[pattern.length()];
        int letters[] = new int[26];
        for(int i = 0; i < letters.length; i++){
            letters[i] = -1;
        }
        for(int i = 0; i< pattern.length(); i++){
            if(letters[pattern.charAt(i)-'a']== -1){
                letters[pattern.charAt(i)-'a'] = i;
                p_s[i] = i;
            }else{
                p_s[i] = letters[pattern.charAt(i)-'a'];
            }
        }
        for(int i = 0; i < split.length; i++){
            if(!split[i].equals(split[p_s[i]])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern0 = "abba";
        String str0 = "dog dog dog dog";
        boolean result0 = false;

        String pattern = "abcdefghijklmnnmlkjihgfedcba";
        String str = "aa bb cc dd ee ff gg hh ii jj kk ll mm nn nn mm ll kk jj ii hh gg ff ee dd cc bb aa";
        boolean result = true;
        System.out.println(new P0290().wordPattern(pattern,str));
    }
}

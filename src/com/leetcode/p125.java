/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/15/19 9:20 PM
 */

package com.leetcode;

// alphanumeric 数字和字母都可以

public class p125 {
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while(left < right){
            while(!Character.isLetterOrDigit(s.charAt(left)) && left < right)left++;
            while(!Character.isLetterOrDigit(s.charAt(right)) && left < right)right--;
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
        String str1 = "A man, a plan, a canal: Panama";
        String str2 = "race a car";
        String str3 = "0P";

        System.out.println(isPalindrome(str1));
        System.out.println(isPalindrome(str2));
        System.out.println(isPalindrome(str3));
    }
}

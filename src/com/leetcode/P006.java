/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/16/19 3:39 PM
 */

package com.leetcode;

// 模拟

public class P006 {
    public static String convert(String s, int numRows) {
        if(numRows == 1)return s;
        int circleValue = 2*numRows -2, len = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            for(int j = 0; i + circleValue * j < len; j++){
                sb.append(s.charAt(i + circleValue*j));
                if(i > 0 && i < numRows-1){
                    if(circleValue - i + circleValue * j < len)
                        sb.append(s.charAt(circleValue - i + circleValue * j));
                }
            }
            // 0
            // 1,5
            // 2,4
            // 3
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        int numRows = 3;
        String str1 = "A"; int numRows1 =1;
        System.out.println(convert(str1, numRows1));
    }
}

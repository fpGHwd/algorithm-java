/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/23/19 9:48 AM
 */

package com.leetcode;

public class P0507 {

    public boolean checkPerfectNumber(int num){
        if(num == 0)return false;
        if(num == 1)return true;

        int sum = 1;
        for(int i = 2; i * i <= num; i++){
            if(num%i==0)sum += i + ((num/i==i)?0:(num/i));
        }
        if(sum == num)return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(new P0507().checkPerfectNumber(28));
        System.out.println((int)9.9999);
    }
}

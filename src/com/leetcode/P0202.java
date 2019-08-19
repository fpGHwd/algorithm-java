/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/17/19 10:54 AM
 */

package com.leetcode;

public class P0202 {

    public static int hashTable[] = new int[1200];

    public boolean isHappy(int n) {
        int temp;

        do{
            temp = 0;
            while(n > 0){
                temp += (n%10)*(n%10);
                n = n/10;
            }
            if(hashTable[temp] != 0)break;
            else{
                hashTable[temp] = 1;
                n = temp;
            }
        }while(1 == 1);

        if(temp == 1)return true;
        else return false;
    }

    // 循环中必定有4是为什么

    public static void main(String[] args) {
        int n = 19, n2 =13;
        System.out.println(new P0202().isHappy(n));

    }
}

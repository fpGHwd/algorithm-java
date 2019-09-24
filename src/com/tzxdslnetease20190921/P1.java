package com.tzxdslnetease20190921;

import javafx.scene.Scene;

import java.util.Scanner;

public class P1 {

    public static String minDecadeNumericSum(int sum){
        int k = sum;
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < k/9; i++){
            ret.append('9');
        }
        if(k%9!=0)
            ret.insert(0, (char)('0' + k % 9));
        return ret.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        int n;
        for(int i = 0; i <T; i++){
            n = sc.nextInt();
            System.out.println(minDecadeNumericSum(n));
        }
    }

}

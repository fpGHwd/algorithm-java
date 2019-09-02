/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 9/1/19 8:40 PM
 */

package com.tencent20190901;

import java.util.Arrays;
import java.util.Scanner;

public class P2 {


    public void Main(){

        Scanner scanner = new Scanner(System.in);

        int n;
        n = scanner.nextInt();

        if(n==0){
            System.out.println("0");
            return;
        }

        int[] minus = new int[n];

        int a, b;
        long sumA= 0, sumB =0;
        for(int i = 0; i < n; i++){
            a = scanner.nextInt();
            b = scanner.nextInt();
            sumA += a;sumB += b;
            minus[i] = a-b;
        }

        Arrays.sort(minus);

        long result = 0;
        result -= sumA;
        result += n * sumB;

        for(int i = n-1; i >=0; i--){
            result += minus[i] * (n-i);
        }

        System.out.println(result);

    }

    public static void main(String[] args) {
        new P2().Main();
    }

    /**
     * 2
     * 1 1
     * 2 2
     *
     * 3
     */

    /**
     * 3
     * 1 3
     * 1 1
     * 4 1
     *
     * 6
     */

}

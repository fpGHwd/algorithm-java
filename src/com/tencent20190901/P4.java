/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 9/1/19 9:44 PM
 */

package com.tencent20190901;

import java.util.Scanner;

public class P4 {

    public void Main(){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] scores = new int[n];
        for(int i = 0; i < n; i++){
            scores[i] = scanner.nextInt();
        }

        long result = 0;
        for(int i = 0; i < n; i++){
            int min = scores[i];
            long sum = 0;
            for(int j = i; j < n; j++){
                sum += scores[j];
                if(scores[j] < min) min = scores[j];
                if(sum * min > result)result = sum*min;
            }
        }

        System.out.println(result);

    }

    public static void main(String[] args) {
        new P4().Main();
    }

    /**
     * 5
     * 7 2 4 6 5
     *
     * 60
     */
}

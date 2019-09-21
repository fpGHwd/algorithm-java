/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 9/18/19 7:56 PM
 */

package com.aqiyi20190918;

public class P1 {

    /**
     * @param A:
     * @return: nothing
     */
    public static long playGames(int[] A) {
        int max = 0;
        for (int a : A) {
            max = Math.max(a, max);
        }
        long l = 0, r = max * 2;
        while (l < r) {//cnt表式某一人完成时的游戏次数
            long m = (l + r) / 2;
            long cnt = 0;
            for (int a : A) {
                cnt += Math.max(m - a, 0);
            }
            if (m > cnt) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return Math.max(l, max);
    }

    public static void main(String[] args) {
        System.out.println(playGames(new int[]{2,2,3}));
    }
}

/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 5/22/19
 * @Time: 9:27 PM
 * @Project: algorithm
 */

package com.jzoffer;

public class P3 {
    private static boolean findNumberInTwoDimensionArray(int target, int[][] arrays){
        if(arrays == null)return false;
        int row = arrays.length-1, col = arrays[0].length-1, x = row, y=0;

        boolean found = false;

        while(x >= 0 && y <= col) {
            if (arrays[x][y] > target) {
                x--;
            } else if (arrays[x][y] == target) {
                found = true;
                break;
            } else {
                y++;
            }
        }

        return found;
    }


    public static void main(String[] args) {
        int[][] arrays = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int target = 14;
        System.out.println(findNumberInTwoDimensionArray(target,arrays));
    }
}

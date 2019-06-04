/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: HydroCloud
 * @Date: 5/29/19
 * @Time: 5:54 PM
 */

package com.jzoffer;

public class P8 {
    public static void main(String[] args) {
        int[] array = {1,4,2,5,2,8,4,2,7,1,3,13,52,17,34,22,-5,60,99,38,19};
        quickSort(array, 0, array.length-1);
    }

    static int partion(int[] arr, int start, int end){
        if(start >= end)return start;
        int t = arr[start];
        while(start < end){
            while(start < end && arr[end] >= t)end--;
            arr[start] = arr[end];
            while(start < end && arr[start]<= t)start++;
            arr[end] = arr[start];
        }
        arr[start]= t;
        return start;
    }

    static void quickSort(int[] arr, int start, int end){
        if(start == end)return;

        int k = partion(arr , start,end);
        if(k > start)
            quickSort(arr,start,k-1);
        if(k < end)
        quickSort(arr, k+1, end);
    }
}

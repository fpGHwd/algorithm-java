package com.tzxdslnetease20190921;

import java.util.Scanner;

class P2 {
    public static int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        int count = 1,sum= nums[0], maxCount = 1;
        for(int i=1;i<nums.length - 1;i++){
            if(sum < nums[i]){
                sum+= nums[i];
                count++;
                if(count > maxCount)maxCount = count;
            }else{
                count = 1;
                sum = nums[i];
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int n = sc.nextInt();
            int array[] = new int[n];
            for(int j = 0; j < n; j ++){
                array[j] = sc.nextInt();
            }
            System.out.println(findLengthOfLCIS(array));
        }
    }
}
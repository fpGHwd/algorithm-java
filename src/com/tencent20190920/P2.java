/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 9/20/19 8:39 PM
 */

package com.tencent20190920;


import java.util.*;

public class P2 {

    static class WorkTime{
        int time;
        int nums;

        WorkTime(int t, int n){
            time = t;
            nums = n;
        }
    }


    Comparator<WorkTime> comparator = new Comparator<WorkTime>() {
        @Override
        public int compare(WorkTime o1, WorkTime o2) {
            return o1.time - o2.time;
        }
    };

    public int minTime(List<WorkTime> times, int M){
        Collections.sort(times,comparator);
        int max = 0;
        int left = 1, right = 1;
        int leftIdx = 0, rightIdx = times.size()-1;
        while(leftIdx < rightIdx || (leftIdx == rightIdx && left + right <= times.get(leftIdx).time)){
            if(left > times.get(leftIdx).nums){
                leftIdx++;
                left = 1;
            }
            if(right > times.get(rightIdx).nums){
                rightIdx--;
                right=1;
            }
            int t = times.get(leftIdx).time + times.get(rightIdx).time;
            left++;
            right++;
            if(t > max)max = t;
        }
        return max;
    }

    public static void main(String[] args) {
        List<WorkTime> lwt = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), num, time,M = 0;
        for(int i = 0; i < n; i++){
            num = sc.nextInt();
            M += num;
            time = sc.nextInt();
            lwt.add(new WorkTime(time,num));
        }
        System.out.println(new P2().minTime(lwt,M));
    }

}


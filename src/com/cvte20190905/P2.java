package com.cvte20190905;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2 {
    static int findSecondScore(List<Integer> classOneScore, List<Integer> classTwoScore){
        Integer[] a1 = classOneScore.toArray(new Integer[classOneScore.size()]);
        Integer[] a2 = classTwoScore.toArray(new Integer[classTwoScore.size()]);
        Integer[] a3 = new Integer[a1.length + a2.length];
        System.arraycopy(a1,0,a3,0,a1.length);
        System.arraycopy(a2,0,a3, a1.length,a2.length);

        Arrays.sort(a3);

        int idx = a3.length-1;
        while(idx > 0 && a3[idx] == a3[idx-1]){
            idx--;
        }
        if(idx>0)return a3[idx-1];
        else
            return -1;
    }

    public static void main(String[] args) {
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        one.add(100);
        one.add(100);
        one.add(98);
        one.add(99);
        one.add(98);
        one.add(94);

        two.add(100);
        two.add(70);
        two.add(100);
        two.add(100);

        System.out.println(findSecondScore(one, two));
    }
}

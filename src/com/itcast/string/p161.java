/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       19-5-11
 * @Time:       上午10:49
 * @Project:    algorithm
 */

package com.itcast.string;

import org.junit.Test;

public class p161 {
    // 字符串反转

    public String reverse(String str){
//        char[] cs = str.toCharArray();
//        for(int start = 0,end = str.length()-1; start < end; start++,end--){
//            swap(cs, start, end);
//        }
//
//        return new String(cs); // 原来是这个函数，， 不要用toString();

        return reverse(str, 0,str.length()); // 复用代码

    }


    public String reverse(String str, int start, int end){
        char[] cs = str.toCharArray();
        // 可以在定义一个start和end
        for(start = start,end= end-1; start < end; start++,end--){
            swap(cs, start, end);
        }

        return new String(cs); // 原来是这个函数，， 不要用toString();
    }



    public void swap(char[] arr, int x, int y){
        char t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }

    @Test
    public void testMyReverse(){
        String ts = "big endian";
        System.out.println(reverse(ts));
        System.out.println(reverse(ts, 4,ts.length()-1));
    }

    // big endian
    // naidne gib


    /**
     * naidne gib
     * big naidne
     */

    /**
     * start和end包含头，不包含尾。所以end = end-1
     * （为了用起来方便。惯例）
     */



}

package com.cvte20190905;

public class P1 {

    public static long getResult(long n){
        if(n == 0)return 0L;
        long k = (long)Math.floor(Math.log((double)n/5 + 1)/Math.log(2.0));
        if((Math.pow(2,k)-1)*5==n){
            return k*5;
        }else{
            return n-5L*((long)Math.pow(2,k)-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(getResult(1));
        System.out.println(getResult(15));
        System.out.println(getResult(100));
    }
}

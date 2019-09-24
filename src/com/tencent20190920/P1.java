package com.tencent20190920;

import java.util.Scanner;

public class P1 {


    public boolean checkNumber(String s){
        if(s.length() < 11)return false;
        else{
            if(s.indexOf('8') <= s.length()-11){
                return true;
            }else{
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nStr = sc.nextLine(),lenStr;
        int n = Integer.valueOf(nStr), len;
        String str;
        P1 p1 = new P1();
        for(int i = 0; i < n; i++){
            lenStr = sc.nextLine();
            len = Integer.valueOf(lenStr);
            str = sc.nextLine();
            if(len < 11) System.out.println(false);
            else{
                System.out.println(p1.checkNumber(str));
            }


        }
    }
}

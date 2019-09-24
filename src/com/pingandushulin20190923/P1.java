package com.pingandushulin20190923;

import java.util.Scanner;

public class P1 {

    public void reWrite(String a){
        int i ;
        for(i = 0; i < a.length()-3; i++){

            if((int)a.charAt(i+1)-(int)a.charAt(i)==1 && (int)a.charAt(i+2)-(int)a.charAt(i+1) ==1 && (int)a.charAt(i+3)-(int)a.charAt(i+2) ==1){
                int k = 1;
                while((i+3+k) < a.length() && (int)a.charAt(i+3+k) - (int)a.charAt(i+2+k)==1)k++;
                System.out.print(a.charAt(i) + "-" + a.charAt(i+2+k));
                i+=(2+k);
            }else{
                System.out.print(a.charAt(i));
            }
        }

        if(i < a.length()){
            for(; i < a.length(); i++){
                System.out.print(a.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
//        String s = "1234abcD";
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        new P1().reWrite(s);
    }
}

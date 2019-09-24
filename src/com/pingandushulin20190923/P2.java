package com.pingandushulin20190923;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Scanner;

public class P2 {

    public boolean isHomogeneous(String a, String b){
        int A[] = new int[255], B[] = new int[255];
        for(int i = 0; i < a.length(); i++)
            A[(int)a.charAt(i)]++;
        for(int i = 0; i < b.length(); i++)
            B[(int)b.charAt(i)]++;
        for(int i = 0; i < 255; i++)
            if(A[i] != B[i])
                return false;
        return true;
    }

    public static void main(String[] args) {
//        String a = "abc", b = "bac";
//        System.out.println(new P2().isHomogeneous(a,b));
        Scanner sc = new Scanner(System.in);
        String input[] = sc.nextLine().split(" ");
        String a = input[0], b = input[1];
        System.out.println(new P2().isHomogeneous(a,b));
    }
}

<<<<<<< HEAD
/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 9/20/19 8:22 PM
 */

=======
>>>>>>> 1f9b7804267712b6583f07e4e1283552d94b6c41
package com.tencent20190920;

import java.util.Scanner;

public class P1 {
<<<<<<< HEAD
    public boolean checkNumber(String s){
        if(s.length() < 11 )return false;
        else if(!s.matches("[0-9]+")){
            return false;
        }
        else{
            if(s.indexOf('8') <= s.length()-11)
                return true;
            else
                return false;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String nStr = sc.nextLine(),lenStr;
        int n = Integer.valueOf(nStr), len;
        String str;

        String s;

        P1 m = new P1();

=======


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
>>>>>>> 1f9b7804267712b6583f07e4e1283552d94b6c41
        for(int i = 0; i < n; i++){
            lenStr = sc.nextLine();
            len = Integer.valueOf(lenStr);
            str = sc.nextLine();
<<<<<<< HEAD
            if(len < 11)System.out.println("NO");
            else
                if(m.checkNumber(str))
                    System.out.println("YES");
                else
                    System.out.println("NO");
        }
    }
}
=======
            if(len < 11) System.out.println(false);
            else{
                System.out.println(p1.checkNumber(str));
            }


        }
    }
}
>>>>>>> 1f9b7804267712b6583f07e4e1283552d94b6c41

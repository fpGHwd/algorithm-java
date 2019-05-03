/**
 * @author suzumiya
 * @data 4/10/19 7:05 PM
 */

package com.huawei;


import java.util.Scanner;
import java.util.Stack;

public class Problem20190410 {

    static Stack<Character> embrace = new Stack<Character>();

    public static StringBuilder printReverse(String s,StringBuilder sb){
        if(s.length() == 1){
//            System.out.print(s.charAt(0));
            return sb.append(s);
        }else{
            char c = s.charAt(s.length()-1);
            if(c == '}' || c == ']' || c== ')'){
                embrace.push(c);
                for(int i = 0; i < s.charAt(0); i++){
//                    if(c == )
                }

                int len = s.length();
                int idx = len-1;
                for(; !((c == '}' && s.charAt(idx) == '{')||(c==']' &&s.charAt(idx) == '[') || c==')' && s.charAt(idx) == '(');idx--);
                int cnt, n_idx = idx-1;
                while('0'<= s.charAt(n_idx) && s.charAt(n_idx)<='9' && n_idx >=0 ){
                    n_idx--;
                }
                String cnt_s = s.substring(n_idx+1, idx);
                cnt = Integer.parseInt(cnt_s,10);


                for(int i = 0; i<cnt; i++){
                    sb.append(s.substring(idx+1, len-1));
                }
                return sb;
//                printReverse(s.substring(0,s.length()-2));
            }else{
                return printReverse(s.substring(0,s.length()-2),sb);
            }

        }

    }


    public static void main(String[] argv){
        Scanner reader=new Scanner(System.in);
        StringBuilder temp = new StringBuilder(), temp1 = new StringBuilder();
        if(reader.hasNextLine()){
            temp.append(reader.nextLine());
        }

        System.out.print(printReverse(temp.toString(), temp1));
    }
}

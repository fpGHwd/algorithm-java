package com.huya20190902;

import java.util.*;


public class P2 {

    static Map<Character,Integer> map = new HashMap<>();
    static Stack<Integer> ns = new Stack<>();
    static Stack<Character> os = new Stack<>();

    public static int cal(String exp){

        int num = 0;

        boolean computeFlag = false;

        for(int i = 0; i < exp.length(); i++){
            char c = exp.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }else{
                ns.push(num);
                num = 0;
                if(computeFlag){
                    ns.push(calculate(ns.pop(),ns.pop(),os.pop()));
                }

                if(!os.isEmpty()) {
                    if (map.get(c) > map.get(os.peek())) {
                        computeFlag = true;
                    } else {
                        ns.push(calculate(ns.pop(), ns.pop(), os.pop()));
                        computeFlag = false;
                    }
                    os.push(c);
                }else{
                    os.push(c);

                }
            }
        }

        ns.push(num);

        return calculate(ns.pop(),ns.pop(),os.pop());
    }

    static int calculate(int a, int b, char op){
        int cal;
        if(op == '*'){
            cal = b * a;
        }else if(op == '+'){
            cal = b + a;
        }else{ // '-'
            cal = b - a;
        }
        return cal;
    }

    public static void main(String[] args) {
        map.put('*',2);map.put('+',1);map.put('-',1);
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
//        System.out.println(line);

        System.out.println(cal(line));
    }

}

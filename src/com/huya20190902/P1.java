package com.huya20190902;

public class P1 {

    public static void main(String[] args) {
        String s = "2019 huya java";
        System.out.println(String2Int(s));
    }

    public static int String2Int(String s){
        boolean isPositive = true;//初始为正数
        if (s.length() == 0 || s == null)
            return 0;
        if (s.charAt(0) != '+')
            if (s.charAt(0) != '-')
                if (!(s.charAt(0) >= '0' && s.charAt(0) <= '9'))
                    return 0;
        if (s.charAt(1) == '-')
            isPositive = false;
        int result = 0;
        int digit = 1;
        for (int i = s.length() - 1; i >= 2; i--){
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                result += ((s.charAt(i) - '0') * digit);
                digit *= 10;
            }
        }

        return isPositive ? result : -result;
    }

}

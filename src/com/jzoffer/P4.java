/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 5/22/19
 * @Time: 9:43 PM
 * @Project: algorithm
 */

package com.jzoffer;

public class P4 {
    public static void main1(String[] args) {
        String str1 = "hello world";
        String str2 = "hello world";

        System.out.println(str1== str2);
    }

    // 只有动才能理解啊。所以并没有什么特别的。所以有人知道为什么要跑步和走路时思考。其实就是让自己动起来的想法

    // adjust的感觉，大的系统就是这样的。比如emacs-org，不是一下就能弄好的，只能一步一步来


    static String insertSymbol(String ori) {
        int c = 0;
        for (int i = 0; i < ori.length(); i++) {
            if (ori.charAt(i) == ' ') {
                c++;
            }
        }

        char[] ret = new char[2 * c + ori.length()];
        int x = ori.length() - 1, y = ret.length;
        while (x >= 0) {
            if (ori.charAt(x) != ' ') {
                y--;
                ret[y] = ori.charAt(x);
            } else {
                y = y - 3;
                ret[y] = '%';
                ret[y + 1] = '2';
                ret[y + 2] = '0';
            }
            x--;
        }

        StringBuilder sb =new StringBuilder();
        for(int i =0; i < ret.length; i++){
            sb.append(ret[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String ori = "We are happy.";
        String ret = insertSymbol(ori);
        System.out.println(ret);
    }
}

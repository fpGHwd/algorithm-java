/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 9/5/19 5:02 PM
 */

package com.kmp;

public class KMP {
    String test = "abc";

    public static void change(String tse){
        tse = "bc";
    }

    public static void main(String[] args) {
        KMP k = new KMP();
        k.change(k.test);
        System.out.println(k.test);
    }
}

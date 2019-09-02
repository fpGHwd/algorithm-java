/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 9/2/19 10:21 AM
 */

package com.jdk.niuke;

public class Test {
    public static void main(String[] args) {
        System.out.println("return value of getValue(): " +
                getValue());
    }
    public static int getValue() {
        try {
            return 0;
        } finally {
            return 1;
        }
    }
}
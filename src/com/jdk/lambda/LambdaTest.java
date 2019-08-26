/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/24/19 4:18 PM
 */

package com.jdk.lambda;

import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.Date;

public class LambdaTest {

    public static void main(String[] args) {
        Comparator<String> comp = (first, second)->first.length() - second.length();
        ActionListener listener = event-> System.out.println("The time is " + new Date());
    }
}

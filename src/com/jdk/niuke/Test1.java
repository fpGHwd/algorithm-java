/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 9/2/19 10:22 AM
 */

package com.jdk.niuke;

class Test2 {
    public static void hello() {
        System.out.println("hello");
    }
}

public class Test1 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Test2 test=null;
        test.hello(); // 还是有静态方法的
    }
}

/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/4/19
 * @Time:       4:52 PM
 * @Project:    algorithm
 */

package com.itcast.p125;

interface A {
}

class B implements A {
    public String func() {
        return "func";
    }
}

public class Demo3 {

    public static void main(String[] args) {
        A a = new B(); // 多态
//        System.out.println(a.func());
    }
}

// 编译不通过：A接口中没有func()方法
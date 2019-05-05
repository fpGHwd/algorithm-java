/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/4/19
 * @Time:       5:09 PM
 * @Project:    algorithm
 */

package com.itcast.object.p125;

interface Inter{
    void show(int a, int b);
    void func();
}

public class Demo7 {
    public static void main(String[] args){
        // 补足代码：调用两个函数，匿名内部类
        Inter i = new Inter() {
            public void show(int a, int b) {
                System.out.println("show");
            }

            public void func() {
                System.out.println("func");
            }
        };
        i.show(1,2);
        i.func();
    }
}

/*
主要是函数内部的public，不能王乐
 */
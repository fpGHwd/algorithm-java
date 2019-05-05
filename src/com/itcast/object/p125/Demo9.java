/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/4/19
 * @Time:       5:30 PM
 * @Project:    algorithm
 */

package com.itcast.object.p125;

class Demo{
    int show(int a, int b){return 0;}
}

public class Demo9 extends Demo {
//    public int show(int a, int b){return 0;}; // 可以
//    private int show(int a, int b){return 0;}  // 不可以，权限不够 // 即覆盖的权限，子类方法要大
//    private int show(int a, long b){return 0;} // 可以，相当于虫灾
//    public short show(int a, int b){return 0;} // 不可以，没有冲在
//    static int show(int a, int b){return 0;}  // 不可以，静态只能冲在静态
}


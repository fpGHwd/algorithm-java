/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/4/19
 * @Time:       5:41 PM
 * @Project:    algorithm
 */

package com.itcast.p125;

interface A1{
    void show();
}

interface B1{
    void add(int a, int b);
}

class C1 implements A1,B1{
    // 程序代码
    int addition;
    public void show(){ // 要有public
        System.out.println(addition);
    }

    public void add(int a, int b){
        this.addition = a+b;
    }
}

public class Demo12 {
    public static void main(String[] args){
        C1 c = new C1();
        c.add(4,2);
        c.show(); // 通过该函数打印以上两个数的和。
    }

}

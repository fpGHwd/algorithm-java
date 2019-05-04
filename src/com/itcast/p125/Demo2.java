/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/4/19
 * @Time:       4:50 PM
 * @Project:    algorithm
 */

package com.itcast.p125;

class Test{
    Test(){
        System.out.println("Test");
    }
}

public class Demo2 extends Test {
    Demo2(){
        System.out.println("Demo");
    }

    public static void main(String[] args){
        new Demo2();
        new Test();
    }
}

/*
Test
Demo
Test

子类的实例化过程
 */
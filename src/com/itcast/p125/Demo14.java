/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/4/19
 * @Time:       5:49 PM
 * @Project:    algorithm
 */

package com.itcast.p125;

class Fu2{
    int i = 0;
//    Fu2(){
//        i = 1;
//    }
    Fu2(String s){
        i = 2;
    }
}

public class Demo14 extends Fu2{
//    Demo14(String s){
//        // super();
//        i = 3;
//    }

    Demo14(String s){ // 自己写的
        // super();
        super(s);
        i = 3;
    }

    public static void main(String[] args){
        Demo14 d = new Demo14("yes");
        System.out.println(d.i);
    }
}

// debug以下顺序就可以了

// 原题是 没有Fu的无参构造方法，编译失败：父类缺少空参数的构造函数
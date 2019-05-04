/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/4/19
 * @Time:       5:58 PM
 * @Project:    algorithm
 */

package com.itcast.p125;

class Super1{
    public int get(){return 4;}
}

public class Demo15 extends Super1 {
//    public long get(){
//        return 5;
//    }

    public static void main(String[ ] args){
        Super1 s = new Demo15();
        System.out.println(s.get());
    }
}

// 编译失败，子类没有覆盖父类的get方法，子类返回的时候不知道返回什么类型。
// 所以注释掉子类的同名方法

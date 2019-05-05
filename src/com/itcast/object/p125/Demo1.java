/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/4/19
 * @Time:       4:43 PM
 * @Project:    algorithm
 */

package com.itcast.object.p125;

public class Demo1 {
    // 只有自己全部还原了，就说明找到关键的地方了。复盘很重要。

    public static void func() throws Exception{ // 原题这里没有throws Exception编译失败
        try{
            throw new Exception();
        }finally {
            System.out.println("b");
        }
    }

    public static void main(String[] args){
        try{
            func();
            System.out.println("a");
        }catch (Exception ex){
            System.out.println("c");
        }
        System.out.println("d");
    }
}

/*
抛出了一个编译时异常而且没有处理（方法上没有声明该异常）

b
c
d
 */


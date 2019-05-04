/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/4/19
 * @Time:       6:01 PM
 * @Project:    algorithm
 */

package com.itcast.p125;

public class Demo16 {

    public static void func(){
        try{
            throw new Exception();
//            System.out.println("A"); // unreachable statement也编译不通过吗？
        }catch (Exception e){
            System.out.println("B");
        }
    }

    public static void main(String[] args){
        try{
            func();
        }catch (Exception ex){
            System.out.println("C");
        }
        System.out.println("d");
    }
}

/*
B
d
做出来了.
 */

/*
编译失败。 因为打印“A”的输出豫剧执行不到。就像return后面不能放语句。。。

和13题的差别：13题的异常被函数封装了，但是这里没有封装。必定执行不到啊。
方法throws 异常，是可能出问题，不是一定出异常。
 */
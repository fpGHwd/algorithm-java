/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/4/19
 * @Time:       6:26 PM
 * @Project:    algorithm
 */

package com.itcast.p125;

public class Demo20 {
    public static String output= "";
    public static void foo(int i){
        try{
            if(i == 1)
                throw new Exception();
            output+="1";
        }catch (Exception e){
            output+="2";
            return;
        }finally {
            output+="3";
        }
        output+="4";
    }

    public static void main(String[] args){
        foo(0);
        System.out.println(output); // "134"
        foo(1);
        System.out.println(output); // "1342"
    }
}

// 其实搞清楚三个区很多东西都搞清除了，所以说java的编译，核心就是三个区。

// 第二个应该是"13423"为什么？finally还是要执行的。
// debug以下：先经过2，在到finally，然后回到2后面的return；
// return 之前看有没有finally，否则先执行finally
/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/4/19
 * @Time:       5:03 PM
 * @Project:    algorithm
 */

package com.itcast.p125;

interface C{} // interface A{}

class D implements C{
    public String test(){
        return "yes";
    }
}


public class Demo5 {
    static C get(){
        return new D();
    }

    public static void main(String[] args){
        C c = get();
//        System.out.println(c.test()); //
    }
}

/*
编译失败，C接口中没有test方法
 */
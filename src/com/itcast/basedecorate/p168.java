/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       19-5-11
 * @Time:       下午3:33
 * @Project:    algorithm
 */

package com.itcast.basedecorate;

import org.junit.Test;

public class p168 {

    // JDK 1.5版本心痛性

    @Test
    public void test(){
        Integer x = new Integer("123");
        Integer y = new Integer(123);
        System.out.println("x==y : " + (x==y)); // false
        // 不相等，因为是不同的对象
        System.out.println("x.equals(y): " + x.equals(y)); // true
    }

    @Test
    public void test1(){
        Integer x = 4; // JDK1.5，自动装箱。简化书写，方便运算
        x = x + 2; // 自动拆箱，在装箱，x.intValue()
        System.out.println(x);
        // 此时这是会出现Integer x = null的情况

        Integer m = 128;
        Integer n = 128;
        System.out.println("m==n: " + (m==n)); // false;

        Integer a = 127;
        Integer b = 127;
        System.out.println("a==b: " + (a==b)); // true;
        /**
         * 因为a和b指向了同一个Integer对象
         * 当数值载byte范围内容，对于新特性，如果该值已经存在，则不会再开辟新的空间。
         */

        /**
         * 序列化的思想，或许他们早就已经明白了。。。
         */


    }
}

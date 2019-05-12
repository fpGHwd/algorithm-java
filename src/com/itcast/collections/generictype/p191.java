/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/12/19
 * @Time:       6:14 PM
 * @Project:    algorithm
 */

package com.itcast.collections.generictype;


import org.junit.Test;

class Demo<T> {
    public <T> void show(T t){
        System.out.println("show: " + t);
    }

    public <T> void print(T t){
        System.out.println("print: " + t);
    }
}

public class p191 {
    /**
     * 泛型方法
     */

    @Test
    public void testDemoGenericMethod(){

        Demo<String> ds =  new Demo<>();
        String s = "abc";
        ds.show(s);
        ds.print(s);

        Demo<Integer> di = new Demo<>();
//        Integer i = new Integer(100);
        Integer i = 100;
        di.show(i);
        di.print(i);


        /**
         * show: abc
         * print: abc
         * show: 100
         * print: 100
         */

        /**
         * 此时不能ds方法调用100,或者di方法调用string
         */


        /**
         * 集合就是泛型啊。。。collection
         */
    }
}

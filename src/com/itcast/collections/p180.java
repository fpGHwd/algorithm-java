/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/12/19
 * @Time:       10:40 AM
 * @Project:    algorithm
 */

package com.itcast.collections;


import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

class Demo{

    public int hashCode(){
        return 60;
    }
}


public class p180 {
    // 一些关键的问题的点。。其实就是一些软联系如何建立起来就是人这个复杂的思维应该做的。
    // 任何东西都有联系的点。比如问题：
    // 如何选择ArrayList和LinkedList就是一个重要的问题。取决于环境。
    // 所以要描述环境。可以依据ArrayList和LinkedList本身的特点来理解环境
    // 查询比较多呀ArrayList
    // 增删比较多用LinkedList
    // 当然其实增删比较少。。实在不知道用什么用ArrayList

    // Set的功能和Collections的功能是重复的。


    // 对象
    // hash值
    // 地址

    /**
     * 如何区分这几个概念：对象地址，hash值，equals等
     *
     */


    @Test
    public void testHashCode(){
        Demo d1 = new Demo();
        Demo d2 = new Demo(); // 复制用的多也有好处，不要自己写。有助于抽象。

        System.out.println(d1);
        System.out.println(d2);


        /**
         * com.itcast.collections.Demo@3c
         * com.itcast.collections.Demo@3c
         */

        /**
         * 地址值一样，可能不一样的对象
         * 完全以hash值为主
         *
         */
    }


    @Test
    public void testHashSetDemo(){
        HashSet hs = new HashSet();
        System.out.println(hs.add("java01"));
        System.out.println(hs.add("java01")); // false
        System.out.println(hs.add("java02"));
        System.out.println(hs.add("java03"));
        System.out.println(hs.add("java04"));

        Iterator it = hs.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        /**
         * java04
         * java03
         * java02
         * java01
         *
         * 无序的
         */
    }

}

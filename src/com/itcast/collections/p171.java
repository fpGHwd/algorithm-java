/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       19-5-11
 * @Time:       下午7:39
 * @Project:    algorithm
 */

package com.itcast.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class p171 {
    /**
     * 元素的取出：迭代启
     */
    @Test
    public void testIterate(){
        ArrayList al1 = new ArrayList();
        al1.add("java01");
        al1.add("java02");
        al1.add("java03");
        al1.add("java04");
//        System.out.println(al1);


        Iterator it = al1.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        /**
         * [java01, java02, java03, java04]
         * java01
         * java02
         * java03
         * java04
         */


        /**
         * 老外的写法
         */
        for( it = al1.iterator(); it.hasNext();){
            System.out.println(it.next());
        } // 一样，好高端

        /**
         * while循环是一样的。
         * 但是for循环比while循环更优一点。it在内存中的占用。
         *
         * 老师写while
         * 你们写for
         *
         */

    }

    // Iterator是迭代启接口。理解迭代器用一个例子就可以了。
    // 多用 就是 这种谓词。可以获得很好的抽象。
    // 例如： 迭代器 就是 单个元素
    // 就是取元素用的：比如有没有元素，比如用什么顺序取元素，等等。。
    // 其实 迭代器 就是 取出 的这个操作（时空相近的东西啊啊啊啊）
    // 就是把 取出操作 封装成一个对象。。。。对象的思想。
    // 时空 这个词救了我。

    /**
     * 抓娃娃的夹子就是迭代器，要被封装在内部
     * 操纵杆就是这个容器给你暴露的功能。。。就是接口啊
     *
     * 迭代器就是传说中的夹子
     */

}

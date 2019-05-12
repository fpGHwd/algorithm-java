/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/12/19
 * @Time:       11:17 AM
 * @Project:    algorithm
 */

package com.itcast.collections;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

class Person{

    private String name;
    private int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    /**
     * 这个方法才是override
     * @param o
     * @return
     */
    public boolean equals(Object o){
        if(!(o instanceof Person))return false;
        Person p = (Person)o;

        // 查看这个方法的调用情况
        System.out.println(this.name + ".....equals...." + p.name);
        return this.name == p.name && this.age== p.age;
    }

    public int hashCode(){
//        return 60;
        System.out.println(this.name + "....hashCode");
//        return this.name.hashCode();
        return this.name.hashCode() + age *29;
    }

    /**
     * 这个方法并没有override功能
     * @param p
     * @return
     */
    public boolean equals(Person p){
        return this.name == p.name && this.age==p.age;
    }

}

public class p181 {
    // 存储自定义元素

    // 自定义元素可能是一样的（存储者认为）
    // 如果想要达到这种效果，必须重写equals方法
    // 并且如果对象的hashCode是不一样的，set载add的时候也不会调用equals方法，
    // 所以还需要重写hashCode方法。
    // 代表这两个东西不一样

    // 是3c吧？
    // （高三度）是的大家

    /**
     * 突然感觉，hashCode我都知道，但是以前都不知道怎么联系。通过数学来联系。
     * 所以其实很多东西你是知道的，只是没有联系起来。
     *
     */

    /**
     * hashset如何保证元素的一致性：
     * 通过两个，一个是hashcode方法，一个是equals方法。。。
     * hashcode方法是内存地址相关的量
     * equals是逻辑上的标识
     *
     * （这个问题很有意思）
     * 同一个类的不同逻辑对象在没有改写hashcode方法的前，默认的hashcode方法得到的基本
     * 是不同的hashcode，所以要使用逻辑的东西改写hashcode方法。（主键改写hashcode方法）
     * 主键不一样，那么应该不在同一个地址，也就是不同的hashcode
     *
     * 但是逻辑不同对象要用非主键去辨认不是同一个对象（非主键改写equals方法）
     * equal只有载内存地址不同的时候才会派上用场。
     */

    /**
     * 下面来还原这个过程(自定义对象)
     */


    @Test
    public void testHashSetDemo(){
        HashSet hs = new HashSet();
        hs.add(new Person("a1",11));
        hs.add(new Person("a2", 12));
        hs.add(new Person("a3", 13));
        hs.add(new Person("a2", 12));

        for(Iterator it = hs.iterator(); it.hasNext();){
            Person p = (Person)it.next();
            System.out.println(p.getName() + ": " + p.getAge());
        }


        /**
         * 没有添加任何条件的时候，这里会调用hashcode方法
         *
         * a1: 11
         * a2: 12
         * a2: 12
         * a3: 13
         *
         *
         *
         */


        /**
         * 仅改写equals方法
         *
         * a1: 11
         * a2: 12
         * a2: 12
         * a3: 13
         *
         * 没有调用一词equals方法。
         */

        /**
         * 仅仅改写hashCode方法，没有改写equal方法
         *
         *
         */

        /**
         * 改写hashcode方法（返回同一个hashcode）并且改写好equals方法
         *
         * a2.....equals....a1
         * a3.....equals....a1
         * a3.....equals....a2
         * a2.....equals....a1
         * a2.....equals....a2
         * a1: 11
         * a2: 12
         * a3: 13
         *
         * 缺点是判断太多，而且代码比较多
         * 尝试改写hashcode为字符串本身的hashcode
         */

        /**
         * 改写hashcode方法（返回字符串的hashcode）并且改写好equals方法
         *
         * 预计： 判断应该会比较少。。
         *
         * a2.....equals....a2
         * a1: 11
         * a2: 12
         * a3: 13
         *
         * 其实就是改写hashcode来减少equals的访问量？
         * 哈哈哈，转移了而已。也并不是什么特别难理解的东西啊。
         *
         */


        /**
         * 上面并在hashcode添加日志
         *
         * a1....hashCode
         * a2....hashCode
         * a3....hashCode
         * a2....hashCode
         * a2.....equals....a2
         * a1: 11
         * a2: 12
         * a3: 13
         */


        // 当一个对象往集合里存的时候，一般情况下都要复写hashCode方法和equasl方法

        // curiosity以及不带掩饰的curiosity其实代表的就是一种确定性。

        // 所以以上就是保证对象不同的一种方法。


        // 没有覆盖hashCode和equals方法都会造成set的失败
        // 比如 hashCode -> hasCode, 或者equals的签名是equals(Person p)等等都会造成这样的问题。
    }

}

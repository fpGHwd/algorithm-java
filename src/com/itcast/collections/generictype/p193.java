/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/12/19
 * @Time:       6:43 PM
 * @Project:    algorithm
 */

package com.itcast.collections.generictype;

import org.junit.Test;

interface Inter<T> {
    void show(T t);
}

class InterImpl implements Inter<String>{ // 哇，写得一样

    @Override
    public void show(String s) {
        System.out.println("show: " + s);
    }
}

class InterImpl1<T> implements Inter<T>{

    @Override
    public void show(T t) {
        System.out.println("show: " + t);
    }
}

public class p193 {
    /**
     * 泛型定义在接口上
     */

    @Test
    public void testGenericType(){
        InterImpl ii = new InterImpl();
        ii.show("hahah");

        InterImpl1<String> ii1 = new InterImpl1<>();
        ii1.show("hahaha");

        InterImpl1<Integer> ii2 = new InterImpl1<>();
        ii2.show(4);
    }


}

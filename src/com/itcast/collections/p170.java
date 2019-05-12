/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       19-5-11
 * @Time:       下午7:37
 * @Project:    algorithm
 */

package com.itcast.collections;

import org.junit.Test;

import java.util.ArrayList;

public class p170 {
    /**
     * 容器内部存储的都是内存地址
     *
     * 取交集会改变主动使用的容器的内容。还是挺好用的。
     *
     * 元素的添加删除和交集
     *
     * 现在是取出
     */


    @Test
    public void testAddItems(){
        ArrayList al1 = new ArrayList();
        al1.add("java01");
        al1.add("java02");
        al1.add("java03");
        al1.add("java04");
        ArrayList al2 = new ArrayList();
        al2.add("java04");
        al2.add("java05");
        al2.add("java06");
        al2.add("java07");

//        al1.contains(al2); // 应该是是否有交集
//        al1.retainAll(al2); // 取交集
        al1.removeAll(al2); // 取差集
        System.out.println("over");

    }

}

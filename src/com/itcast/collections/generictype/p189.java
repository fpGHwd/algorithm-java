/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/12/19
 * @Time:       4:49 PM
 * @Project:    algorithm
 */

package com.itcast.collections.generictype;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class p189 {
    // 泛型的尖括号就是用来存放类型的
    // 和传参数是一样的


    @Test
    public void testGenericType(){


        TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int cr = new Integer(o1.length()).compareTo(new Integer(o2.length()));
                if(cr != 0)return cr;
                else return o1.compareTo(o2);
            }
        });
        ts.add("abcd");
        ts.add("cc");
        ts.add("cba");
        ts.add("aaa");
        ts.add("z");
        ts.add("hahaha");


        for(Iterator<String> it = ts.iterator(); it.hasNext();){
            String s = it.next();
            System.out.println(s);
        }

        /**
         * aaa
         * abcd
         * cba
         * cc
         * hahaha
         * z
         *
         *
         * z
         * cc
         * aaa
         * cba
         * abcd
         * hahaha
         */


        /**
         * java.util.comparator是一个泛型接口。
         * 所以compare方法签名不和以前一样是Object，现在是String
         */
    }
}


class LenComparator implements Comparator<String>{
    @Override
    public int compare(String o1, String o2){
        return 0;
    }

    /**
     * 序列化-断言 的应用：
     * 如果想相反的排序结果，只需调换参数的o1和o2就可以了。不需要改内部代码。
     */
}

/**
 * 避免强转，使用代码避免了安全问题。
 *
 * 但是hashCode方法的强转不能避免。必须强转。
 *
 *
 * hashCode和Comparable方法
 * 既可以存放到HashSet中又可以存放到TreeSet中
 */

/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/12/19
 * @Time:       4:05 PM
 * @Project:    algorithm
 */

package com.itcast.collections;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class p187 {

    public static void main(String[] args){
        TreeSet ts = new TreeSet(new LengthComparator());
        ts.add("abcd");
        ts.add("cc");
        ts.add("cba");
        ts.add("aaa");
        ts.add("z");
        ts.add("hahaha");

        for(Iterator it = ts.iterator(); it.hasNext();){
            System.out.println(it.next());
        }

        /**
         * 自带的compareTo方法
         * abcd
         * cba
         * cc
         * hahaha
         * z
         *
         * 自己改写的comparetor
         *
         * z
         * cc
         * cba
         * abcd
         * hahaha
         *
         *
         *
         * 添加了一个长度相同的字符串（需要添加次要条件）后
         * abcd...compare....abcd
         * cc...compare....abcd
         * cba...compare....abcd
         * cba...compare....cc
         * aaa...compare....cba
         * aaa...compare....cc
         * z...compare....cba
         * z...compare....cc
         * hahaha...compare....cba
         * hahaha...compare....abcd
         * z
         * cc
         * aaa
         * cba
         * abcd
         * hahaha
         *
         * 其中有一个比较树的结构：但是好像并不完全是这样。。。。有可能是二分排序。和优化有关吧。
         *
         */

    }
}

/**
 * 按照字符串长度排序
 */
class LengthComparator implements Comparator{
    public int compare(Object o1, Object o2){
        String s1 = (String)o1, s2 = (String)o2;
        System.out.println(s1 + "...compare...." + s2);
        int l1 = s1.length(), l2 = s2.length();
        if(l1!=l2){
            return l1-l2;
            // attention
        }else{
            return s1.compareTo(s2);
        }


        /**
         * int num = new Integer(l1).compareTo(new Integer(l2));
         * if(num == 0) return s1.compareTo(s2);
         * else return num;
         *
         *
         * int num = new Integer(l1).compareTo(new Integer(l2));
         * if(num == 0) return s1.compareTo(s2);
         *
         * return num
         */


        /**
         * 采用匿名内部类也可以
         * 就是传入的Compare对象作为参数里面直接写方法。
         */
    }
}
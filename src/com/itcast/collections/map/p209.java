/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/13/19
 * @Time:       3:16 PM
 * @Project:    algorithm
 */

package com.itcast.collections.map;

import org.junit.Test;
import sun.security.util.Length;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class p209 {

    /**
     * reverseOrder
     */

    @Test
    public void testNode() {

    }

    @Test
    public void orderDemo() {
//        TreeSet<String> ts = new TreeSet<>();
//        TreeSet<String> ts = new TreeSet<>(Collections.reverseOrder()); // 真的可以。其实就是修改了内部的比较器。
//        TreeSet<String> ts = new TreeSet<>(new Com());
//        TreeSet<String> ts = new TreeSet<>(new LengthComparator());
        TreeSet<String> ts = new TreeSet<>(Collections.reverseOrder(new LengthComparator()));

        ts.add("abcde");
        ts.add("aa");
        ts.add("k");
        ts.add("ccc");

//        Collections.reverseOrder();

        for(Iterator<String> it = ts.iterator(); it.hasNext();){
            System.out.println(it.next());
        }


        /**
         *
         * 自然排序
         * aaa
         * abcde
         * ccc
         * kkk
         *
         * 自然排序相反
         * kkk
         * ccc
         * abcde
         * aaa
         *
         * origin 长度比较器
         * k
         * aa
         * ccc
         * abcde
         *
         * 反转长度比较器
         * abcde
         * ccc
         * aa
         * k
         */

    }

    class Com implements Comparator<String>{
        public int compare(String o1, String o2){
            return o2.compareTo(o1);
        }
    }

    class LengthComparator implements Comparator<String> {
        public int compare(String o1, String o2){
            int num = new Integer(o1.length()).compareTo(new Integer(o2.length()));
            if(num == 0)
                return o1.compareTo(o2);
            else
                return num;
        }
    }
}

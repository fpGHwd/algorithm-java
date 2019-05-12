/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/12/19
 * @Time:       12:59 PM
 * @Project:    algorithm
 */

package com.itcast.collections;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

public class p182 {

    @Test
    public void testHashSetDemo(){
        HashSet hs = new HashSet();
        hs.add(new Person("a1",11));
        hs.add(new Person("a2", 12));
        hs.add(new Person("a3", 13));
        hs.add(new Person("a2", 12));

//        for(Iterator it = hs.iterator(); it.hasNext();){
//            Person p = (Person)it.next();
//            System.out.println(p.getName() + ": " + p.getAge());
//        }
//        System.out.println(hs.contains(new Person("a2", 12)));  // true // 是否有存在的元素

//        System.out.println(hs.contains(new Person("a4", 11))); // 是否有不同name的元素，只判断hashCode

//        System.out.println(hs.remove(new Person("a3",13))); // true
        System.out.println(hs.remove(new Person("a5",13))); // 删除不同name的元素，只判断hashCode


        /**
         * arraylist判断元素只依赖equals
         * hashset先依赖hashcode然后是equals
         *
         * crud的操作基本可以联系到考虑一个数据结构的诸多方面。
         * 学习集合时如此。
         */
    }

}

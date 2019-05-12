/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/12/19
 * @Time:       2:25 PM
 * @Project:    algorithm
 */

package com.itcast.collections;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;


public class p186 {
    @Test
    public void testTreeSetSelfDefinedObject() {
        TreeSet ts = new TreeSet(new MyComparator());
        ts.add(new Student("lisi02", 22));
        ts.add(new Student("lisi007", 20));
        ts.add(new Student("lisi09", 19));
        ts.add(new Student("lisi01", 19));
        ts.add(new Student("lisi01", 28));

        for (Iterator it = ts.iterator(); it.hasNext(); ) {
            System.out.println(it.next().toString());
        }
    }
}

class MyComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        Student s1 = (Student)o1;
        Student s2 = (Student)o2;

        int cr = s1.getName().compareTo(s2.getName());
//        return cr;
        if(cr!=0){
            return cr;
        }else{
//            Integer i1 = s1.getAge(), i2 = s2.getAge();
//            return i1.compareTo(i2);
            return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
        }
        /**
         * 基本上毕老师一样的写法
         *
         * lisi007....20
         * lisi01....19
         * lisi01....28
         * lisi02....22
         * lisi09....19
         */

        /**
         * 整数的包装类
         *
         * lisi007....20
         * lisi01....19
         * lisi01....28
         * lisi02....22
         * lisi09....19
         */
    }
}

// comparator方式排序

// 集合一初始化就有排序功能，参阅构造函数

/**
 * TreeSet(Comparator<? super E> comparator)
 * Constructs a new, empty tree set, sorted according to the specified comparator.
 * <p>
 * 当元素本身不具备比较性。或者不是所需要的。
 * 这时要自己实现一个比较器。（其实就是比较的功能的）没有什么特别的
    */

/**
 * 当元素本身不具备比较性。或者不是所需要的。
 * 这时要自己实现一个比较器。（其实就是比较的功能的）没有什么特别的
 */


/**
 * 其实本质就是把排序抽出来成为一个对象而已。
 *
 */


/**
    当两种当时都存在时，以比较器为主


 接口就是提供对外的功能拓展。Comparator就是接口。就是提供功能拓展的

 玩项目，没有接口项目是死的，毫无拓展性可言。
 */
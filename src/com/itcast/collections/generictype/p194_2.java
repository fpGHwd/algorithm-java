/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/12/19
 * @Time:       10:49 PM
 * @Project:    algorithm
 */

package com.itcast.collections.generictype;


import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class Person3{
    private String name;
    Person3(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}

class Student3 extends Person3{
    Student3(String name){
        super(name);
    }
    public void setName(String name){
        super.setName(name);
    }

    public String getName(){
        return super.getName();
    }
}

/**
 * Comparable和Comparator是一样的
 *
 *  这个没有extends和super的关键词
 */
class Student4 implements Comparable<Student4>{

    @Override
    public int compareTo(Student4 o) {
        return 0;
    }
}

/**
 * Comparable 可用父类传入？ 。没有这种写法。。。Student5后面的Person3应该是Student5
 * 看看 java.lang.object里面的接口comparable
 */
//class Student5 implements Comparable<Person3>{
//
//    @Override
//    public int compareTo(Person3 o) {
//        return 0;
//    }
//}

/**
 * 比较器，可用该类传入
 */
class Cmp implements Comparator<Student3>{

    @Override
    public int compare(Student3 o1, Student3 o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

/**
 * 比较器，可写父类作为类型传入
 */
class Cmp1 implements Comparator<Person3>{

    @Override
    public int compare(Person3 o1, Person3 o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

/**
 * 讲extends的时候，还听得听懂。里面的特有方法可以指定父类和其子类可以使用。
 * 所以extends里面可能有父类特有方法。。
 *
 *
 * super呢，里面有多态吗？
 */

public class p194_2 {
    @Test
    public void testGenericTypeLimit(){
        TreeSet<Student3> tss = new TreeSet<>(new Cmp());
        tss.add(new Student3("s-ab1")); // 这里没有多态
        tss.add(new Student3("s-ac2"));
        tss.add(new Student3("s-aa3"));

        for(Iterator<Student3> is = tss.iterator(); is.hasNext();){
            System.out.println(is.next().getName());
        }

        /**
         * TreeSet(Comparator<? super E> comparator)    签名
         * addAll(Collection<? extends E> c)            签名
         */
        TreeSet<Student3> tss1 = new TreeSet<>(new Cmp1());
        tss1.add(new Student3("s-ab1")); // 这里是有多态的
        tss1.add(new Student3("s-ac2"));
        tss1.add(new Student3("s-aa3"));

        for(Iterator<Student3> is = tss1.iterator(); is.hasNext();){
            System.out.println(is.next().getName());
        }

        /**
         * s-aa3
         * s-ab1
         * s-ac2
         * s-aa3
         * s-ab1
         * s-ac2
         *
         * 明白了
         * super的作用在于可以写两个Comp
         *
         * super限定很少。。
         *
         * todo 组合泛型
         */

    }
}

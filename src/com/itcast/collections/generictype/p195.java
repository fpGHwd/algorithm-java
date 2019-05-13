/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/12/19
 * @Time:       11:29 PM
 * @Project:    algorithm
 */

package com.itcast.collections.generictype;


import org.junit.Test;

import java.util.Comparator;

import java.util.Iterator;
import java.util.TreeSet;

class Person5{
    private String name;
    Person5(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
}

class Student5 extends Person5{
    Student5(String name){
        super(name);
    }

    public void setName(String name){
        super.setName(name);
    }

    public String getName(){
        return super.getName();
    }
}

class Worker5 extends Person5{
    Worker5(String name){
        super(name);
    }

    public void setName(String name){
        super.setName(name);
    }

    public String getName(){
        return super.getName();
    }
}


class StuComp5 implements Comparator<Student5>{
    public int compare(Student5 o1, Student5 o2){
        return o1.getName().compareTo(o2.getName());
    }
}

class WorComp5 implements Comparator<Worker5>{
    public int compare(Worker5 o1, Worker5 o2){
        return o1.getName().compareTo(o2.getName());
    }
}

class AllComp implements Comparator<Person5>{
    public int compare(Person5 o1, Person5 o2){
        return o1.getName().compareTo(o2.getName());
    }
}

public class p195 {
    /**
     * 也就是super限定，可以写两个版本的比较器。
     * 当TreeSet<Student>时可以写比较器实现接口泛型Comparator<Student> 和 Comparator<Person>
     *
     * Student 和 Worker 都可以使用Person版本的比较器
     */

    @Test
    public void testGenericTypeLimit(){
        TreeSet<Student5> tss = new TreeSet<>(new StuComp5());
        tss.add(new Student5("abc--03"));
        tss.add(new Student5("abc--02"));
        tss.add(new Student5("abc--06"));
        tss.add(new Student5("abc--01"));

        for(Iterator<Student5> is5 = tss.iterator(); is5.hasNext();){
            System.out.println(is5.next().getName());
        }

        TreeSet<Worker5> tss1 = new TreeSet<>(new WorComp5());
        tss1.add(new Worker5("w-abc--03"));
        tss1.add(new Worker5("w-abc--02"));
        tss1.add(new Worker5("w-abc--06"));
        tss1.add(new Worker5("w-abc--01"));

        for(Iterator<Worker5> is5 = tss1.iterator(); is5.hasNext();){
            System.out.println(is5.next().getName());
        }

        /**
         * abc--01
         * abc--02
         * abc--03
         * abc--06
         * w-abc--01
         * w-abc--02
         * w-abc--03
         * w-abc--06
         */
    }

    @Test
    public void testAllComp(){
        TreeSet<Student5> tss = new TreeSet<>(new AllComp());
        tss.add(new Student5("abc--03"));
        tss.add(new Student5("abc--02"));
        tss.add(new Student5("abc--06"));
        tss.add(new Student5("abc--01"));

        for(Iterator<Student5> is5 = tss.iterator(); is5.hasNext();){
            System.out.println(is5.next().getName());
        }

        TreeSet<Worker5> tss1 = new TreeSet<>(new AllComp());
        tss1.add(new Worker5("w-abc--03"));
        tss1.add(new Worker5("w-abc--02"));
        tss1.add(new Worker5("w-abc--06"));
        tss1.add(new Worker5("w-abc--01"));

        for(Iterator<Worker5> is5 = tss1.iterator(); is5.hasNext();){
            System.out.println(is5.next().getName());
        }

        /**
         * abc--01
         * abc--02
         * abc--03
         * abc--06
         * w-abc--01
         * w-abc--02
         * w-abc--03
         * w-abc--06
         */

        /**
         * 一样的结果
         * Comparator<？ super E>看懂了就行了
         *
         * 有拓展性就有局限性。
         * 当用Person构造比较器时，内部只能用Person的方法
         */
    }


}

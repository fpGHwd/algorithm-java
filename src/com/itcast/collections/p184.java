/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/12/19
 * @Time:       1:24 PM
 * @Project:    algorithm
 */

package com.itcast.collections;

import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

class Student implements Comparable{
    private String name;
    private int age;

    Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public boolean equals(Object o){
        if(o instanceof Student)return false;
        Student s = (Student)o;
        System.out.println(this.name + "...equals..." + s.name);
        return this.name == s.name && this.age == s.age;
    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof Student)){
            throw new RuntimeException("不是学生对象");
        }
        Student s = (Student)o;
        System.out.println(this.name +"(age:" + this.age+")" +".....compareTo...."+ s.name +"(age:" + s.age+")");
        if(this.age!=s.age){
            return this.age-s.age;
        }else{
            return this.name.compareTo(s.name); // 字典序
        }
    }

    @Override
    public String toString(){
        return (this.name + "...." + this.age);
    }
}

public class p184 {
    // treeset存储自定义对象

    @Test
    public void testTreeSetSelfDefinedObject(){
        TreeSet ts = new TreeSet();
        ts.add(new Student("lisi02", 22)); //  comparable
        ts.add(new Student("lisi007", 20));
        ts.add(new Student("lisi09",19));
        ts.add(new Student("lisi01",19)); // 40-》19会丢失掉这个信息

        for(Iterator it = ts.iterator(); it.hasNext(); ){
            System.out.println(it.next().toString());
        }

        /**
         * lisi02(age:22).....compareTo....lisi02(age:22)
         * lisi007(age:20).....compareTo....lisi02(age:22)
         * lisi09(age:19).....compareTo....lisi02(age:22)
         * lisi09(age:19).....compareTo....lisi007(age:20)
         * lisi01(age:40).....compareTo....lisi007(age:20)
         * lisi01(age:40).....compareTo....lisi02(age:22)
         * lisi09....19
         * lisi007....20
         * lisi02....22
         * lisi01....40
         */

        /**
         * 问题：如果依据开始的compareTo方法，在遇到同一个年龄但名字不同的对象之后，后一个相同名字的对象并没有存入到TreeSet中。
         * lisi02(age:22).....compareTo....lisi02(age:22)
         * lisi007(age:20).....compareTo....lisi02(age:22)
         * lisi09(age:19).....compareTo....lisi02(age:22)
         * lisi09(age:19).....compareTo....lisi007(age:20)
         * lisi01(age:19).....compareTo....lisi007(age:20)
         * lisi01(age:19).....compareTo....lisi09(age:19)
         * lisi09....19
         * lisi007....20
         * lisi02....22
         */

        /**
         * 修改compareTo方法后，载age相等时用name的字典序来排序
         *
         * lisi02(age:22).....compareTo....lisi02(age:22)
         * lisi007(age:20).....compareTo....lisi02(age:22)
         * lisi09(age:19).....compareTo....lisi02(age:22)
         * lisi09(age:19).....compareTo....lisi007(age:20)
         * lisi01(age:19).....compareTo....lisi007(age:20)
         * lisi01(age:19).....compareTo....lisi09(age:19)
         * lisi01....19
         * lisi09....19
         * lisi007....20
         * lisi02....22
         */

        /**
         * 主要条件相同就排序次要条件，次要条件相同就是相同的。一样的就不用了。。会丢失信息。
         */
    }

}

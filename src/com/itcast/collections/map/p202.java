package com.itcast.collections.map;


import org.junit.Test;

import java.util.*;

public class p202 {

    /**
     * TreeMap
     *
     */
    @Test
    public void testMap(){
        // TreeSet和TreeMap都有比较器构造方法
//        TreeMap<Student, String> tm = new TreeMap<>(new AgeCom());
        TreeMap<Student, String> tm = new TreeMap<>(new NameCom());
        tm.put(new Student("lisi3", 23), "nanjing");
        tm.put(new Student("lisi1", 21), "beijing");
//        tm.put(new Student("lisi1", 21), "beijing");


        tm.put(new Student("lisi4", 24), "wuhan");
        tm.put(new Student("lisi2", 22), "shanghai");

        tm.put(new Student("lisi5", 19), "wuhan");

        /**
         * entrySet方法
         */
        Set<Map.Entry<Student, String>> smess = tm.entrySet();
        for(Iterator<Map.Entry<Student, String>> it = smess.iterator(); it.hasNext();){
            Map.Entry<Student, String> mess = it.next();
            System.out.println("key: " + mess.getKey()+ "value: " + mess.getValue());
        }

        /**
         * 比较浅
         *
         * key: lisi1..:..21value: beijing
         * key: lisi2..:..22value: shanghai
         * key: lisi3..:..23value: nanjing
         * key: lisi4..:..24value: wuhan
         * key: lisi5..:..19value: wuhan
         *
         * 比较厚
         * key: lisi5..:..19value: wuhan
         * key: lisi1..:..21value: beijing
         * key: lisi2..:..22value: shanghai
         * key: lisi3..:..23value: nanjing
         * key: lisi4..:..24value: wuhan
         *
         */


        /**
         * AgeCom
         * key: lisi5..:..19value: wuhan
         * key: lisi1..:..21value: beijing
         * key: lisi2..:..22value: shanghai
         * key: lisi3..:..23value: nanjing
         * key: lisi4..:..24value: wuhan
         *
         *
         * NameCom
         * key: lisi1..:..21value: beijing
         * key: lisi2..:..22value: shanghai
         * key: lisi3..:..23value: nanjing
         * key: lisi4..:..24value: wuhan
         * key: lisi5..:..19value: wuhan
         */

    }

    /**
     * tree都有比较器
     */
    class AgeCom implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            if(o1.age != o2.age){
                return o1.age - o2.age;
            }else{
                return o1.name.compareTo(o2.name);
            }
//            return 0;
        }
    }

    class NameCom implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            int num = o1.getName().compareTo(o2.getName());
            if(num == 0){
                return new Integer(o1.getAge()).compareTo(new Integer(o2.getAge()));
            }
            return num;
        }
    }

    class Student implements Comparable<Student>{
        private String name;
        private int age;

        Student(String name, int age){
            this.name = name;
            this.age = age;
        }

        String getName(){
            return this.name;
        }

        int getAge(){
            return this.age;
        }

        /**
         * 同时创建多个对象要被用的时候，实现两个方法
         * @return
         */
        public String toString(){
            return this.name + "..:.." + this.age;
        }

        public int hashCode(){
//            return this.name.hashCode();
            return this.name.hashCode() + age*34;
        }

        /**
         * 同时创建多个对象要被用的时候，实现两个方法
         * @param o
         * @return
         */
        public boolean equals(Object o){
            if(!(o instanceof Student)){
//                return false;
//                throw new RuntimeException("比较的对象有问题，碰到问题抛异常");
                throw new ClassCastException("类型不匹配，不管了");
            }
            else return this.name.equals(((Student) o).getName()) && this.age == ((Student)o).age;
        }

        /**
         * 二叉树 -- 实现自然顺序。
         * @param o
         * @return
         */
        @Override
        public int compareTo(Student o) {
            if(this.name.equals(o.name)){
                return new Integer(this.age).compareTo(o.getAge());
            }else{
                return this.name.compareTo(o.getName());
            }
        }
    }
}

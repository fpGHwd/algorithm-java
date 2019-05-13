package com.itcast.collections.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class p201 {
    /**
     * 学生：归属地，地址，姓名，年龄（姓名，年龄相同为同一个学生）
     */
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

    class Location{
        private String loc;
        Location(String loc){
            this.loc = loc;
        }

        String getLoc(){
            return this.loc;
        }
        public String toString(){
            return this.loc;
        }
    }

    @Test
    public void testMapExercise(){
//        Map<Student, Location> map = new HashMap<Student, Location>();
        Map<Student, Location> map = new HashMap<>();
/*        map.put(new Student("zhangsan1", 12), new Location("CN"));
        map.put(new Student("zhangsan2", 13), new Location("JP"));
        map.put(new Student("zhangsan3", 14), new Location("US"));
        map.put(new Student("zhangsan1", 12), new Location("CN"));*/

        map.put(new Student("lisi1", 21), new Location("beijing"));
        map.put(new Student("lisi1", 21), new Location("tianjing")); //
        map.put(new Student("lisi3", 22), new Location("shanghai"));
        map.put(new Student("lisi4", 23), new Location("nanjing"));
        map.put(new Student("lisi5", 24), new Location("wuhan"));

        System.out.println("method 1:-------------------------------------- ");
        // keySet取出方法
        Set<Student>  ss = map.keySet();
        for(Iterator<Student> is = ss.iterator(); is.hasNext(); ){
            Student s = is.next();
            System.out.println("stuName: " + s.getName() + "......stuLoc..." + map.get(s).getLoc());
        }

        System.out.println("method 2: ---------------------------------------");
        // entrySet方法
        Set<Map.Entry<Student, Location>> smesl = map.entrySet();
        for(Iterator<Map.Entry<Student, Location>> imsl = smesl.iterator(); imsl.hasNext();){
            Map.Entry<Student, Location> mesl = imsl.next();
            System.out.println("stu: " + mesl.getKey().toString() + "....location..." + mesl.getValue().toString());
        }

        /**
         * 没有覆盖equals方法
         * stu: zhangsan1......loc...CN
         * stu: zhangsan1......loc...CN
         * stu: zhangsan3......loc...US
         * stu: zhangsan2......loc...JP
         *
         * 覆盖equals方法
         * stu: zhangsan2......loc...JP
         * stu: zhangsan3......loc...US
         * stu: zhangsan1......loc...CN
         *
         * stuName: zhangsan2......stuLoc...JP
         * stuName: zhangsan3......stuLoc...US
         * stuName: zhangsan1......stuLoc...CN
         */

        /**
         * hash表 无序。
         *
         * 第一个元素和第二个元素的值是视为一样的键，所以被第一个被第二个取代
         *
         * 如果删去hashCode方法和equals方法，那么两个元素作为不同的键进去。不同的对象。hashCode很大的概率不一样。
         */
    }
}

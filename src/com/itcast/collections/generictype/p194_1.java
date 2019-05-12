/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/12/19
 * @Time:       7:15 PM
 * @Project:    algorithm
 */

package com.itcast.collections.generictype;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Iterator;


class Person{
    private String name;
    private int age;
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name  =name;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        this.age = age;
    }

}

class Student1 extends Person{
    Student1(String name, int age){
        super(name, age);
    }

    public String getName(){
        return super.getName();
    }

    public int getAge(){
        return super.getAge();
    }
}

public class p194_1 {

    /**
     * 泛型限定
     */

    @Test
    public void test(){
        ArrayList<Person> ap = new ArrayList<>();
        ap.add(new Person("per-abc1", 18));
        ap.add(new Person("per-abc2", 18));
        ap.add(new Person("per-abc3", 18));
        ap.add(new Person("per-abc4", 18));

        ArrayList<Student1> as = new ArrayList<>();
        as.add(new Student1("stu-abc1", 18));
        as.add(new Student1("stu-abc2", 18));
        as.add(new Student1("stu-abc3", 18));
        as.add(new Student1("stu-abc4", 18));

        /**
         * 1 经典方式
         */
        printCol1(ap);
        printCol2(as);

        /**
         * 泛型，占位符，但是由于类型不知。。。所以里面不能使用
         */
        printCol3(ap);
        printCol3(as);

        /**
         * 限定泛型：技能泛型，里面又能够使用特有的类方法。。。所以这里有一个折衷。
         */
        printCol5(ap);
        printCol5(as);


        /**
         * 完美，其实就是代码转移到了位置。使用了更多的代码对应了未来更多的情况。
         * （如果不能看出来任何的这种和用什么换什么，说明你还没有深刻的理解）
         * 用现在的时间 换取了更多未来（或者说未来问题的）解决方法的时空。
         *
         * abc1.....18
         * abc2.....18
         * abc3.....18
         * abc4.....18
         * abc1.....18
         * abc2.....18
         * abc3.....18
         * abc4.....18
         * com.itcast.collections.generictype.Person@63c12fb0
         * com.itcast.collections.generictype.Person@b1a58a3
         * com.itcast.collections.generictype.Person@6438a396
         * com.itcast.collections.generictype.Person@e2144e4
         * com.itcast.collections.generictype.Student1@6477463f
         * com.itcast.collections.generictype.Student1@3d71d552
         * com.itcast.collections.generictype.Student1@1cf4f579
         * com.itcast.collections.generictype.Student1@18769467
         * abc1.....18
         * abc2.....18
         * abc3.....18
         * abc4.....18
         * abc1.....18
         * abc2.....18
         * abc3.....18
         * abc4.....18
         *
         *
         * per-abc1.....18
         * per-abc2.....18
         * per-abc3.....18
         * per-abc4.....18
         * stu-abc1.....18
         * stu-abc2.....18
         * stu-abc3.....18
         * stu-abc4.....18
         * com.itcast.collections.generictype.Person@63c12fb0
         * com.itcast.collections.generictype.Person@b1a58a3
         * com.itcast.collections.generictype.Person@6438a396
         * com.itcast.collections.generictype.Person@e2144e4
         * com.itcast.collections.generictype.Student1@6477463f
         * com.itcast.collections.generictype.Student1@3d71d552
         * com.itcast.collections.generictype.Student1@1cf4f579
         * com.itcast.collections.generictype.Student1@18769467
         * per-abc1.....18
         * per-abc2.....18
         * per-abc3.....18
         * per-abc4.....18
         * stu-abc1.....18
         * stu-abc2.....18
         * stu-abc3.....18
         * stu-abc4.....18
         *
         */

    }

    public static void printCol1(ArrayList<Person> ap){
        for(Iterator<Person> ip = ap.iterator(); ip.hasNext();){
            Person p = ip.next();
            System.out.println(p.getName() + "....." + p.getAge());
        }
    }

    public static void printCol2(ArrayList<Student1> ap){
        for(Iterator<Student1> ip = ap.iterator(); ip.hasNext();){
            Student1 p = ip.next();
            System.out.println(p.getName() + "....." + p.getAge());
        }
    }

    public static void printCol3(ArrayList<?> ap){
        for(Iterator<?> ip = ap.iterator(); ip.hasNext();){
//            Person p = ip.next();
//            System.out.println(p.getName() + "....." + p.getAge()); // 不能打印
            System.out.println(ip.next());

        }
    }

    /**
     * 纯限定，还是不能用来当作。
     * ？通配符 -- 占位符
     *
     * extends E 是上限限定
     * super E 是下限限定
     *
     * @param ap
     */
    public static void printCol4(ArrayList<? extends Person> ap) {
        for (Iterator<?> ip = ap.iterator(); ip.hasNext(); ) {
//            Person p = ip.next();
//            System.out.println(p.getName() + "....." + p.getAge()); // 不能打印
            System.out.println(ip.next());

        }
    }



    public static <T extends Person> void printCol5(ArrayList<T> ap){
        for(Iterator<T> ip = ap.iterator(); ip.hasNext();){
            T p = ip.next();
            System.out.println(p.getName() + "....." + p.getAge());
        }
    }


    public static void printCol6(ArrayList<? super Student1> ap) {
        for (Iterator<?> ip = ap.iterator(); ip.hasNext(); ) {
//            Person p = ip.next();
//            System.out.println(p.getName() + "....." + p.getAge()); // 不能打印
            System.out.println(ip.next());

        }
    }

    /**
     * 有一个Super e载treeset里面的comparable方法
     */


    /**
     * 泛型的高级应用：上限和下限
     * 泛型的组合应用----更麻烦
     *
     *
     * 父类引用可以接收子类对象。因为子类的东西多，空间比较大，父类只是一个引用，肯定没有问题。
     * 但是子类引用必然不能接受父类对象。子类的引用（宣称的东西多），但是真实的空间只有父类，比较少。所以不行的。
     *
     */


    /***
     * 为什么要想，想就是让你更好的联系
     * 为了让你在将来更好的用它
     *
     * collection<?> 问号比较多
     */


    /**
     * todo 理解泛型限定
     *
     * 不做机械工具。不做最好的的机械事情。。
     * 确定性满格。
     * 只做最强目的性
     */



}

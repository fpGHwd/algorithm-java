/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/12/19
 * @Time:       6:53 PM
 * @Project:    algorithm
 */

package com.itcast.collections.generictype;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class p194 {
    /**
     * 泛型限定
     */


    @Test
    public void testGenericTypeLimit(){
        ArrayList<String> al = new ArrayList<>();
        al.add("abc1");
        al.add("abc2");
        al.add("abc3");


        ArrayList<Integer> al1 = new ArrayList<>();
        al1.add(1); // 自动装箱
        al1.add(2);
        al1.add(3);

        printCol1(al);
//        printCol1(al1);


        printCol11(al);
        printCol11(al1);



    }


    public static void printCol1(ArrayList<String> al){
        for(Iterator<String> as = al.iterator(); as.hasNext(); ){
            System.out.println(as.next());
        }
    }

    /**
     * 问号，通配符。。。
     * 当然还有一种解决方法就是写成T，里面就可以用到T。如果写问号是不能用到的。也就是不能解码。其实?可以防止滥用
     *
     *
     * ？占位符，不明确的类型
     * T 泛型
     *
     * @param al
     */
    public static void printCol11(ArrayList<?> al){
        for(Iterator<?> as = al.iterator(); as.hasNext(); ){
            System.out.println(as.next()); // 不明类型？不能使用特有方法，比如length()是不能用的。
        }

        // 就如同：多态也有弊端，就是不能预先使用子类特有方法。
    }


    /**
     * 记得之前他说过依据很重要的化，就是这些东西都是逐步优化来的。并不是一开始就是这个样子的。
     * 所以载后面看来的时候，也不要太过与纠结与他的形式。。。
     * 越好看的东西，越需要时间去打磨，也越需要付出更多的代价。
     */

    /**
     * 问号是任意的类型。
     * 但是想操作的是Person和Person的子类
     * 我想打印一个类型的范围。。。。
     *
     * 这就是如何限定泛型。
     */
}


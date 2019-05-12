/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/12/19
 * @Time:       4:37 PM
 * @Project:    algorithm
 */

package com.itcast.collections.generictype;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class p188 {
    /**
     * JDK1.5后面实现了泛型
     * 是一个安全特性。。。。竟然是一个安全特性
     *
     * 就是ArrayList之前是没有限制传入的对象的类型。泛型则是一种限制，提升编译时的安全。所以是一种编译时安全特性。
     */


    /**
     * 也就是将运行时期出现的ClassNotFoundException转移到了编译时。提早发现。
     * 让程序员发现
     * 让运行时期问题减少，更安全。
     */

    /**
     * 修改了之后，注意也没有了。更安全了。
     */

    @Test
    public void testGenericType(){

/*
        ArrayList al = new ArrayList();
        al.add("abc");
        al.add("ab");
        al.add(13);

        for(Iterator it = al.iterator(); it.hasNext(); ){
            String s = (String)it.next();
            System.out.println(s); // 上面有个文件有疑问，其实是强转类型了。
        }
*/


        /**
         * 在没有加入泛型类型之前（编译时问题）：
         *
         * abc
         * ab
         *
         * java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
         *
         * 	at com.itcast.collections.generictype.p188.testGenericType
         */

        ArrayList<String> als = new ArrayList<>();
        als.add("abc");
//        als.add(13);  // 自动提示错误

        als.add("abcd");


        for(Iterator it = als.iterator(); it.hasNext(); ){
            String s = (String)it.next();
            System.out.println(s);
        }

        /**
         *  而且之前老师编译的文件都有注意提醒。现在就没有了。所以提示的就是这个问题。
         *
         *  之前的写法中，主观的限定和强制类型转换，都是主观的。。。确定性比较小。
         *  现在源码的确定性就比较大了。
         *  所以都追求的都是一种确定性。
         *
         *  各种确定性和成本之间的博弈。。。
         *  看东西要透其本质。
         */
    }
}

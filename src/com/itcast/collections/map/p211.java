/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/13/19
 * @Time:       3:43 PM
 * @Project:    algorithm
 */

package com.itcast.collections.map;

import org.junit.Test;

import java.util.Arrays;

import java.util.List;

// todo 使用的intellij idea快捷键：line操作，移动操作。还是要记一下。否则没有优势

/**
 * 行剪切
 * 行复制
 * 行上下移动 control + shift + up/down
 * 行删除 control + x
 * 行首
 * 行尾
 * 行下新行
 *
 * 参数补全
 */

public class p211 {

    @Test
    public void testArrayDemo(){
        int[] a = {4,2,7,1,5,0,3};
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        String[] str = {"abc", "cc", "kkk"};
        List<String> li = Arrays.asList(str);
        System.out.println(Arrays.toString(str));
        System.out.println(li); // list可以直接打印

        /**
         * 把数组转换成List的好处
         * 反正就是集合有很多可以用的类。。方便自己写代码。
         *
         * 可以使用集合的思想和方法来操作数组中的元素。
         */
        System.out.println("contains: " + li.contains("cc"));
        // 自己写方法太麻烦了。虽然能写。但是有的话就不要浪费自己的时间。
        // 节省的时间很重要。

//        li.add("fff"); // UnsupportedOperationException
        /**
         * 数组转的集合，不能使用集合的增删方法。因为数组的长度是一定的。
         *
         */
        List nums = Arrays.asList(new int[]{1,3,5,6,7});
        List<int[]> nums1 = Arrays.asList(new int[]{1,3,5,6,7});
        System.out.println(nums); // [[I@63c12fb0]
        System.out.println(nums1); //
        /**
         * 字符串是列表，但是数组集合是数组。。   为什么呢？
         *
         * 如果，数组中的内容是引用类型（对象），那么作为集合时，数组中的元素就直接变成集合中的元素。
         * 但是如果是基本类型，只是会成为一个数组。
         *
         * 文档中没有提起。
         * 只能看源码中有没有。突然意识到文档是源码生成的。。。所以只看源码也可以。但是文档更清楚。
         */

        Integer[] intA = {1,3,4,5,6}; // 自动装箱
        List<Integer> intAl = Arrays.asList(intA);
        System.out.println(intAl); // [1, 3, 4, 5, 6]

        Character[] ca = {'A', 'C', 'G', 'H'};
        List<Character> lc = Arrays.asList(ca);
        System.out.println(lc); // [A, C, G, H]

        /**
         * 数组变集合
         */
    }


    // todo 整体看一下文档
}

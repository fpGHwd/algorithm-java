/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/12/19
 * @Time:       2:10 PM
 * @Project:    algorithm
 */

package com.itcast.collections;

public class p185 {
    // TreeSet树就是用于在set中减少其排序时间为log(n)的数据结构。。。二叉树。
    // 其实就是减少其排序的次数

    // TreeSet中排序的三种情况，当相等时，元素不会存进去
    // 红黑树

    // 怎么存进去的就怎么取出来？如何做到
    // 中序遍历就是最后的输出。
    // 如果compareTo直接return1呢，就是可以实现迭代器直接取出存入的内容。其实是一个只有右子树的二叉树。

    // return 0 时，只有一个元素


    // TreeSet保证元素唯一性的依据就是compareTo方法
    // 元素的自然排序
}

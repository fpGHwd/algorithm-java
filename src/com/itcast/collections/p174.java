/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       19-5-11
 * @Time:       下午9:04
 * @Project:    algorithm
 */

package com.itcast.collections;

public class p174 {
    /**
     * 底层的数据结构不一样，所以有了List下面的三个具体
     * ArrayList，LinkedList，Vector
     * ArrayList底层是数据：增删比较慢，访问快
     * LinkedList底层是链表数据结构：访问慢，但是增删比较快（刚好和ArrayList互补）
     * Vector底层是数组结构，线程同步：无论增删和查询都很慢
     * 多线程自己加锁，也不用vector
     *
     * ArrayList 150%延长数组长度
     * Vector 200%延长数组
     *
     * 枚举是vector特有的取出方式
     * 枚举和迭代器很像
     *
     * 枚举和迭代是一样的。枚举的名称和方法的名称都过长了。所以被迭代器取代。枚举郁郁而终
     */
}

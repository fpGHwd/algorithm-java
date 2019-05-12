/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       19-5-11
 * @Time:       下午9:55
 * @Project:    algorithm
 */

package com.itcast.collections;

import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class p177 {
    /**
     * 利用LinkedList模拟一个堆栈或者队列的数据结构。
     *
     * 所以现在有了一致性和时空相关的分析方法后，发现问题就来自于那些经典的东西
     *
     * 所以问题只有那些。你要做的是分析1和2有什么不同而已
     *
     */


    @Test
    public void testQueue(){

        Queue q = new Queue() {
            @Override
            public boolean add(Object o) {
                return false;
            }

            @Override
            public boolean offer(Object o) {
                return false;
            }

            @Override
            public Object remove() {
                return null;
            }

            @Override
            public Object poll() {
                return null;
            }

            @Override
            public Object element() {
                return null;
            }

            @Override
            public Object peek() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public Object[] toArray(Object[] a) {
                return new Object[0];
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection c) {
                return false;
            }

            @Override
            public boolean addAll(Collection c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
    }
}

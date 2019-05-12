/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/12/19
 * @Time:       1:08 PM
 * @Project:    algorithm
 */

package com.itcast.collections;

import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

public class p183 {
    @Test
    public void testTreeSet(){
        TreeSet ts = new TreeSet();

        ts.add("cba");
        ts.add("abcd");
        ts.add("aaa");
        ts.add("bca");

        // ts具有字典序

        for(Iterator it = ts.iterator(); it.hasNext();){
            System.out.println(it.next());
        }

    }
}

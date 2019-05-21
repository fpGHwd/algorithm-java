/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/19/19
 * @Time:       1:43 PM
 * @Project:    algorithm
 */

package com.lrj;

import java.util.*;

public class Tree {

    Map<Integer, Integer> getTree(){
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0,1);
        m.put(0,2);
        m.put(0,3);
        m.put(1,4);
        m.put(1,5);
        m.put(5,6);
        m.put(5,7);
        return m;
    }

    private int max = 100;
}

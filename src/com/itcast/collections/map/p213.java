/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/13/19
 * @Time:       5:36 PM
 * @Project:    algorithm
 */

package com.itcast.collections.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class p213 {
    /**
     * 传统for循环和高级for循环
     * 传统可以做其他事情，但是高级for循环不能。
     *
     * 遍历数组时还是希望使用传统for循环。可以定义脚标。
     */


    @Test
    public void test(){
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1,"a");
        hm.put(2,"b");
        hm.put(3,"c");

        // 可以的 -- 迭代器一样的方法
        for(Map.Entry<Integer,String> me : hm.entrySet()){
            System.out.println(me.getKey() + "::" + me.getValue());
        }

    }
}

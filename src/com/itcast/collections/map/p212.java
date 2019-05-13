/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/13/19
 * @Time:       4:36 PM
 * @Project:    algorithm
 */

package com.itcast.collections.map;

import org.junit.Test;

import java.util.ArrayList;

public class p212 {
    /**
     * 集合变数组
     *
     * Collection toArray
     */

    @Test
    public void test(){
        ArrayList<String> als = new ArrayList<String>();
        als.add("abc1");
        als.add("abc2");
        als.add("abc3");

        Object[] obj= als.toArray();


        /**
         * 为了限制其他地方的使用。不能增删。就想文件一样。
         */
    }


}

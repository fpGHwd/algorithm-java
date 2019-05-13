package com.itcast.collections.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

// todo jump in idea in line andwords and embraces

public class p204 {

    @Test
    public void testExercise(){
        HashMap<String, HashMap<String,String>> czbk = new HashMap<String, HashMap<String,String>>();
        HashMap<String, String> yure = new HashMap<String, String>();
        HashMap<String, String> jiuye = new HashMap<String, String>();


        yure.put("01", "zhangsan");
        yure.put("02", "lisi");


        jiuye.put("01", "zhaosi");
        jiuye.put("02", "wangwu");


        czbk.put("yureban", yure);
        czbk.put("jiuyeban", jiuye);

        /**
         * 当学生封装成对象时，就用collection中的List或者Set。。唯一的Set不唯一的List
         *
         * 循环嵌套
         */
    }
}

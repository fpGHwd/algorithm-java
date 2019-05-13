package com.itcast.collections.map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p205 {

    @Test
    public void test(){
        sortDemo();
    }

    public static void sortDemo(){
        List<String> list = new ArrayList<>();
        list.add("abcd");
        list.add("aaa");
        list.add("z");
        list.add("kkkkk");
        list.add("qq");

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

//        Collections.replaceAll()
    }

}

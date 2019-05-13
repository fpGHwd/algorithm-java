package com.itcast.collections.map;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class p198 {
    @Test
    public void test(){

        Map<String ,String > map = new HashMap<>(); //  Polymorphism
        map.put("01", "zhangsan01");
        map.put("02", "zhangsan02");
        map.put("03", "zhangsan03");

        System.out.println("containsKey: " + map.containsKey("022"));
//        System.out.println("remove:"  + map.remove("02"));

        System.out.println("get: " + map.get("023"));

        map.put(null, "aha");
        System.out.println("get: " + map.get(null)); // get: aha

        System.out.println(map);

        System.out.println(map.values()); // [aha, zhangsan01, zhangsan02, zhangsan03]

        Collection<String> cs = map.values();

        System.out.println(cs);

        System.out.println("put: " +  map.put("01", "wangwu")); // replace

        /**
         * containsKey: false
         * remove:zhangsan02
         * {01=zhangsan01, 03=zhangsan03}
         *
         *
         * {null=aha, 01=zhangsan01, 02=zhangsan02, 03=zhangsan03}
         *
         *
         * HashTable 不允许null
         */
    }
}

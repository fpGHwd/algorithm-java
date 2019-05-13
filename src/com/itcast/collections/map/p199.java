package com.itcast.collections.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;

public class p199 {
    /**
     * keySet
     *
     * EntrySet
     */


    /**
     * Set<K>	keySet()
     * 返回此地图中包含的键的Set视图。
     */

    @Test
    public void testKeySet(){
        Map<String ,String> map  = new HashMap<>();
        map.put("01", "zhangsan01");
        map.put("02", "zhangsan02");
        map.put("03", "zhangsan03");

        Set<String> ss = map.keySet();
        System.out.println(ss);

        for(Iterator<String> is = ss.iterator(); is.hasNext(); ){
            String s = is.next();
            System.out.println("key: " + s + "....value: "+map.get(s));
        }

        Set<Map.Entry<String, String>> es = map.entrySet();
        System.out.println(es);
    }
}

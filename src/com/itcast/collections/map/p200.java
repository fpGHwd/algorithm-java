package com.itcast.collections.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class p200 {

    /**
     * map集合的取出原理
     */

    // Set<Map.Entry<K,V>> entrySet()


    @Test
    public void testEntrySet(){
        Map<String ,String> map  = new HashMap<>();
        map.put("01", "zhangsan01");
        map.put("02", "zhangsan02");
        map.put("03", "zhangsan03");

        Set<Map.Entry<String,String>> entrySet= map.entrySet();

        Iterator<Map.Entry<String,String>> it = entrySet.iterator();
        while(it.hasNext()){
            Map.Entry<String, String> mess = it.next();
//            System.out.println("key: " + mess + "....value: "+map.get(mess)); // ?

            System.out.println("key: " + mess.getKey() + "....value: "+mess.getValue());
/*            key: 01=zhangsan01....value: null
            key: 01....value: zhangsan01
            key: 02=zhangsan02....value: null
            key: 02....value: zhangsan02
            key: 03=zhangsan03....value: null
            key: 03....value: zhangsan03*/
        }


        /**
         * K 	getKey()
         * Returns the key corresponding to this entry.
         *
         * V 	getValue()
         * Returns the value corresponding to this entry.
         */


        /**
         * entrySet()
         * 一一对应关系，就是直线。
         */


        /**
         * 内部接口
         * static interface 	Map.Entry<K,V>
         *
         *
         *     Map的内部接口Entry<K,V></K,V>
         *
         *
         *     public static interface Map.Entry<K,V>
         *         static 表示内部
         */

    }

}

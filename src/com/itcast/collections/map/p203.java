package com.itcast.collections.map;

import org.junit.Test;

import java.util.*;

public class p203 {

    /**
     * 映射，map集合
     */

    @Test
    public void testExercise() {
        String test = "abbaeffeg";
        String ret = charCount(test);
        System.out.println(ret);

        // a(5)b(1)d(5)f(4)g(1)h(2)i(5)j(2)l(3)s(3)
        /**
         * Connected to the target VM, address: '127.0.0.1:43809', transport: 'socket'
         * a(5)b(1)d(5)f(4)g(1)h(2)i(5)j(2)l(3)s(3)
         * Disconnected from the target VM, address: '127.0.0.1:43809', transport: 'socket'
         */

        /**
         * 三元表达式
         * a(5)b(1)d(5)f(4)g(1)h(2)i(5)j(2)l(3)s(3)
         *
         *
         *
         * a(8)b(5)d(9)f(3)g(1)s(4)
         *
         * a(2)b(2)e(2)f(2)g(1)
         */
    }


    public static String charCount(String str) {
        char[] ca = str.toCharArray();
        TreeMap<Character, Integer> mci = new TreeMap<Character, Integer>(new CharComp());
        /**
         * 泛型里面只能是引用类型。
         */

        // int count不要定义在循环里面。

        for (char i : ca) {
/*            if(mci.get(i)!=null){
                mci.put(i, mci.get(i)+1); // 自动装箱
            }else{
                mci.put(i, 1);
            }*/

            if ((i >= 'a' && i <= 'z') || (i >= 'A') && (i <= 'Z')) {
                if (i >= 'A' && i <= 'Z') i = (char) (i - 'A' + 'a');
                mci.put(i, mci.get(i) == null ? 1 : ((mci.get(i) + 1)));  // 三元表达式
            } else
                continue;
        }

        // 缓冲区
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<Character, Integer>> smeci = mci.entrySet();
        for (Iterator<Map.Entry<Character, Integer>> imeci = smeci.iterator(); imeci.hasNext(); ) {
            Map.Entry<Character, Integer> me = imeci.next();
            sb.append(me.getKey().toString() + "(" + me.getValue().toString() + ")");
        }

        return sb.toString();
    }

    static class CharComp implements Comparator<Character> {

        public int compare(Character o1, Character o2) {
            return o1.compareTo(o2);
        }
    }
}


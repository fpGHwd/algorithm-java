/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       19-5-11
 * @Time:       下午1:25
 * @Project:    algorithm
 */

package com.itcast.basedecorate;

/*
基本数据类型对象包装类
byte        Byte
short       Short
int         Integer
long        Long
boolean     Boolean
float       Float
double      Double
char        Character
 */


import org.junit.Test;

public class p167 {
    public static void sop(String str){
        System.out.println(str);
    }

    @Test
    public void testIntegerDemo(){
        sop("int max: " + Integer.MAX_VALUE);
    }

    @Test
    public void testBaseTypeToString(){
        int i = 50; // 基本类型如何转字符串：额
        sop(i+"");
        sop(Integer.toString(i));


        int num = Integer.parseInt("123");
        long x = Long.parseLong("123");
        sop(Integer.toBinaryString(-6));
        sop("0x"+Integer.toHexString(60));

        int y = Integer.parseInt("3c", 16);
        sop(" y = " + y);
    }


    // 十进制转换其他进制
    /**
     * toBinaryString()
     * toHexString()
     * toOctalString()
     */


    // 其他进制转换为十进制
    /**
     * parseInt(string, radix);
     */

}

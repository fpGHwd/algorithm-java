/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       19-5-11
 * @Time:       上午10:57
 * @Project:    algorithm
 */

package com.itcast.string;

import org.junit.Test;

public class p162 {

    public int getSubCount(String str, String key){
        int count = 0;
        int index;
        while((index = str.indexOf(key))!=-1){
            count++;
            str = str.substring(index + key.length());
        }
        return count;
    }


    // 用index的重载方法改写原来的函数

    public int getSubCount_2(String str, String key){
        int count = 0;
        int index = 0;
        while((index = str.indexOf(key,index))!=-1){
            count++;
            index += key.length();
        }
        return count;
    }

    public int getSubCount_3(String str, String key){
        int count = 0;
        int index = 0;
        while((index = (str = str.substring(index)).indexOf(key))!=-1){ // 加一个赋值即可
            count++;
            index += key.length(); // 这样可以做，但是意义比较晦涩。
        }
        return count;
    }


    public int getSubCount_4(String str, String key){
        return str.split(key).length-1;
    }

    @Test
    public void testGetSubCount(){
        String str = "abckkadkkbedkkfskkd";
        String key = "kk";
        System.out.println("count1 = " + getSubCount(str,key));
        System.out.println("count2 = " + getSubCount_2(str,key));
        System.out.println("count3 = " + getSubCount_3(str,key));
        System.out.println("count4 = " + getSubCount_4(str,key));

        String str2 = "kkajdiskkbadfkk";
        System.out.println("count1 = " + getSubCount(str2,key));
        System.out.println("count4 = " + getSubCount_4(str2,key)); // 2， 正常结果是3
        String str3 = "kkajdiskkbadf";
        System.out.println("count1 = " + getSubCount(str3,key));
        System.out.println("count4 = " + getSubCount_4(str3,key)); // 2， 正常结果是2这种情况是对的。但是切除来还是三段
        String str4 = "ajdiskkbadfkk";
        System.out.println("count1 = " + getSubCount(str4,key));
        System.out.println("count4 = " + getSubCount_4(str4,key)); // 1， 正常结果是2。切除来是两段
        // 所以不建议切割。


        // 改变了原来的字符串。

        // 切割为什么不行？我刚才试了不行。
        // 不建议使用切割的形式
    }
}

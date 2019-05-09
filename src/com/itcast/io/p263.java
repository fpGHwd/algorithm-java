/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/9/19
 * @Time:       9:40 AM
 * @Project:    algorithm
 */

package com.itcast.io;

import org.junit.Test;

import java.util.Properties;
import java.util.Set;

public class p263 {

    public static void main(String[] args){

    }

    @Test
    public void testSetAndGet(){
        Properties p = new Properties();
        p.setProperty("zhangsan", "30");
        p.setProperty("lisi", "39");


        String value =  p.getProperty("lisi");
        // todo Idea line end shortcut
//        System.out.println(value);

        p.setProperty("lisi", 89+"");

        Set<String> names = p.stringPropertyNames();
        for(String n: names){
            System.out.println(n + ": "+ p.getProperty(n));
        }
    }
}

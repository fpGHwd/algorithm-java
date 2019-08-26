/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/24/19 3:53 PM
 */

package com.jdk.reflection;

public class ReflectionTest {

    public static void main(String[] args) {
        ReflectionTest reflectionTest = new ReflectionTest();
        Class cl = reflectionTest.getClass();
        System.out.println(cl.getName());


        String className = "java.util.Random";
        try {
            Class cl1 = Class.forName(className);
            System.out.println(cl1.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(int.class);
        System.out.println(char.class);
    }
}

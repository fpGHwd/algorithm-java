/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/24/19 11:06 AM
 */

package com.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class ProxyTest {
    public static void main(String[] args) {
        Object[] elements = new Object[1000];
        for(int i = 0; i < elements.length; i++){
            Integer value = i+1;
            InvocationHandler handler = new TraceHandler(value);
            // 代理不同于代理模式
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
            elements[i] = proxy;
        }

        // construct a random integer
        Integer key = new Random().nextInt(elements.length) + 1;

        // search for the key
        int result = Arrays.binarySearch(elements, key);

        // print math if found
        if(result >= 0) System.out.println(elements[result]);

        // 无法生成一个新类和不需要生成新类，只需要增强功能
    }
}

class TraceHandler implements InvocationHandler{

    private Object target;

    TraceHandler(Object t){
        this.target = t;
    }

    public Object invoke(Object proxy, Method m, Object[] args)
            throws InvocationTargetException, IllegalAccessException
    {
        // print implicit argument
        System.out.print(target);
        // print method name
        System.out.print("." + m.getName() + "(");
        // print explicit arguments
        if(args!=null){
            for(int i = 0; i < args.length; i++){
                if(i!=0) System.out.print(",");
                System.out.print(args[i]);
            }
        }
        System.out.println(")");

        // invoke actual method
        return m.invoke(target, args);
    }

    // 基本数据类型
    // int short byte long
    // float double
    // char
    // boolean
}

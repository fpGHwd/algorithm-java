/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/12/19
 * @Time:       6:29 PM
 * @Project:    algorithm
 */

package com.itcast.collections.generictype;


import org.junit.Test;

/**
 * 当方法的签名（非参数）上有<T>的时候，好像就没有用到类本身的泛型（IDE这么提示的）
 * @param <T>
 */
class Demo1<T> {
    public void show(T t){
        System.out.println("show: " + t);
    }

    /**
     * 所以这个应该是静态类型方法。。就差加上一个static了
     * @param q
     * @param <Q>
     */
    public <Q> void print(Q q){
        System.out.println("print: " + q);
    }


    public static <W> void method(W w){
        System.out.println("method: " + w);
    }
}

public class p192 {
    /**
     * 静态方法泛型
     */
    @Test
    public void testDemoGenericMethod() {

        Demo1<String> ds = new Demo1<>();
        ds.show("abc");
//        ds.show(50); // 不是静态泛型方法


        Demo1<Integer> di = new Demo1<>();
        di.print(100); // 100 可以强转成Integer
        di.print("abc"); // 静态泛型方法

        Demo1.method("hahahahha");

    }
}

/**
 * 编译错误：
 * Error:(33, 31) java: non-static type variable T cannot be referenced from a static context
 *
 *
 * 静态方法不可访问类上定义的泛型
 *
 *
 * 书写格式错误
 * public <W> static void method(W w){
 *         System.out.println("method: " + w);
 *     }
 *
 *
 * 修饰福后面，返回类型前面。 // 提示错误很多，不知道怎么改
 *
 * Error:(33, 17) java: illegal start of type                               // 非法的类型开始
 * Error:(33, 24) java: '(' expected                                        // 需要"("
 * Error:(33, 29) java: invalid method declaration; return type required    // 方法声明无效，需要返回类型
 *
 *
 *
 * 静态先加载，后面才有对象呢。。。。
 *
 *
 */
/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 5/3/19
 * @Time: 8:52 PM
 */

package com.heima.p118;


import org.junit.Test;

import java.lang.ArithmeticException;

// Runtime异常说到底还是CPU的flag的问题。
// ArithmeticException的父类是RuntimeException比较特殊：如果这里是普通的抛出Exception那么函数一定要抛出，RuntimeException不需要这种操作。
// 主要是编译会不会通过。
// 同时如果div没有异常只是函数抛出ArithmeticException，即使在异常被调用的地方也不需要有catch


// 这么设计的原则因为RuntimeException在虚拟机看来，需要停机而且不能让用户去处理。JVM希望停止程序，并让程序员修正源码的错误。
class Demo{
    int div(int a, int b){
        if(b==0)throw new ClassExtendsRuntimeExcepion("被零除了");
        // 使用了继承RuntimeException的自定义Runtime的信息。
        return a/b;
    }
}

// Demo指的是你，这样这种隐形的逻辑已经清除了。看不见彼此和0-1，你就看不清这种命名的彼此之间的这种因素。
// 突然想到的题外话：有的男生表现出来的外在，完全只是实力的一部分体现而已。而我好像是在这几年都忽视了内在。不过现在知道了。
public class RuntimeExceptionDemo {

    @Test
    public void TestExceptionHandle(){
        Demo d = new Demo();
        int x = 0;
        try{
            x = d.div(4, 0);
        }catch (ArithmeticException e){
            System.out.println(e.toString());
        }
        System.out.println("x = " + x);
        System.out.println("over");
    }
}

class Person{

    public void checkName(String name){

        // NullPointerException本身也是一种运行时异常，需要用户去修正源代码
//        if(name.equals("lisi")){
//            System.out.println("YES");
//        }else{
//            System.out.println("no");
//        }

        // 第一种方式
        if("lisi".equals(name)){
            System.out.println("YES");
        }else{
            System.out.println("no");
        }

        // 第二种方式
        if(name != null && name.equals("lisi")){
            System.out.println("YES");
        }else{
            System.out.println("no");
        }

        // 这里如果throw和throws了也并没有什么卵用。
        // 看视频最重要的还是『0-1』以及『彼和此』的理解啊。如果没有理解，只能自己摸，这是低级方式的学习
        // 高级方式就是看和理解。做的效率实在是太低了。所以一定不要仅满足于做来学习
        // 一定要看，更高级的是看。看书，看视频等等。

        // RuntimeException的那些特殊表现 == 赶紧修正源码

        // 那么又来了新的问题：
        // 如果自定义异常需要停机的话，就可以继承RuntimeException
    }

}


class ClassExtendsRuntimeExcepion extends RuntimeException{

    ClassExtendsRuntimeExcepion(String message){
        super(message);
    }

}

// Object的wait方法，可以抛出三个异常，但是只throws了一个异常
// 所以另外两个是RuntimeException

// IllegalArgumentException:如果你敢传负数，我就让程序停着。你连时间都不对，程序还能运行吗。
// 必须修正代码

// 面试问这个Runtime异常能不能编译通过，当然可以。// 回答不行就说明没有接触过相关信息。



/*
异常分为两种：
    1。 编译是能被检测出来的异常。 就是可处理的异常，也是造成编译不通过的异常。
    2。 编译是不能被检测出来的异常（运行时异常,RuntimeException和其子类）


RuntimeException会被判断e instanceof RuntimeException // 源码中的机制
 */
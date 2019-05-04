/**
 * @author suzumiya
 * @data 4/28/19 11:50 PM
 */

package com.itcast.p112;


/**
 * 讲课听的主要还是人家如何把所有东西给你联系起来
 * 能往前走比怎么走更重要，尤其是没钱的时候。不能把时间转化为方式(refined优雅)，而是实现(realize)和成就(accomplishing)
 */
public class ExceptionDemo {

    public static void main(String[] args){
        Demo d = new Demo();
        int x = d.div(4,0);
        System.out.println("x = "+x);
        System.out.println("over");
    }

}


class Demo{
    int div(int a, int b){
        return a/b;
    }
}

// error和exception具有共性内容

// Throwable
//      |--- Error
//      |--- Exception

// 体系，看服类定义，建立子类对象。

// Error子类很多
// 父类名作为子类后缀
// exception子类后面还有很多子类

// 丢失了一些看java 网络的一些代码，不过也不是特别重要。感觉代码已经很好理解了。用数字化去理解。

/*
问题变成对象
万物皆对象
 */
/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       19-5-11
 * @Time:       上午8:45
 * @Project:    algorithm
 */

package com.itcast.threads.p154;


import sun.awt.windows.ThemeReader;

class Demo implements Runnable{
    public void run(){
        for(int x = 0; x < 70; x++){
            System.out.println(Thread.currentThread().toString() + "......" + x);
            Thread.yield();
        }
    }
}

public class p154 {

    // 优先级yield方法


    // ThreadGroup用的很少
    // 优先级 == 资源的频率

    // 静态常量MAX_PRIORITY

    // yield暂停线程

    // 什么时候使用多线程？同时进行某些任务的时候

    public static void main(String[] args){

        new Thread(){
            public void run(){
                for(int x = 0; x<100; x++){
                    System.out.println(Thread.currentThread().getName() + "...." +x);
                }
            }
        }.start();


        for(int x = 0; x<100; x++){
            System.out.println(Thread.currentThread().getName() + "...." +x);
        }

        Runnable r = new Runnable(){
            public void run(){
                for(int x = 0; x<100; x++){
                    System.out.println(Thread.currentThread().getName() + "...." +x);
                }
            }
        };
        new Thread(r).start();

        // 多线程还是同时运行，然后提升一定的时间效率。


        /**
         * 好像没有讲设置不同优先级的执行效果。不过这应该是操作系统的一部分把。
         */
    }
}
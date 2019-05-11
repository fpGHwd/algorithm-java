/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/4/19
 * @Time:       11:28 PM
 * @Project:    algorithm
 */

package com.itcast.threads.p130;

public class ThreadDemo {
    public static void main(String[] args){
        for(int i = 0; i < 4000000; i++){
            System.out.println("hello thread");
        }
    }
}

/**
 * 不只有一个线程，还有垃圾回收的线程。
 * 所以java虚拟机是一个多线程程序。
 * 
 * 多线程的好处：同时执行，细粒度控制
 */

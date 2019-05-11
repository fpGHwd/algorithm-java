/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/4/19
 * @Time:       11:43 PM
 * @Project:    algorithm
 */

package com.itcast.threads.p131;

/**
 * 系统中已经有了线程，都是系统创建的。java这边有线程的映射对象。
 */
public class ThreadDemo extends Thread{
    public void run(){
        for(int i = 0; i< 600; i++)
            System.out.println("Thread runs " + i);
    }

    public static void main(String[] args){
        /*for(int i = 0; i < 10; i++){
            new ThreadDemo().start();
            // new ThreadDemo().run(); // 没用
        }*/

        new ThreadDemo().start();
        for(int i = 0; i < 600; i++){
            System.out.println("Main thread runs " + i);
        }
    }
}

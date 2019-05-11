/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/5/19
 * @Time:       12:30 AM
 * @Project:    algorithm
 */

package com.itcast.threads.p133;

class ThreadDemo extends Thread{
//    private String name;

    ThreadDemo(String name){
        super(name);
//        this.name = name;
    }

    public void run(){
        for(int i = 0; i < 600; i++){
            System.out.println(Thread.currentThread().getName() + " threaddemo runs " + i);
        }
    }
}

public class ThreadDemoTest {

    public static void main(String[] args){

        ThreadDemo td1 = new ThreadDemo("t----1");
        ThreadDemo td2 = new ThreadDemo("t----2");
        td1.start();
        td2.start() ;

        for(int i = 0; i< 600; i++){
            System.out.println("main thread runs " + i);
        }
    }
}

// 用数学去分析线程很有意思啊。

// 我喜欢360是什么鬼意思。

// 设置线程的名称也是有意义的
// 线程1和线程0的同一个方法局部变量在每一个线程中都有独立的一份。其实还是
// 局部变量在多线程中的分配是什么样的？
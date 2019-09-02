/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 9/2/19 11:31 AM
 */

package com.jdk.thread;

import sun.java2d.loops.TransformHelper;

public class VolatileVisibilityTest {

    private static volatile boolean initFlg  = false;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("wating data...");
                while(!initFlg){

                }
                System.out.println("===========success");
            }
        });
        t1.start();

        Thread.sleep(2000);
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                prepareData();
            }
        });

        t2.start();

        t1.join();
        t2.join();
/*        while(true){
            ;
        }*/
    }

    public static void prepareData(){
        System.out.println("preparing data....");
        initFlg = true;
        System.out.println("preparing end");
    }
}

// 虚拟机选项
// -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly

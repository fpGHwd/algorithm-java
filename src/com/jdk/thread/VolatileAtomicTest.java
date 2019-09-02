/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 9/2/19 4:27 PM
 */

package com.jdk.thread;

public class VolatileAtomicTest {

    public static volatile  int num = 0;

    public static void increase(){
        num++; // num = num + 1
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for(int i = 0; i < threads.length; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0; i < 1000; i++){
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        for(Thread t:threads){
            t.join();
        }

        System.out.println(num); // 1000 * 10 = 10000
        // 9701
        // 原子性被数字放大了，每次数字都是不同的，反映了机器的性能
        // 论文与一致性
        // 偶尔会10000
    }

}

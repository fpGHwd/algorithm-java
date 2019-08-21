/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/19/19 6:58 PM
 */

package com.jdk.future;

import java.util.concurrent.*;

/**
 * 试验 Java 的 Future 用法
 */
public class FutureTest {

    /*
     * step 1:
     * runnable实现的没有返回值的并发编程
     */
    public static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getId());
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            es.submit(new Task());
        }
    }
}
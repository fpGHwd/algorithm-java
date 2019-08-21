/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/19/19 7:01 PM
 */

package com.jdk.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FutureTest1 {


    /*
     * step 2:
     * callable实现的有返回值的并发编程
     * call的返回值受泛型的影响
     */
    public static class Task implements Callable<String> {
        @Override
        public String call() throws Exception{
            System.out.println(Thread.currentThread().getId());
            return String.valueOf(Thread.currentThread().getId());
        }
    }
    public static void main(String[] args){
        ExecutorService es = Executors.newCachedThreadPool();
        for(int i = 0; i < 10; i++){
            es.submit(new Task());
        }
    }

}

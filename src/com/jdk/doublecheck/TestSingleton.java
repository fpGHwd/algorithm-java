package com.jdk.doublecheck;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class TestSingleton extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
                System.out.println(Singleton.getUniqueInstance().hashCode());
        }
    }

    @Test
    public void testSingleton() throws InterruptedException {
        Set<Singleton> result = new HashSet<>();
        Thread[] threads = new Thread[100];
        for(int i = 0 ; i < threads.length ; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 5; i++) {
                        Singleton s = Singleton.getUniqueInstance();
                        result.add(s);
                    }
                }
            });
            threads[i].start();
            threads[i].join();
        }
        System.out.println(result.size());
    }

    @Test
    public void testSingletonWithoutVolatile() throws InterruptedException {
        Set<SingletonWithoutVolatile> result = new HashSet<>();
        Thread[] threads1 = new Thread[100];
        for(int i = 0 ; i < threads1.length ; i++){
            threads1[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 5; i++) {
                        SingletonWithoutVolatile swv = SingletonWithoutVolatile.getInstance();
                        result.add(swv);
                    }
                }
            });
            threads1[i].start();
            threads1[i].join();
        }
        System.out.println(result.size());
    }
    // 没有出现想要的可能会出现两个不同的实例的问题
}

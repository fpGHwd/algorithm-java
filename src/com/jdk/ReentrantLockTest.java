package com.jdk;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private static Lock bankLock = new ReentrantLock();

    private static double[] accounts = new double[10];

    public static double getTotalBalance(){
        bankLock.lock();
        try {
            double sum = 0;
            for (double a : accounts)
                sum += a;

            return sum;
        }finally {
            bankLock.unlock();
        }
    }
}

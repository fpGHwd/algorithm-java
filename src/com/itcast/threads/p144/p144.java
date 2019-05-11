/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       19-5-10
 * @Time:       下午8:50
 * @Project:    algorithm
 */

package com.itcast.threads.p144;

class Ticket implements Runnable{
    // 线程还是CPU的问题
    private Object obj = new Object();
    private int tick = 1000;
    boolean flag = true;

    public void run(){
        if(flag){
            while(true){
                synchronized (obj){
//                    System.out.println("runs here");
                        /*try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            System.out.println(Thread.currentThread().getName() + "....code : " + tick--);
                        }*/
                        show();
                }
            }
        }else
            while(true)
                show();
    }

    /**
     * this锁里有object锁，object锁里有this锁
     */
    public synchronized void show(){
        synchronized (obj){
            if(tick>0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
                System.out.println(Thread.currentThread().getName() + "....show : " + tick--);

            }
        }
    }
}

// 所有的问题都是序列化的问题
public class p144 {
    public static void main(String[] args){
        Ticket t = new Ticket();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
//        System.out.println("runs here");
        t1.start();
        // 这一段的意义是保证t1进入上一个while循环
        try{
            Thread.sleep(10);
        }catch (Exception e){

        }

        t.flag = false;
        t2.start();
    }
}

class Test implements Runnable{
    private boolean flag;
    Test(boolean flag){
        this.flag =flag;
    }

    public void run(){
        if(flag){
            synchronized (MyLock.locka){
                System.out.println("if locka");
                synchronized (MyLock.lockb){
                    System.out.println("if lockb");

                }
            }
        }else{
            synchronized (MyLock.lockb){
                System.out.println("if lockb");
                synchronized (MyLock.locka){
                    System.out.println("if locka");

                }
            }

        }
    }


}

class MyLock{
    static Object locka = new Object();
    static Object lockb = new Object();
}

class DeadLockTest{
    public static void  main(String[] args){
        Test t1 = new Test(true);
        Test t2 = new Test(false);
        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t2);
        th1.start();th2.start();

        /**
         * 多运行几次后会出现死锁，这里运行了两次
         * if locka
         * if lockb
         *
         * 一直和谐的情况比较少
         *
         * 如果一起在synchronized外面都加while(true)是都可以的。
         *
         * 死锁理解，就会避免死锁
         */
    }
}

/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       19-5-11
 * @Time:       上午12:29
 * @Project:    algorithm
 */

package com.itcast.threads.p150;

//public class p150 {
// 里程碑的JDK1.5版本
// condition接口
//}


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resource {
    private boolean flag = true; // 这个标志那个先执行，当然是生产先执行
    private int count = 1;
    private String name;
    private Lock lock = new ReentrantLock();
    private Condition condition_pro = lock.newCondition();
    private Condition condition_con = lock.newCondition();

    public void set(String name) throws InterruptedException {
        lock.lock();
        try{
            while (flag) // flag代表有资源
                condition_pro.await();
            System.out.println(Thread.currentThread().getName() + "商品...生产.........." + ++count);
            this.name = name;
            flag = true;
            condition_con.signal(); // con1指代out一方操作，唤醒某个消费者
        }finally {
            // 释放资源的操作，同理数据库
            lock.unlock(); // 在异常中要finally释放锁。只用try{}finally{}
        }

    }


    public void out() throws InterruptedException {
        lock.lock();
        try{
            while (!flag) condition_con.await(); // flag代表有资源，!flag为真则没有
            System.out.println(Thread.currentThread().getName() + "...商品消耗..." + count);
            flag = false;

            condition_pro.signal(); // con指代set一方操作，唤醒某个生产者
        }finally {
            lock.unlock();

        }

    }
}


class Consumer implements Runnable {
    private Resource res;

    Consumer(Resource res) {
        this.res = res;
    }


    @Override
    public void run() {

        while (true) {
            try {
                res.out();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer implements Runnable {
    private Resource res;

    Producer(Resource res) {
        this.res = res;
    }


    @Override
    public void run() {
        while (true) {
            try {
                res.set("商品");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

public class p150 {


    public static void main(String[] args) {
        Resource res = new Resource();
        new Thread(new Consumer(res)).start();
        new Thread(new Producer(res)).start();
        new Thread(new Consumer(res)).start();
        new Thread(new Producer(res)).start();
    }


    /**
     * Thread-3商品...生产..........286929
     * Thread-2...商品消耗...286929
     * Thread-3商品...生产..........286930
     * Thread-2...商品消耗...286930
     * Thread-3商品...生产..........286931
     * Thread-2...商品消耗...286931
     * Thread-3商品...生产..........286932
     * Thread-2...商品消耗...286932
     * Thread-3商品...生产..........286933
     * Thread-2...商品消耗...286933
     * Thread-3商品...生产..........286934
     */

    /**
     * 如果是signal()则会死锁
     * 如果是if(true)则会数据异常
     */

    /**
     * 新特性：只唤醒对方，不唤醒己方（操作）。。。很明显了，呼之欲出
     *
     * 一下就能懂的。
     */

    /**
     * Thread-1商品...生产..........247773
     * Thread-0...商品消耗...247773
     * Thread-3商品...生产..........247774
     * Thread-2...商品消耗...247774
     * Thread-1商品...生产..........247775
     * Thread-0...商品消耗...247775
     * Thread-3商品...生产..........247776
     * Thread-2...商品消耗...247776
     * Thread-1商品...生产..........247777
     * Thread-0...商品消耗...247777
     * Thread-3商品...生产..........247778
     * Thread-2...商品消耗...247778
     * Thread-1商品...生产..........247779
     * Thread-0...商品消耗...247779
     * Thread-3商品...生产..........247780
     * Thread-2...商品消耗...247780
     * Thread-1商品...生产..........247781
     *
     */

    /**
     * JDK1.5中提供了多线程的升级解决方案。
     * 将同步Synchronized替换成显式的Lock操作
     *
     * 就像硬件升级以上，软件跟随硬件的升级。。。提高效率
     */


    /***
     * 多一点这样的理解：flag就是资源的数目和满足的条件。condition就是围绕flag做的
     */
}
/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       19-5-10
 * @Time:       下午11:44
 * @Project:    algorithm
 */

package com.itcast.threads.p149;


class Resource{
    private boolean flag = true; // 这个标志那个先执行，当然是生产先执行
    private int count  = 0;
    private String name;

    public synchronized void set(String name){
        while(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "商品...生产.........."+ ++count);
        this.name  = name;
//        count++;
        flag = true;
        this.notifyAll();
    }


    /**
     * 商品++，生产95019
     * 商品--，消耗95019
     * 商品++，生产95020
     * 商品--，消耗95020
     * 商品++，生产95021
     * 商品--，消耗95021
     * 商品++，生产95022
     * 商品--，消耗95022
     * 商品++，生产95023
     * 商品--，消耗95023
     * 商品++，生产95024
     * 商品--，消耗95024
     */

    public synchronized void out(){
        while(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "...商品消耗..."+ count);
        flag = false;
        this.notifyAll();
    }
}


class Consumer implements Runnable{
    private Resource res;
    Consumer(Resource res){
        this.res = res;
    }


    @Override
    public void run() {
        while(true)
        res.out();
    }
}

class Producer implements Runnable{
    private Resource res;
    Producer(Resource res){
        this.res = res;
    }


    @Override
    public void run() {
        while(true)
        res.set("商品");
    }
}

public class p149 {

    // 生产者和消费者：就是一个池子

    public static void main(String[] args){
        Resource res  =new Resource();
        new Thread(new Consumer(res)).start();
        new Thread(new Producer(res)).start();
        new Thread(new Consumer(res)).start();
        new Thread(new Producer(res)).start();

        /*Thread-0...商品消耗...55434
        Thread-3商品...生产..........55435
        Thread-2...商品消耗...55435
        Thread-0...商品消耗...55435
        Thread-3商品...生产..........55436
        Thread-2...商品消耗...55436
        Thread-0...商品消耗...55436
        Thread-3商品...生产..........55437
        Thread-2...商品消耗...55437
        Thread-0...商品消耗...55437
        Thread-3商品...生产..........55438
        Thread-2...商品消耗...55438
        Thread-0...商品消耗...55438
        Thread-3商品...生产..........55439*/
        /**
         * 生产一次消费两次。说明这个代码不适合多个线程。只适合两个线程。
         */
        /**
         * 生产了两个
         *
         * // 每次醒的时候都判断
         * // 而且不要都等待，
         * // 所以notifyAll就出来了。
         */
    }

    // 指定商品的数量 -- 数字

}

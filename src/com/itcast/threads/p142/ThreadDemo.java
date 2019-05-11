/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/5/19
 * @Time:       8:35 PM
 * @Project:    algorithm
 */

package com.itcast.threads.p142;

class Ticket implements Runnable {

    static int tickets = 100;
    private Object obj = new Object();
    boolean flag = true;

    public void run() {
        if(flag) {
            while (true) {
                synchronized (Ticket.class) {
                    if (tickets > 0) {
                        try {
                            Thread.sleep(10); // 这是为了产生一个-1出现的点
                        } catch (Exception e) { // 接口不能抛异常，只能try catch // run是一个接口不是复写的方法。
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "Ticket run code " + tickets--);
                    }
                }
            }
        }else{
            while(true) {
                show();
            }
        }
    }

    public static synchronized void show(){
        if (tickets > 0) {
            try {
                Thread.sleep(10); // 这是为了产生一个-1出现的点
            } catch (Exception e) { // 接口不能抛异常，只能try catch // run是一个接口不是复写的方法。
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "Ticket method show " + tickets--);
        }
    }
}


public class ThreadDemo {
    public static void main(String[] args) {
        Ticket pr = new Ticket();
//        new Thread(pr).start();

        Thread t1 = new Thread(pr);
        Thread t2 = new Thread(pr);
//        Thread t3 = new Thread(pr);
//        Thread t4 = new Thread(pr);
        t1.start();
        try {
            Thread.sleep(10); // 让主线程停一下，让t1执行一下
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pr.flag = false;
        t2.start();
//        t3.start();
//        t4.start();

    }

}

/*

静态函数的锁是什么？
当继续使用this作为代码块的锁的时候，结果为
Thread-1Ticket method show 11
Thread-0Ticket run code 10
Thread-1Ticket method show 9
Thread-0Ticket run code 8
Thread-1Ticket method show 7
Thread-0Ticket run code 6
Thread-1Ticket method show 5
Thread-0Ticket run code 4
Thread-1Ticket method show 3
Thread-0Ticket run code 2
Thread-1Ticket method show 1
Thread-0Ticket run code 0

有错。说明锁不是this

将代码块锁改称class，后测试结果为：
（你认为是obj）静态函数出来的时候没有对象。所以猜想为Ticket.class

Ticket.class是字节码文件对象

结果为：
Thread-0Ticket run code 100
Thread-0Ticket run code 99
Thread-0Ticket run code 98
Thread-0Ticket run code 97
Thread-0Ticket run code 96
Thread-0Ticket run code 95
Thread-0Ticket run code 94
Thread-0Ticket run code 93
Thread-0Ticket run code 92
Thread-0Ticket run code 91
Thread-0Ticket run code 90
Thread-0Ticket run code 89
Thread-0Ticket run code 88
Thread-0Ticket run code 87
Thread-0Ticket run code 86
Thread-1Ticket method show 85
Thread-1Ticket method show 84
Thread-1Ticket method show 83
Thread-1Ticket method show 82
Thread-1Ticket method show 81
Thread-1Ticket method show 80
Thread-1Ticket method show 79
Thread-1Ticket method show 78
Thread-1Ticket method show 77
Thread-1Ticket method show 76
Thread-1Ticket method show 75
Thread-1Ticket method show 74
Thread-1Ticket method show 73
Thread-1Ticket method show 72
Thread-1Ticket method show 71
Thread-1Ticket method show 70
Thread-1Ticket method show 69
Thread-1Ticket method show 68
Thread-1Ticket method show 67
Thread-1Ticket method show 66
Thread-1Ticket method show 65
Thread-1Ticket method show 64
Thread-1Ticket method show 63
Thread-1Ticket method show 62
Thread-1Ticket method show 61
Thread-1Ticket method show 60
Thread-1Ticket method show 59
Thread-1Ticket method show 58
Thread-1Ticket method show 57
Thread-1Ticket method show 56
Thread-1Ticket method show 55
Thread-1Ticket method show 54
Thread-1Ticket method show 53
Thread-1Ticket method show 52
Thread-1Ticket method show 51
Thread-1Ticket method show 50
Thread-1Ticket method show 49
Thread-1Ticket method show 48
Thread-1Ticket method show 47
Thread-1Ticket method show 46
Thread-1Ticket method show 45
Thread-1Ticket method show 44
Thread-1Ticket method show 43
Thread-1Ticket method show 42
Thread-1Ticket method show 41
Thread-1Ticket method show 40
Thread-1Ticket method show 39
Thread-1Ticket method show 38
Thread-1Ticket method show 37
Thread-1Ticket method show 36
Thread-1Ticket method show 35
Thread-1Ticket method show 34
Thread-1Ticket method show 33
Thread-1Ticket method show 32
Thread-1Ticket method show 31
Thread-1Ticket method show 30
Thread-1Ticket method show 29
Thread-1Ticket method show 28
Thread-1Ticket method show 27
Thread-1Ticket method show 26
Thread-1Ticket method show 25
Thread-1Ticket method show 24
Thread-1Ticket method show 23
Thread-1Ticket method show 22
Thread-1Ticket method show 21
Thread-1Ticket method show 20
Thread-1Ticket method show 19
Thread-1Ticket method show 18
Thread-1Ticket method show 17
Thread-1Ticket method show 16
Thread-1Ticket method show 15
Thread-1Ticket method show 14
Thread-1Ticket method show 13
Thread-1Ticket method show 12
Thread-1Ticket method show 11
Thread-1Ticket method show 10
Thread-1Ticket method show 9
Thread-1Ticket method show 8
Thread-1Ticket method show 7
Thread-1Ticket method show 6
Thread-1Ticket method show 5
Thread-1Ticket method show 4
Thread-1Ticket method show 3
Thread-1Ticket method show 2
Thread-1Ticket method show 1

0没有了，而且thread0和thread1都出现了

*/

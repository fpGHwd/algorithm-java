/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       19-5-11
 * @Time:       上午8:32
 * @Project:    algorithm
 */

package com.itcast.threads.p153;

/**
 * join的特点
 */

class Demo implements Runnable{
    public void run(){
        for(int x = 0; x < 70; x++){
            System.out.println(Thread.currentThread().getName() + "......" + x);
        }
    }
}

public class p153 {

    // join什么意思，。。这个很重要，就是join us的意思
    // join就是需要执行权，对应于interrupt。。不过两者类似

    public static void main(String[] args) throws InterruptedException{
        Demo d = new Demo();
        Thread t1 = new Thread(d);
        Thread t2 = new Thread(d);

        t1.start();
//        t1.join();


        t2.start();
        t1.join();
        t2.join();

        for(int x = 0; x< 80; x++){
            System.out.println("main.... " + x);
        }
        System.out.println("over");


        /** 没有join
         * Thread-1......0
         * Thread-0......0
         * main.... 0
         * Thread-0......1
         * Thread-0......2
         * Thread-0......3
         * Thread-0......4
         * Thread-0......5
         * Thread-1......1
         * Thread-0......6
         * Thread-0......7
         * main.... 1
         * Thread-0......8
         * Thread-0......9
         */

        /**
         * t1 join主线程 位置载t1和t2之间
         *
         * Thread-0......63
         * Thread-0......64
         * Thread-0......65
         * Thread-0......66
         * Thread-0......67
         * Thread-0......68
         * Thread-0......69
         * main.... 0
         * main.... 1
         * main.... 2
         * main.... 3
         * main.... 4
         * main.... 5
         * main.... 6
         *
         *
         * Thread-1......33
         * main.... 50
         * Thread-1......34
         * Thread-1......35
         * Thread-1......36
         * main.... 51
         * Thread-1......37
         * Thread-1......38
         * main.... 52
         * Thread-1......39
         * Thread-1......40
         * main.... 53
         * Thread-1......41
         * main.... 54
         * main.... 55
         * main.... 56
         */

        /**
         * t1.join()在t2之后：主线程载t1之后，和t2争夺执行权
         *
         * Thread-0......65
         * Thread-0......66
         * Thread-0......67
         * Thread-0......68
         * Thread-0......69
         * main.... 0
         * main.... 1
         * main.... 2
         * Thread-1......0
         * Thread-1......1
         * Thread-1......2
         * Thread-1......3
         * Thread-1......4
         * main.... 3
         * Thread-1......5
         */


        /**
         * t1.join 和t2.join在两者开始之后，两者会有争夺执行权的时间。
         * 然后t1执行完，t2执行完，再main执行完。前提是t1和t2任务量可以还没有执行完
         *
         * Thread-0......65
         * Thread-0......66
         * Thread-0......67
         * Thread-1......17
         * Thread-0......68
         * Thread-1......18
         * Thread-0......69
         * Thread-1......19
         * Thread-1......20
         * Thread-1......21
         * Thread-1......22
         * Thread-1......23
         * Thread-1......24
         * Thread-1......25
         * Thread-1......26
         * Thread-1......27
         * Thread-1......28
         * Thread-1......29
         * Thread-1......30
         * Thread-1......31
         * Thread-1......32
         * Thread-1......33
         * Thread-1......34
         * Thread-1......35
         * Thread-1......36
         * Thread-1......37
         * Thread-1......38
         * Thread-1......39
         * Thread-1......40
         * Thread-1......41
         * Thread-1......42
         * Thread-1......43
         * Thread-1......44
         * Thread-1......45
         * Thread-1......46
         * Thread-1......47
         * Thread-1......48
         * Thread-1......49
         * Thread-1......50
         * Thread-1......51
         * Thread-1......52
         * Thread-1......53
         * Thread-1......54
         * Thread-1......55
         * Thread-1......56
         * Thread-1......57
         * Thread-1......58
         * Thread-1......59
         * Thread-1......60
         * Thread-1......61
         * Thread-1......62
         * Thread-1......63
         * Thread-1......64
         * Thread-1......65
         * Thread-1......66
         * Thread-1......67
         * Thread-1......68
         * Thread-1......69
         * main.... 0
         * main.... 1
         * main.... 2
         * main.... 3
         * main.... 4
         * main.... 5
         * main.... 6
         * main.... 7
         */
    }



}

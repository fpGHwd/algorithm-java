/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/5/19
 * @Time:       8:13 PM
 * @Project:    algorithm
 */

package com.itcast.multithread.p141;


// 如果给run方法加上synchronized，就会失去多线程的特质啊。只有一个线程在做一件事情。

class Ticket implements Runnable {

    static int tickets = 1000;
    private Object obj = new Object();
    boolean flag = true;

    public void run() {
        if(flag) {
            while (true) {
                synchronized (this) {
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

    public synchronized void show(){
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
同步函数用的锁是什么锁？
this
函数需要被对象调用，所以函数都有一个所属对象引用，就是this。
所以同步函数用的锁就是this。

验证是this？


程序不要求能写，但是只有一个结论的话就很郁闷。

都加了锁，但是没有加同一个锁。
 */


/*
并没有同步的结果：最后一条结果为0（两个代码块的延时都需要）

/usr/lib/jvm/java-8-jdk/bin/java -javaagent:/opt/intellij-idea-ultimate-edition/lib/idea_rt.jar=41997:/opt/intellij-idea-ultimate-edition/bin -Dfile.encoding=UTF-8 -classpath /usr/lib/jvm/java-8-jdk/jre/lib/charsets.jar:/usr/lib/jvm/java-8-jdk/jre/lib/deploy.jar:/usr/lib/jvm/java-8-jdk/jre/lib/ext/cldrdata.jar:/usr/lib/jvm/java-8-jdk/jre/lib/ext/dnsns.jar:/usr/lib/jvm/java-8-jdk/jre/lib/ext/jaccess.jar:/usr/lib/jvm/java-8-jdk/jre/lib/ext/jfxrt.jar:/usr/lib/jvm/java-8-jdk/jre/lib/ext/localedata.jar:/usr/lib/jvm/java-8-jdk/jre/lib/ext/nashorn.jar:/usr/lib/jvm/java-8-jdk/jre/lib/ext/sunec.jar:/usr/lib/jvm/java-8-jdk/jre/lib/ext/sunjce_provider.jar:/usr/lib/jvm/java-8-jdk/jre/lib/ext/sunpkcs11.jar:/usr/lib/jvm/java-8-jdk/jre/lib/ext/zipfs.jar:/usr/lib/jvm/java-8-jdk/jre/lib/javaws.jar:/usr/lib/jvm/java-8-jdk/jre/lib/jce.jar:/usr/lib/jvm/java-8-jdk/jre/lib/jfr.jar:/usr/lib/jvm/java-8-jdk/jre/lib/jfxswt.jar:/usr/lib/jvm/java-8-jdk/jre/lib/jsse.jar:/usr/lib/jvm/java-8-jdk/jre/lib/management-agent.jar:/usr/lib/jvm/java-8-jdk/jre/lib/plugin.jar:/usr/lib/jvm/java-8-jdk/jre/lib/resources.jar:/usr/lib/jvm/java-8-jdk/jre/lib/rt.jar:/home/suzumiya/IdeaProjects/algorithm/out/production/algorithm:/home/suzumiya/.m2/repository/junit/junit/4.12/junit-4.12.jar:/home/suzumiya/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar com.itcast.multithread.p141.ThreadDemo
Thread-0Ticket run code 100
Thread-1Ticket method show 99
Thread-0Ticket run code 98
Thread-1Ticket method show 97
Thread-0Ticket run code 96
Thread-1Ticket method show 95
Thread-0Ticket run code 94
Thread-1Ticket method show 93
Thread-0Ticket run code 92
Thread-1Ticket method show 91
Thread-0Ticket run code 90
Thread-1Ticket method show 89
Thread-0Ticket run code 88
Thread-1Ticket method show 87
Thread-0Ticket run code 86
Thread-1Ticket method show 85
Thread-0Ticket run code 84
Thread-1Ticket method show 83
Thread-0Ticket run code 82
Thread-1Ticket method show 81
Thread-0Ticket run code 80
Thread-1Ticket method show 79
Thread-0Ticket run code 78
Thread-1Ticket method show 77
Thread-0Ticket run code 76
Thread-1Ticket method show 75
Thread-0Ticket run code 74
Thread-1Ticket method show 73
Thread-0Ticket run code 72
Thread-1Ticket method show 71
Thread-0Ticket run code 70
Thread-1Ticket method show 69
Thread-0Ticket run code 68
Thread-1Ticket method show 67
Thread-0Ticket run code 66
Thread-1Ticket method show 65
Thread-0Ticket run code 64
Thread-1Ticket method show 63
Thread-0Ticket run code 62
Thread-1Ticket method show 61
Thread-0Ticket run code 60
Thread-1Ticket method show 59
Thread-0Ticket run code 58
Thread-1Ticket method show 57
Thread-0Ticket run code 56
Thread-1Ticket method show 55
Thread-0Ticket run code 54
Thread-1Ticket method show 53
Thread-0Ticket run code 52
Thread-1Ticket method show 51
Thread-0Ticket run code 50
Thread-1Ticket method show 49
Thread-0Ticket run code 48
Thread-1Ticket method show 47
Thread-0Ticket run code 46
Thread-1Ticket method show 45
Thread-0Ticket run code 44
Thread-1Ticket method show 43
Thread-0Ticket run code 42
Thread-1Ticket method show 41
Thread-0Ticket run code 40
Thread-1Ticket method show 39
Thread-0Ticket run code 38
Thread-1Ticket method show 37
Thread-0Ticket run code 36
Thread-1Ticket method show 35
Thread-0Ticket run code 34
Thread-1Ticket method show 33
Thread-0Ticket run code 32
Thread-1Ticket method show 31
Thread-0Ticket run code 30
Thread-1Ticket method show 29
Thread-0Ticket run code 28
Thread-1Ticket method show 27
Thread-0Ticket run code 26
Thread-1Ticket method show 25
Thread-0Ticket run code 24
Thread-1Ticket method show 23
Thread-0Ticket run code 22
Thread-1Ticket method show 21
Thread-0Ticket run code 20
Thread-1Ticket method show 19
Thread-0Ticket run code 18
Thread-1Ticket method show 17
Thread-0Ticket run code 16
Thread-1Ticket method show 15
Thread-0Ticket run code 14
Thread-1Ticket method show 13
Thread-0Ticket run code 12
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

 */


/*
把obj改成this后的结果是同步的：——只能说明，不能证明，不过也差不多了

这个计算机处理速度过快，需要ticket设定为1000才有效果


Thread-1Ticket method show 744
Thread-1Ticket method show 743
Thread-1Ticket method show 742
Thread-1Ticket method show 741
Thread-1Ticket method show 740
Thread-1Ticket method show 739
Thread-1Ticket method show 738
Thread-1Ticket method show 737
Thread-0Ticket run code 736
Thread-0Ticket run code 735
Thread-0Ticket run code 734
Thread-0Ticket run code 733


Thread-1Ticket method show 186
Thread-1Ticket method show 185
Thread-1Ticket method show 184
Thread-1Ticket method show 183
Thread-0Ticket run code 182
Thread-0Ticket run code 181
Thread-0Ticket run code 180
Thread-0Ticket run code 179
Thread-0Ticket run code 178
Thread-0Ticket run code 177
Thread-0Ticket run code 176
Thread-0Ticket run code 175


Thread-0Ticket run code 9
Thread-0Ticket run code 8
Thread-0Ticket run code 7
Thread-0Ticket run code 6
Thread-0Ticket run code 5
Thread-0Ticket run code 4
Thread-0Ticket run code 3
Thread-0Ticket run code 2
Thread-0Ticket run code 1


没有假期，只有你。

 */
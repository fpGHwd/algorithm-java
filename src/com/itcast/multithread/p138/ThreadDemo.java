/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/5/19
 * @Time:       7:04 PM
 * @Project:    algorithm
 */

package com.itcast.multithread.p138;

class Ticket implements Runnable {

    public static int tickets = 100;
    private Object obj = new Object();

    public void run() {
        while (true) {
            synchronized (obj) {
                if (tickets > 0) {
                    try {
                    Thread.sleep(10); // 这是为了产生一个-1出现的点
                    } catch (Exception e) { // 接口不能抛异常，只能try catch // run是一个接口不是复写的方法。
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "Ticket method run runs " + tickets--);
                }
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        Ticket pr = new Ticket();
//        new Thread(pr).start();

        Thread t1 = new Thread(pr);
        Thread t2 = new Thread(pr);
        Thread t3 = new Thread(pr);
        Thread t4 = new Thread(pr);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

}

/*
什么问题啊？
多个线程同时操作一个static变量。

这里的关键是如何创建一个会发生错误的情况。

以及解决方案：
同步代码块

那些代码需要同步，就是判断那些语句在操作共享数据。

突然觉得你做的事情就是你自己本身。

同步锁只要是对象就行。


p139
synchronized 肯定存在锁的检查机制，这个不需要别人告诉你，只能靠自己想。好在我已经想到了。
当然这个检查机制是由线程本身来检查的。
对对对，线程本身来检查这个锁的。

下次上厕所说同步一下。
不要怕忘记了，只要理解了联系了基本就不会忘记。比如今天师兄问起的正向代理和反向代理。我最近还想到了，所以就知道。


A：一个人需要锁门吗，不需要。
B：老师，一个人还要去厕所吗？（这个很机灵的段子，但是只要广泛用了联系的思维还是容易想起来这个玩笑的。）
A：还是去吧。


同步锁，解决了多线程的同步问题。
线程会自动判断锁，所以增加了资源的消耗。
不需要把所有的代码放入加锁的代码块。
越安全越麻烦。。这是同步锁的弊端。但是没办法。都是用时间和空间换另外的时空（安全本身也是时空）
 */
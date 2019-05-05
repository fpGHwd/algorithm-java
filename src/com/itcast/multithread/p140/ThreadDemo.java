/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/5/19
 * @Time:       7:51 PM
 * @Project:    algorithm
 */

package com.itcast.multithread.p140;

// 多线程同步函数

class Bank{
    private int sum = 0;
    private final Object obj = new Object(); // 上帝不错，找上帝帮我看一下。
    void add(int a){ // 这里可以抛出异常，但是在run中必须要catch，所以为了不麻烦直接在这里catch
//        try {
//            Thread.sleep(1000); // 100时概率比较高
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        synchronized (this.obj) {
            sum += a;
            System.out.println("sum: " + this.sum);
        }
    }
}

class Client implements Runnable{ //
    private Bank b ;
    Client(Bank b){
        this.b =b ;
    }
    public void run(){
        for(int x= 0; x < 3; x++){

            // 如果在for那里添加同步锁，那么只能前面一个人存了300后，后面一个人才能存。就是有序了。所以这个精度还是可以控制的。
            b.add(100);
        }
    }
}

public class ThreadDemo {


    public static void main(String[] args){
        Bank b = new Bank();
        Client c = new Client(b);
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();

    }

}


/*
操作共享数据的语句只有一句
可以是在run里面
也可以是在add里面


没有找到关键可能是因为，你没有花时间在关键上。这与你脑子聪明不聪明并没有特别的关系。
但是关键是必须要找的。


函数封装代码的好处和坏处。
同步有两种方式：同步函数和同步代码块
 */
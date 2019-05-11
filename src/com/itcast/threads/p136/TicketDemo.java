/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/5/19
 * @Time:       9:35 AM
 * @Project:    algorithm
 */

package com.itcast.threads.p136;

class Ticket extends Thread{
    private static int tick = 10;
    public void run(){
        while(true){
            if(tick > 0){
                System.out.println(Thread.currentThread().getName()+": " + tick--);
            }
        }
    }
}

public class TicketDemo {
    public static void main(String[] args){
        Ticket t1 = new Ticket();
        Ticket t2 = new Ticket();
        Ticket t3 = new Ticket();
        Ticket t4 = new Ticket();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

// 已经运行的程序不能再次start()
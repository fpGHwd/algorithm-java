/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/5/19
 * @Time:       6:50 PM
 * @Project:    algorithm
 */

package com.itcast.threads.p137;

class Ticket implements Runnable{

    public void run(){
        System.out.println("Ticket method run runs");
    }
}

public class TestRunnable {
    public static void main(String[] args){
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
runnable接口就是要运行的代码，完了。
 */

/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       19-5-11
 * @Time:       上午1:14
 * @Project:    algorithm
 */

package com.itcast.threads.p151;

import org.junit.Test;


class StopThread implements Runnable{

    private boolean flag = true; // flag真不停止

    public synchronized void run(){
        while(flag){
            try{
                this.wait(); // 监视器指的就是同步锁，这里是this，所以this有两个角色
            }catch (InterruptedException ie){
                System.out.println(ie); // 停止线程的方法
                flag = false;
                // Interrupt后就是异常
            }
            System.out.println(Thread.currentThread().getName()+"....run");
        }
    }

    public void changeFlag(){
        flag = !flag;
    }
}

public class p151 {
    // stop结束
    // 停止线程用run方法结束
    // 控制住循环
    // 如何让线程停止

    @Test
    public void testStopThread() throws InterruptedException {
        StopThread st = new StopThread();
//        int tc = 3;
//        Thread[] threads = new Thread[tc];
//        for(int i = 0; i< tc; i++){
//            Thread t = new Thread(st);
//            threads[i] = t;
//            t.start();
//        }

/*        Thread.sleep(2000);
        st.changeFlag();*/

        Thread t1 = new Thread(st);
        Thread t2 = new Thread(st);
        t1.start();t2.start();
/*
        for(int i = 0; i< 60; i++){
            System.out.println(Thread.currentThread().getName() +" ....." + i);
        }
        st.changeFlag();*/


        int num = 0;
        while(true){
            if(num++ == 60){
//                st.changeFlag();
                t1.interrupt();
                t2.interrupt();
                break;
            }
            System.out.println(Thread.currentThread().getName() + "........" + num);
        }

        System.out.println("over");



    }

    // Interrupt: 一砖头。清除线程的冻结状态。
    // 恢复到运行状态，就离不愿了
    // Interrupt 结束线程的冻结状态，使线程恢复到运行状态中来
    // stop已经弃用
    // 冻结状态被中断，则是终端异常。


    // Interrupt就是让它动一下，获取一下运行资格，外界条件改变了呢
}

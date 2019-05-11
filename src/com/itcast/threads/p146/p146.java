/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       19-5-10
 * @Time:       下午9:43
 * @Project:    algorithm
 */

package com.itcast.threads.p146;

class Res {
    private boolean flag = true;
    private String name;
    private String sex;
    private Object obj = new Object();

    //---------------------------------------------

    // 把锁和同步还有wait还有notify都放到资源当中
    public void set(String name, String sex) {
        synchronized (obj) {
            if (flag) {

                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.name = name;
            this.sex = sex;
            flag = true;
            obj.notify();

        }
    }

    public void out() {
        synchronized (obj) {
            if (!flag) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(this.name + "......" + this.sex);
            flag = false;
            obj.notify();

        }
    }

    //------------------------------------------------对应一组set和get

//    public void setFlag(boolean flag){
//        this.flag = flag;
//    }

//    public boolean getFlag(){
//        return flag;
//    }

//    public Object getObject(){
//        return obj;
//    }

}

class Input implements Runnable {
    private Res r;

    Input(Res r) {
        this.r = r;
    }

    public void run() {
        int x = 0;
        while (true) {
            ;

//            synchronized (r.getObject()) {
//                if(r.getFlag()){ // 直接用r作为锁也可以，r是资源嘛
//                    try {
//                        r.getObject().wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
            if (x == 0) {
                r.set("mike", "man");
            } else {
                r.set("丽丽", "女女女女女");
            }
            x = (x + 1) % 2;
/*                r.setFlag(true); // 偏向于自己停止，因为自己不能太多操作
                r.getObject().notify();
            }*/

        }
    }
}

class Output implements Runnable {
    private Res r;

    Output(Res r) {
        this.r = r;
    }

    public void run() {
        while (true) {

//            synchronized (r.getObject()) {
//                if(!r.getFlag()){
//                    try {
//                        r.getObject().wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
            r.out();
//                r.setFlag(false); // 偏向于停止自己
//                r.getObject().notify();
//                // 放在消耗代码中
//            }

        }
    }
}

public class p146 {

    // 线程通信
    // 同步操作，同步操作的一种形式
    // 中间的沟通空间就是消息的一种形式
    // 三个要素：资源，补充，消耗。测试

    public static void main(String[] args) {
        // 单例设计模式，在这里有点复杂。
        // 静态。。运行完了还在。

        Res r = new Res();
//        Thread t1 = new Thread(new Output(r));
//        Thread t2 = new Thread(new Input(r));
//        t1.start();
//        t2.start();
        new Thread(new Output(r)).start();
        new Thread(new Input(r)).start(); // 代码的优化

        /**
         * mike  ::  man
         * mike  ::  man
         * mike  ::  女女女女
         * 丽丽  ::  man
         * mike  ::  女女女女
         * 丽丽  ::  女女女女
         * 丽丽  ::  man
         * 丽丽  ::  女女女女
         * mike  ::  女女女女
         * mike  ::  女女女女
         * mike  ::  女女女女
         * mike  ::  man
         * 丽丽  ::  man
         * 丽丽  ::  女女女女
         */

        /**
         * mike  ::  man
         * mike  ::  man
         * mike  ::  man
         * mike  ::  man
         * mike  ::  man
         * mike  ::  man
         * mike  ::  man
         * mike  ::  man
         * mike  ::  man
         * mike  ::  man
         * 丽丽  ::  女女女女
         * 丽丽  ::  女女女女
         * 丽丽  ::  女女女女
         * 丽丽  ::  女女女女
         * 丽丽  ::  女女女女
         * 丽丽  ::  女女女女
         * 丽丽  ::  女女女女
         */

        /**
         * 是不是两个线程。
         * 是不是统一把所。
         * 有没有用锁锁住线程操作代码 - Run里面的内容
         *
         * 一般锁就是资源，所以把锁放到资源里最好，他们是同一种东西。
         *
         * 可以用Input.class
         */

        /**
         * 输入发输出了不应当用切换时提交内容。因为本来就是错误的。这是一个小的注意的地方。
         * 涌起来舒服多了，而且基本不用看打了什么。只要拼音最够正确的话。切换的时候也不用注意候选内容
         */

        /**
         * 另外一个，应该是存一个，打印一个，在存一个，再打一个。
         * 输入和输出多次。
         */

        // 线程池，等待的线程都在线程池当中。唤醒是唤醒线程池中的线程。有顺序，按顺序唤醒。

        /**
         * wait notify机制比较低效，我猜的。
         */

        /**
         * 同步 = 锁
         * 锁 = 监视器 r.wait() r.notify() r.notifyAll
         * 监视器 = wait notify notifyAll
         *
         * 任意对象调用的方法应该在上帝Object里面
         *
         * 为什么这些操作线程的方法要定义在Object中呢？
         * 因为这些方法在操作同步中线程时，都必须要标识它们所操作线程持有的锁。
         * （不用那么废话，锁 == 资源 == wait == notify == notifyAll，都是一样的）
         */


        /**
         * 丽丽。。。。。女女女女
         * mike。。。。。man
         * 丽丽。。。。。女女女女
         * mike。。。。。man
         * 丽丽。。。。。女女女女
         * mike。。。。。man
         * 丽丽。。。。。女女女女
         * mike。。。。。man
         * 丽丽。。。。。女女女女
         * mike。。。。。man
         * 丽丽。。。。。女女女女
         * mike。。。。。man
         * 丽丽。。。。。女女女女
         * mike。。。。。man
         * 丽丽。。。。。女女女女
         * mike。。。。。man
         * 丽丽。。。。。女女女女
         * mike。。。。。man
         * 丽丽。。。。。女女女女
         * mike。。。。。man
         * 丽丽。。。。。女女女女
         * mike。。。。。man
         * 丽丽。。。。。女女女女
         * mike。。。。。man
         * 丽丽。。。。。女女女女
         * mike。。。。。man
         *
         *
         * 丽丽......女女女女
         * mike......man
         * 丽丽......女女女女
         * mike......man
         * 丽丽......女女女女
         * mike......man
         * 丽丽......女女女女
         * mike......man
         * 丽丽......女女女女
         * mike......man
         * 丽丽......女女女女
         */

        /**
         * 但是还是感觉有点复杂
         */


        /**
         * 就设置的地方需要被同步。所以申请在set方法中。
         */

        /**
         * 写了两下完全搞熟了。
         * java的定制化CPU，其实就是这样。
         * 使用编程语言就是这样。
         */

        /**
         * 当然在资源里面使用this.wait()和this.notify()挺标准的。
         * 还有synchronized(this)
         */
    }

}

/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/5/19
 * @Time:       9:03 PM
 * @Project:    algorithm
 */

package com.itcast.multithread.p143;


class Single{
    private static Single s = null;

    private Single(){

    }


//    public static synchronized Single getInstance(){ // 懒汉式加锁后会变得低效。
//        // 这里可能有多个线程操作这个静态的属性
//        if(s == null) {
//            // 线程A和B可能都到这里切换，所以可能单例不是单例
//            s = new Single();
//        }
//        return s;
//    }

    public static Single getInstance(){
        if(s == null){
            synchronized (Single.class){ // 俄汉是没有问题，只有一句话。 // 懒汉式延时加载。
                if(s == null){
                    s = new Single();
                }
            }
        }
        return s;
    }
}

public class ThreadDemo {

    public static void main(String[] args){
        System.out.println("Hello, world");
    }
}


// 双重判断减少锁的次数。放在函数里面加锁的锁的判断次数增多。
// 没有判断锁，但是判断了s=null 是一样的。


/*
问题一般都是问懒汉式：
问加什么锁？该类的文件字节码对象。

写一个延迟加载的单例模式实例：就写这个

 */
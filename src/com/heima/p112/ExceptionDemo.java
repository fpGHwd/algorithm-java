/**
 * @author suzumiya
 * @data 4/28/19 11:50 PM
 */

package com.heima.p112;


/**
 * 讲课听的主要还是人家如何把所有东西给你联系起来
 * 能往前走比怎么走更重要，尤其是没钱的时候。不能把时间转化为方式(refined优雅)，而是实现(realize)和成就(accomplishing)
 */
public class ExceptionDemo {

    public static void main(String[] args){
        Demo d = new Demo();
        int x = d.div(4,0);
        System.out.println("x = "+x);
        System.out.println("over");
    }

}


class Demo{
    int div(int a, int b){
        return a/b;
    }
}

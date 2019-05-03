/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 5/3/19
 * @Time: 6:14 PM
 */

package com.heima.p113;

import org.junit.Test;

public class ExceptionHandle {

    @Test
    public void TestExceptionHandle(){

        int a = 4, b = 0;

        try{
            int x = a/b;
            System.out.println("x=" +x);

        }catch (Exception e){
            System.out.println(e.getMessage()); // 不多
            System.out.println(e.toString()); // 很多
            System.out.println(e); // 自己调用 e.toString();
            System.out.println("--------------");
            e.printStackTrace(); // 异常名称 + 异常信息 + 异常出现的位置


        }finally {
            System.out.println("finally");
        }
        System.out.print("over");
    }
}

/*

调用发生异常的代码发生一个异常，代码无法处理，交给虚拟机虚拟机的默认处理方法就是停机。

如果代码被检测异常，然后接收异常，继续处理。

exception只是调用方和被调用方的一种互动方式。最终是虚拟机。

回想起以前的处理方式，大多是在自己这一方

吃饭的时候想起：如和在计算机科学上，映射到0-1（此-彼）之上。
如果只讨论计算机本身。那么CPU就是本质，但是其他缓存只是『彼』而已。
其实这是一种很好的理解的方式。
 */

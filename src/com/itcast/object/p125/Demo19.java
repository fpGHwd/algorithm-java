/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/4/19
 * @Time:       6:20 PM
 * @Project:    algorithm
 */

package com.itcast.object.p125;

interface Test1{
    void func();
}

public class Demo19 {
    public static void main(String[] args){
        // 补足（匿名内部类）
        new Demo19().show(new Test1(){
            public void func(){}
        });
    }

    void show(Test1 t){
        t.func();
    }

    // 方法区 ， 对象区， 栈区
}

/*
还是public问题
 */

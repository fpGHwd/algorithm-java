/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/12/19
 * @Time:       5:33 PM
 * @Project:    algorithm
 */

package com.itcast.collections.generictype;


import org.junit.Test;

class Student{

}

class Tool{
    private Object obj;
    public void setObject(Object obj){
        this.obj = obj;

    }

    public Object getObject(){
        return this.obj;
    }
}

class Utils<QQ>{
    private QQ q;
    public void setObject(QQ q){
        this.q = q;
    }
    public QQ getObject(){
        return this.q;
    }
}

public class p190 {
    /**
     * 泛型类
     *
     * 什么时候使用泛型类？
     * 当类中要操作的引用数据类型不确定的时候，
     * 早期（JDK1.4）定义object来完成拓展
     * 现在定义泛型来完成拓展
     *
     * 泛型的出现避免了强转并把错误转移到了编译时期
     */


    @Test
    public void testGenericType(){

        Tool t = new Tool();
        t.setObject(new Student());
        Student s = (Student)t.getObject();

        Utils<Student> us = new Utils<>();
        us.setObject(new Student());
        Student s1 = us.getObject();

    }



}

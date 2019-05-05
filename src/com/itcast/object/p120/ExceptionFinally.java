/*
 * @Author: Suzumiya Haruhi 
 * @Date: 2019-05-03 23:26:51 
 * @Last Modified by: Suzumiya Haruhi
 * @Last Modified time: 2019-05-03 23:57:07
 */

package com.itcast.object.p120;

class FuShuException extends Exception{
    private static final long serialVersionUID = 1L;

    FuShuException(String message) {
        super(message);
    }
}

class Demo
{
    int div(int a, int b) throws FuShuException{
        if(b<0)
            throw new FuShuException("除数为负数");
        return a/b;
    }

}

public class ExceptionFinally {
    public static void main(String[] args){
        Demo d = new Demo();
        try{ // 能处理就写try
            int x  = d.div(4,-1);
            System.out.println("x = " + x);
        }catch(FuShuException e){
            System.out.println(e.toString());
            return;
        }finally{
            System.out.println("finaly"); // finally中存放的是一定会被执行的代码
        }
        System.out.println("over");
    }

    public void callMethod(){
        try{
            method();
        }catch(SQLHandleException e){
            // 处理自己指导的异常
        }finally{
            System.out.println("finally");
        }
        System.out.println("over");
    }

    public void method() throws SQLHandleException{
        try{
            // 连接数据库
        }catch(Exception e){
            // 处理异常
            throw new SQLHandleException("发生了异常"); // 货物没有的问题要上报上去，因为没有给到货物。
        }finally{
            // 关闭连接，释放资源
            System.out.println("finally");
        }
        System.out.println("over");
    }
}

class SQLHandleException extends Exception{
    private static final long serialVersionUID = 1L;

    public SQLHandleException(String message) {
        super(message);
    }
}


// 我觉得我已经比其他人可以了，我知道自己少在那里。比如理解上的归一化。有的人只知道，这个东西就是容易理解，他不明白别人为什么不理解。但是我知道呀。

/**
 * finally 主要用于数据库连接
 * 
 * 1。连接数据库
 * 2。数据库操作
 * 3。关闭数据库（保持服务器的资源不浪费，可用性，无论数据库操作是否成功）
 */
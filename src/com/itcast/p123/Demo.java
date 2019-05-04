/*
 * @Author: Suzumiya Haruhi 
 * @Date: 2019-05-04 00:31:20 
 * @Last Modified by: Suzumiya Haruhi
 * @Last Modified time: 2019-05-04 01:14:19
 */

package com.itcast.p123;

interface Shape{
    double getArea(); // interface本身都是public的
}

class NegativeValueException extends RuntimeException{ // 数值不合法让你停掉，代码需要修正。(做得差不多了)
    // RuntimeException和程序的关系不大

    private static final long serialVersionUID = 1L;

    public NegativeValueException(String message) {
        super(message);
    }

}

 class Circle implements Shape{

    private double radius;
    static double PI = 3.14; // 共享数据，不需要每一个圆都存一份

     Circle(double r){ // RuntimeException不需要throws
        if( r < 0)
            throw new NegativeValueException("圆形的半径是负数");
        radius = r;
    }

    public double getArea(){
        return PI * radius * radius;
    }
 }

class Square implements Shape{
    private double a;

    Square(double a){
        if( a < 0)
            throw new NegativeValueException("正方形的边长是负数");
        this.a = a;
    }

    public double getArea(){
        return this.a * this.a;
    }
}

public class Demo{
    public static void main(String[] args){
        Square s = new Square(1L);
        // Square s1 = new Square(-1);
        Circle c = new Circle(1L);
        Circle c1 = new Circle(-1);
        System.out.println("方形面积 = " + s.getArea() + " 圆形面积 = " + c.getArea());
    }
}

// 以前的日志处理方式会让异常类错误很痛苦
// 异常和分离开来
// try catch的代码块本身就是把正常流程代码和异常代码分开啊。

// 问题也是个对象，封装对象
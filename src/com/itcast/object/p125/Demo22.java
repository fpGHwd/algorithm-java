/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/4/19
 * @Time:       6:35 PM
 * @Project:    algorithm
 */

package com.itcast.object.p125;

class Circle{
    private final static double PI = 3.14;
    private double radius;

    public Circle(double r){
        radius = r;
    }

    public static double Compare(Circle[] cs){
        // 补全代码
        double r = cs[0].radius;
        for(Circle c:cs){
            if( c.radius > r){
                r = c.radius;
            }
        }
        return r;
    }
}

public class Demo22 {
    public static void main(String[] args){
        Circle[] cs = new Circle[3];
//        Circle c1 = new Circle(2L);
//        Circle c2 = new Circle(3L);
//        Circle c3 = new Circle(4L);
//        cs[0] = c1; cs[1] = c2; cs[2] = c3;
        cs[0] = new Circle(2L);
        cs[1] = new Circle(3L);
        cs[2] = new Circle(4L);
//        double r = Circle.Compare(cs);
        System.out.println("最大的半径值是： " + Circle.Compare(cs));
    }
}

/*
数组中的最大值啊。


 */

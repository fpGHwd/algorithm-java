/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/4/19
 * @Time:       6:12 PM
 * @Project:    algorithm
 */

package com.itcast.object.p125;

public class Demo17 {
    public void func(){
        // 位置1
        new Inner();
    }

    class Inner{}
    public static void main(String[] args){
        Demo d = new Demo();
        // 位置2
//        new Inner(); // 加了static就OK
//        new d.Inner();
//        new Demo.Inner();
    }
}

/*
A 位置1写 new Inner()； // OK
B 位置2写 new Inner(); // 错误，main是静态的，除非Inner是静态方法
C 位置2写 new d.Inner(); // 错误，d是对象
D 位置2写 new Demo.Inner(); //错误，Inner不是静态 todo:问题，inner改称静态也不行
 */
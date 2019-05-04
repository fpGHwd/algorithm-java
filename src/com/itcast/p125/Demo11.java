/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/4/19
 * @Time:       5:35 PM
 * @Project:    algorithm
 */

package com.itcast.p125;

class Fu1{
    int num = 4;
    void show(){
        System.out.println("showFu");
    }
}

class Zi extends  Fu1{
    int num = 5;
    void show(){
        System.out.println("showZi");
    }
}

public class Demo11 {
    public static void main(String[] args){
        Fu1 f = new Zi();
        Zi z = new Zi();
        System.out.println(f.num);
        System.out.println(z.num);
        f.show();
        z.show();
    }
}

/*
4
5
showFu // 还是覆盖了，但是 对象区的成员变量并没有覆盖。方法区是覆盖的。所以是showZi
showZi
 */

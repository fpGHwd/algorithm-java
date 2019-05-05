/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/4/19
 * @Time:       4:56 PM
 * @Project:    algorithm
 */

package com.itcast.object.p125;


class Fu{
    boolean show(char a){
        System.out.println(a);
        return true;
    }
}

public class Demo4 extends Fu{
    public static void main(String[] args){
        int i =0;
        Fu f = new Demo4();
        Demo4 d = new Demo4();
        for(f.show('A'); f.show('B' )&&(i<2); f.show('C')){
            i++;
            d.show('D');
        }
    }

    boolean show(char a){
        System.out.println(a);
        return false;
    }
}

/*
A
B

子类覆写了父类方法
 */
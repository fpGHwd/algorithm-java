/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/4/19
 * @Time:       4:38 PM
 * @Project:    algorithm
 */

package com.itcast.p125;

class Super{
    int i = 0;
    public Super(String a){
        System.out.println("A");
        i = 1;
    }

    public Super(){
        System.out.println("B");
        i+=2;
    }
}

public class Demo6 extends Super {
    public Demo6(String a){
        System.out.println("C");
        i =5;
    }
    public static void main(String[] args){
        int i = 4;
        Super s = new Demo6("A");
        System.out.println(s.i);
    }
}

/*
B
C
5
 */

/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/4/19
 * @Time:       5:46 PM
 * @Project:    algorithm
 */

package com.itcast.p125;

public class Demo13 {
    public static void main(String[] args){

        try{
            showExe();
            System.out.println("A");
        }catch (Exception ex){
            System.out.println("B");
        }finally {
            System.out.println("C");
        }
        System.out.println("D");
    }

    public static void showExe() throws Exception{
        throw new Exception();
    }
}

/*
B
C
D   // OK!
 */
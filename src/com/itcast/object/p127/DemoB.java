/*
 * @Author: Suzumiya Haruhi 
 * @Date: 2019-05-04 20:44:13 
 * @Last Modified by: Suzumiya Haruhi
 * @Last Modified time: 2019-05-04 21:00:54
 */
package demo;

public class DemoB extends packa.DemoA{
    public void show(){ 
        System.out.println("DemoB show() runs");
        method();
    }

    public static void main(String[] args){
        new DemoB().show();
    }
}
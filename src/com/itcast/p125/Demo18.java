/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/4/19
 * @Time:       6:17 PM
 * @Project:    algorithm
 */

package com.itcast.p125;

class Exc0 extends Exception{}
class Exc1 extends Exc0{}

public class Demo18 {
    public static void main(String[] args){
        try{
            throw new Exc1();
        }catch (Exception e){
            System.out.println("Exception");
        }/*catch(Exc0 e){
            System.out.println("Exc0");
        }*/
    }
}

/*
编译失败：Exc0 已经

多个catch，父类catch要在下面。
 */
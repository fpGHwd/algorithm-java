/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/4/19
 * @Time:       5:21 PM
 * @Project:    algorithm
 */

package com.itcast.p125;

class TD{
    int y = 6;
    class Inner{
        int y = 3; // 没有提示不知道
        void show(){
            System.out.println(y);
        }
    }
}

public class Demo8 {
    public static void main(String[] args){
        TD.Inner ti = new TD().new Inner(); // 还以为这句有问题
        ti.show();
    }
}

/*
静态变量是共享的。内部类不是共享的。
编译失败：非晶态内部类中不可以定义静态成员。
内部类中如果定义了静态成员，该内部类必须被静态修饰。

最后改掉了y的static，去掉了
 */
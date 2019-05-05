/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 5/3/19
 * @Time: 9:39 PM
 */

package com.itcast.object.p119;


// 毕老师用电脑上课
// 名词提炼法

/*
比如问题是：
    蓝屏问题
    冒烟问题

先要描述问题：
 */

// 将不完美的东西映射到逻辑世界和确定性世界，这就是人啊。 而且中间势必要处理不完美的问题。
//

// 蓝屏了电脑可以处理
class LanPingException extends Exception{
    public LanPingException(String message){
        super(message);
    }
}

class MaoYanException extends Exception{
    public MaoYanException(String message){
        super(message);
    }
}


public class ExceptionExercise {
    public static void main(String[] args) {
        Computer c = new Computer();
        Teacher t = new Teacher("Mr. Bi", c);
        try {
            t.prelect();
        } catch (NoPlanException e) { // 你为什么要把冒烟抛给张老师。那么冒烟异常应该怎么办
//            System.out.println("在主函数/顶层抛出冒烟异常");
            System.out.println("换老师或者放假");// 这个地方是能够处理的。所以catch的内容本身对应的就是能处理的，属于本个类里面的东西，离它近的东西
            e.printStackTrace();
        }finally {

        }
        System.out.println();
    }
}


class Teacher{
    private String name;
    private Computer computer;

    public Teacher(String name, Computer computer){
        this.name = name;
        this.computer = computer;
    }

    public void prelect() throws NoPlanException{
        computer.state = 3;
        try {
            computer.run();
        } catch (LanPingException e) {
            computer.reboot();
            e.printStackTrace();
        } catch (MaoYanException e){
            test();
            throw new NoPlanException("课时无法继续" + e.toString()); //  throw是和return，一样程序的最后。就相当于cpu的检测标志位吧。会经常检查的
            // 为什么不能上课，给点理由，理由还是自己的东西。
        }
        System.out.println("开始讲课"); // 只是重启后面就可以讲课了
    }

    public void test(){
        System.out.println("做练习");
    }
}

class Computer{

    // 你太搞笑了啊。电脑有上课方法，那不把电脑放这儿就完了吗，你叫我干吗。对吧大家。

    public int state =1;

    public void run() throws LanPingException, MaoYanException {
        if(state == 2)throw new LanPingException("蓝屏异常");
        if(state == 3)throw new MaoYanException("冒烟异常");
        System.out.println("电脑运行");
    }

    public void reboot(){
        System.out.println("电脑重启");
        this.state = 1;
//        this.run();
    }

}

class NoPlanException extends Exception{
    public NoPlanException(String message){
        super(message);
    }
}
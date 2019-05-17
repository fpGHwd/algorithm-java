package com.itcast.gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 窗体事件
 */

public class p282 {
    /**
     * abstract不能实例化，提供一些方法。
     * 可以用于继承。并实现了一部分的接口。
     * 相对于直接实现接口省代码
     */

    public static void main(String[] args){
        Frame f = new Frame("my awt");
        f.setSize(500, 300);
        f.setLocation(800, 400);
        f.setLayout(new FlowLayout());

        Button b = new Button("按钮");
        f.add(b);

        f.addWindowListener(new MyWin()); // 匿名内部类

        f.setVisible(true);
    }
}

class MyWin extends WindowAdapter{ // 实现了窗口事件，所以是事件 // 窗口的动作
    public void windowClosing(WindowEvent e){ // 最常见的动作
//        System.out.println("window closing" );
        System.out.println("window closing" + e.toString());
        /**
         * window closingjava.awt.event.WindowEvent[WINDOW_CLOSING,opposite=null,oldState=0,newState=0] on frame0
         */
//        super.windowClosed(e);

    }

    public void windowActivated(WindowEvent e){
        System.out.println("windows Activated");
    }


    public void windowDeactivated(WindowEvent e){
        System.out.println("windows deactivated");
    }

    /**
     * windows Activated
     * windows deactivated
     * windows Activated
     * windows deactivated
     * windows Activated
     * windows deactivated
     * windows Activated
     * windows deactivated
     */
}

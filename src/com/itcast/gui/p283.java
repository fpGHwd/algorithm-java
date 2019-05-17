package com.itcast.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * action 事件
 */
public class p283 {
    public static void main(String[] args){
        FrameDemo fd = new FrameDemo();

    }
}


class FrameDemo{
    private Frame f;
    private Button but;

    FrameDemo(){
        init();
    }

    public void init(){
        f = new Frame("my frame");

        f.setBounds(500,309,500,309);
        f.setLayout(new FlowLayout());

        but = new Button("my button");
        f.add(but);

        this.myEvent();

        f.setVisible(true);
    }

    private void myEvent(){
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("window opened");
            }

            @Override
            public void windowClosed(WindowEvent e){
                System.exit(0);
            }
        });

        // 按钮具备退出程序功能
        /**
         * 添加监听方法，必须知道组件支持哪些监听事件方法。只有组件自己知道
         * button不是窗体，所以只有动作监听
         * 要是大家都有添加监听方法就好了。
         */
        // 适配器和接口提供的便利不一样
        but.addActionListener(e -> {
            System.out.println("action listener activated");
            System.exit(0);
        });
    }
}

package com.itcast.gui;

import org.junit.Test;

import java.awt.*;

public class p280 {
    // 流式布局
    // 边界布局
    // 网格布局
    // 坐标式布局
    @Test
    public void test() throws InterruptedException {
//        Container container = new Container();

        Frame f = new Frame("my awt");
        f.setSize(500,300);
        f.setLocation(800,400);
        f.setLayout(new FlowLayout());

        Button b = new Button("我是一个按钮");
        f.add(b);
        f.setVisible(true);

        System.out.println("hello world");
        // 显示线程。。显示管理线程。。。主界面
    }

    /**
     * 创建图形界面流程
     */
    public static void main(String[] args){
        Frame f = new Frame("my awt");
        f.setSize(500,300);
        f.setLocation(800,400);
        f.setLayout(new FlowLayout());

        Button b = new Button("这是一个按钮");
        f.add(b);
        f.setVisible(true);

        System.out.println("hello world");
        // 主线程可以是一个监听事件
    }
}

package com.itcast.gui;

import java.awt.*;

public class p281 {
    public static void main(String[] args) {
        Frame f = new Frame("my awt");
        f.setSize(500, 300);
        f.setLocation(800, 400);
        f.setLayout(new FlowLayout());

        Button b = new Button("按钮");
        f.add(b);
        f.setVisible(true);

        System.out.println("hello world");
    }

    // 事件监听机制
}

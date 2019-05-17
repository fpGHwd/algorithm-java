package com.itcast.gui;

import org.junit.Test;

import java.awt.*;
import java.awt.event.*;

/**
 * mouse and key event demo
 * 鼠标事件
 */
public class p284 {
    public static void main(String[] args) {
        new MouseAndKeyEvent();
    }

}

class MouseAndKeyEvent {
    private Frame f;
    private Button but;
    private TextField tf;
    private int clickCount = 0, typeCount = 0, doubleClickCount = 0;

    MouseAndKeyEvent() {
        this.init();

    }

    private void init() {
        f = new Frame("my frame");
        f.setBounds(500, 309, 1000, 618);
        f.setLayout(new FlowLayout());
        but = new Button("my button");
        f.add(but);

        tf = new TextField(80);
        f.add(tf);

        this.myEvent();

        f.setVisible(true);
    }

    private void myEvent() {
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                System.exit(0);
            }
        });


        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("鼠标的活动监听器监听到事件");
                // 先监听到点击事件再有活动监听器监听到事件
            }
        });

        but.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
                if(e.getClickCount() == 2)
                    System.out.println("鼠标在该组件单击第" + ++clickCount +"次");
                else
                    System.out.println("鼠标在该组件双击第" + ++doubleClickCount +"次");

            }

            @Override
            public void mouseEntered(MouseEvent e){
                System.out.println("鼠标进入到该组件");
            }

            @Override
            public void mouseExited(MouseEvent e){
                System.out.println("鼠标出来该组件"); // button也不算frame的区域
            }
        });

        // button添加key事件
        but.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyChar() + "...." + e.getKeyCode() + "..." + KeyEvent.getKeyText(e.getKeyCode()));
//                System.out.println("key was typed " + ++typeCount +" times");
                // 字母都认识，就是拼一块不认识。
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                    System.exit(0);
                }

                // 组合键
                if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_ENTER){
                    System.out.println("CTRL被按下且ENTER也被按下");
                }
            }
        });

        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
//                super.keyPressed(e);
                int code = e.getKeyCode();
                if(!(code >= KeyEvent.VK_0  && code <= KeyEvent.VK_9)){
                    System.out.println(code + ".....值非法");
                    e.consume();
                }
            }
        });
    }
}


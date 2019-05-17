/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/17/19
 * @Time:       6:54 PM
 * @Project:    algorithm
 */

package com.itcast.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class p286 {
    /**
     * 列出指定目录内容
     */

    public static void main(String[] args) {
        new MyWindow();
    }
}

class MyWindow extends Frame {
    private TextArea ta;
    private Button b;
    private TextField tf;
    // 当出错误了不要让它存在 // 对话框
    private Dialog d;
    private Label l;
    private Button okButton;
//    private

    MyWindow() {
        init();
    }

    private void init() {
        this.setBounds(500, 309, 1000, 618);
        this.setLayout(new FlowLayout());

        tf = new TextField("", 85);
        b = new Button("转到");
        ta = new TextArea(30, 90);

        d = new Dialog(this, "提示-self", true);
        l = new Label();
        okButton = new Button("确定");

        this.add(tf);
        this.add(b);
        this.add(ta);

        this.addEvent();

        this.setVisible(true);

        // 应另外处理，不要先写好。
        d.add(l);
        d.add(okButton);
        d.setBounds(400, 200, 200, 60);

    }

    private void addEvent() {

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
//                super.windowClosing(e);
                System.exit(0);
            }
        });


        d.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // 不能结束程序
                d.setVisible(false);
            }
        });

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.setVisible(false);
            }
        });


        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 计算并打印路径的目录
                String text = tf.getText();
                File dir = new File(text);
                if (dir.exists() && dir.isDirectory()) {
                    String[] names = dir.list();
                    ta.setText("");
                    for (String name : names) {
                        ta.append(name + "\n");  // 换行符号不一样
                    }
                } else {
                    String info = "您输入的路径" + text + "是错误的，请重新输入";
                    l.setText(info);
                    d.setVisible(true);
                }
            }
        });

    }

    // 图形界面只是与用户的互动的一种方式
}



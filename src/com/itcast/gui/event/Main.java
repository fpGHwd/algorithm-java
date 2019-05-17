package com.itcast.gui.event;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        MySource s = new MySource();
        MyListener l = new MyListener();
        s.addListener(l);
        s.setValue(100);
    }
    // 事件本身只是一个传递..消息或者事件源在对象间的传递。

    /**
     * 业务中
     * 事件源，事件和监听器，不用写。
     * 我们要做的事是对产生的动作进行处理
     */
}
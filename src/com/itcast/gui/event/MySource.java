package com.itcast.gui.event;

import java.util.Vector;

public class MySource {
    private int value;
    private Vector<Listener> listeners = new Vector<Listener>();
    /**
     * 添加监听器
     * @param listener
     */
    public void addListener(Listener listener){
        listeners.add(listener); // 事件的个数通过Vector集合来实现
    }

    public void setValue(int value){
        this.value = value;
        //发送消息
        MyEvent e = new MyEvent();
        e.setValue(value);
        for(int i = 0; i < listeners.size(); i++){
            listeners.get(i).eventChanged(e);
        }
        // 触发位置就在这里
    }

}

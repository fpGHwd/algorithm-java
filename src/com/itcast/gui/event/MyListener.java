package com.itcast.gui.event;

public class MyListener implements Listener{

    @Override
    public void eventChanged(MyEvent e) {
        // listener中包含事件触发后的执行过程
        System.out.println("value changed to:" + e.getValue());
    }

}

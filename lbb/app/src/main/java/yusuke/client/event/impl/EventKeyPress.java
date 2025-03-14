package yusuke.client.event.impl;

import yusuke.client.event.CancellableEvent;

public class EventKeyPress extends CancellableEvent {
    public int keyCode;
    public boolean pressed;

    public EventKeyPress(int keyCode, boolean pressed) {
        this.keyCode = keyCode;
        this.pressed = pressed;
    }
}

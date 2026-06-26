package com.fabricio.fishing.event.input;

public interface Holdable extends Clickable{
    void onHoldStart();
    void onHold();
    void onRelease();
}

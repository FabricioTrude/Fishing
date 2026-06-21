package com.fabricio.fishing.entity.input.interfaces;

public interface Holdable extends Clickable{
    void onHoldStart();
    void onHold();
    void onRelease();
}

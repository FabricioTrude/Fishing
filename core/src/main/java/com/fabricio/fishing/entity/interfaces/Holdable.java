package com.fabricio.fishing.entity.interfaces;

public interface Holdable extends Clickable{
    void onHoldStart();
    void onHold();
    void onRelease();
}

package com.fabricio.fishing.entity.interfaces;

public interface Holdable extends Clickable{
    boolean isFirstHold();
    boolean isHolding();
    void setFirstHold(boolean firstHold);
    void setHolding(boolean holding);
    void onHold();
    void onRelease();
}

package com.fabricio.fishing.screen;

public enum RenderLayer {
    SKY(0),
    BACKGROUND(100),
    BACKGROUND_OBJ(200),
    ENTITY(300),
    FOREGROUND_OBJ(400),
    FOREGROUND(500),
    OVERLAY(600);

    public final int z;

    RenderLayer(int z) {
        this.z = z;
    }
}

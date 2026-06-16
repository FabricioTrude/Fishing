package com.fabricio.fishing.screen;

public enum RenderLayer {
    SKY(0),
    SKY_OBJ(50),
    BACKGROUND(100),
    BACKGROUND_OBJ(150),
    ENTITY(200),
    PLAYER(250),
    FOREGROUND_OBJ(300),
    FOREGROUND(350),
    OVERLAY(400);

    public final int z;

    RenderLayer(int z) {
        this.z = z;
    }
}

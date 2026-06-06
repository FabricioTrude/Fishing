package com.fabricio.fishing.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Entity {
    protected float x;
    protected float y;
    protected double hp;
    protected double armor;

    public Entity(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public abstract void update(float delta);

//    public abstract void render();
}

package com.fabricio.fishing.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fabricio.fishing.event.EventBus;

public abstract class Entity {

    protected EventBus eventBus;

    protected float x;
    protected float y;
    protected float width;
    protected float height;
    protected double hp;
    protected double armor;


    public Entity(float x, float y, EventBus eventBus) {
        this.eventBus = eventBus;
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

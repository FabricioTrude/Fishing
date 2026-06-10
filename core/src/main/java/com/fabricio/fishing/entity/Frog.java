package com.fabricio.fishing.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fabricio.fishing.event.EventBus;

public abstract class Frog extends Entity{

    public Frog(float x, float y) {
        super(x, y);
    }

    @Override
    public void update(float delta) {
    }

    public void render(SpriteBatch sprite) {

    }
}

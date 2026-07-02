package com.fabricio.fishing.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.fabricio.fishing.context.statics.C;

public abstract class LayeredScene implements Scene {
    float width;
    float height;

    public LayeredScene(float width, float height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void dispose() {
        C.entities().clearScene();
        C.CE().target(null);
    }

    @Override
    public void update(float delta) {}
    @Override
    public void render(SpriteBatch batch){
        C.entities().render(batch);
    }
    public float getWidth() {
        return width;
    }
    public float getHeight() {
        return height;
    }
}

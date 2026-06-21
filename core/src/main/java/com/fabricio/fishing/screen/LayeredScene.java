package com.fabricio.fishing.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fabricio.fishing.context.statics.C;

public abstract class LayeredScene implements Scene {

    @Override
    public void render(SpriteBatch batch){
        C.entities().render(batch);
    }

    @Override
    public void update(float delta) {}

    @Override
    public void dispose() {
        C.entities().clearScene();
    }
}

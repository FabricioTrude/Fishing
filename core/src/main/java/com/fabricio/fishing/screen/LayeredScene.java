package com.fabricio.fishing.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.fabricio.fishing.features.GameContext.entityManager;

public abstract class LayeredScene implements Scene {

    @Override
    public void render(SpriteBatch batch){
        entityManager.render(batch);
    }

    @Override
    public void update(float delta) {}

    @Override
    public void dispose() {
        entityManager.clearScene();
    }
}

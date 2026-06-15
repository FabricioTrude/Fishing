package com.fabricio.fishing.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.fabricio.fishing.features.GameContext.entityManager;

public abstract class LayeredScene implements Scene {
    protected void renderLayer(RenderLayer layer, SpriteBatch batch){}

    @Override
    public void render(SpriteBatch batch){
        for(RenderLayer layer : RenderLayer.values()) renderLayer(layer, batch);
    }

    @Override
    public void update(float delta) {}

    @Override
    public void dispose() {
        entityManager.clearScene();
    }
}

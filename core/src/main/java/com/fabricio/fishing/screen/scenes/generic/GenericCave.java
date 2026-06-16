package com.fabricio.fishing.screen.scenes.generic;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.fabricio.fishing.screen.LayeredScene;
import com.fabricio.fishing.screen.RenderLayer;

import static com.fabricio.fishing.features.GameContext.*;

public class GenericCave extends LayeredScene {
    protected SpriteBatch batch;

    public GenericCave() {
        float floor_height = SCREEN_HEIGHT * 0.3f;
        player.setY(floor_height);
        player.setX(SCREEN_WIDTH * 0.7f);
        player.setScale(0.7f);
    }

    @Override
    protected void renderLayer(RenderLayer layer, SpriteBatch batch) {
        switch (layer){
            case SKY -> {
                ScreenUtils.clear(Color.DARK_GRAY);
                entityManager.render(layer,batch);
            }
            default -> entityManager.render(layer,batch);
        }
    }

    @Override
    public void update(float delta) {
        super.update(delta);
    }
}

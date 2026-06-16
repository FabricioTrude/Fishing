package com.fabricio.fishing.screen.scenes.generic;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.fabricio.fishing.entity.ColorRectEntity;
import com.fabricio.fishing.screen.LayeredScene;
import com.fabricio.fishing.screen.RenderLayer;

import static com.fabricio.fishing.features.GameContext.*;

public class GenericCave extends LayeredScene {
    protected SpriteBatch batch;

    public GenericCave() {
        float floor_height = SCREEN_HEIGHT * 0.15f;
        player.setScene(SCREEN_WIDTH * 0.7f, floor_height, 10, 0.7f);
        new ColorRectEntity(0,0, SCREEN_WIDTH, SCREEN_HEIGHT, Color.valueOf("1f1919"), -10000);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
    }
}

package com.fabricio.fishing.screen.scenes.generic;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fabricio.fishing.entity.ColorRectEntity;
import com.fabricio.fishing.screen.LayeredScene;
import com.fabricio.fishing.features.fishing.FishingFeature;

import static com.fabricio.fishing.features.GameContext.*;

public class GenericPond extends LayeredScene {

    protected static FishingFeature fishing = new FishingFeature();
    protected SpriteBatch batch;
    public static float SEA_HEIGHT = SCREEN_HEIGHT * 0.5f;

    public GenericPond() {
        float sea_height = zone.getSea_height();
        setSeaHeight(sea_height);
        player.setScene(SCREEN_WIDTH/2, sea_height, 10, 1);
        ColorRectEntity sky = new ColorRectEntity(0,0, SCREEN_WIDTH, SCREEN_HEIGHT, timeManager.getSkyColor(), -10000);
        sky.setUpdate(() -> sky.setColor(timeManager.getSkyColor()));
        new ColorRectEntity(0,0, SCREEN_WIDTH, SEA_HEIGHT, zone.getColor(), -20);
    }

    public static void setSeaHeight(float seaHeight) {
        SEA_HEIGHT = seaHeight;
    }

    @Override
    public void update(float delta) {
        fishing.update(delta);
    }
}

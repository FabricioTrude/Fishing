package com.fabricio.fishing.screen.scenes.generic;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.fabricio.fishing.entity.ColorRectEntity;
import com.fabricio.fishing.screen.LayeredScene;
import com.fabricio.fishing.screen.RenderLayer;
import com.fabricio.fishing.assets.statics.UIAssets;
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
        new ColorRectEntity(0,0, SCREEN_WIDTH, SEA_HEIGHT, zone.getColor(), 0);
        new ColorRectEntity(0,0, SCREEN_WIDTH, SCREEN_HEIGHT, timeManager.getSkyColor(), -10000);
    }

    public static void setSeaHeight(float seaHeight) {
        SEA_HEIGHT = seaHeight;
    }

    @Override
    public void update(float delta) {
        fishing.update(delta);
    }
}

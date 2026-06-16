package com.fabricio.fishing.screen.scenes.generic;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
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
        player.setX(SCREEN_WIDTH/2);
        player.setY(sea_height);
        player.setScale(1);
    }

    public static void setSeaHeight(float seaHeight) {
        SEA_HEIGHT = seaHeight;
    }

    @Override
    protected void renderLayer(RenderLayer layer, SpriteBatch batch) {
        switch (layer) {
            case SKY -> {
                ScreenUtils.clear(timeManager.getSkyColor());
                entityManager.render(layer,batch);
            }
            case BACKGROUND -> {
                entityManager.render(layer,batch);
                batch.setColor(zone.getColor());
                batch.draw(UIAssets.WHITE, 0, 0, SCREEN_WIDTH, SEA_HEIGHT);
                batch.setColor(Color.WHITE);
            }
            default -> entityManager.render(layer, batch);
        }
    }

    @Override
    public void update(float delta) {
        fishing.update(delta);
    }
}

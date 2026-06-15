package com.fabricio.fishing.screen.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.fabricio.fishing.screen.LayeredScene;
import com.fabricio.fishing.screen.RenderLayer;
import com.fabricio.fishing.assets.statics.UIAssets;
import com.fabricio.fishing.features.fishing.FishingFeature;

import static com.fabricio.fishing.features.GameContext.*;

public class DefaultPond extends LayeredScene {

    protected static FishingFeature fishing = new FishingFeature();
    protected SpriteBatch batch;
    public static float SEA_HEIGHT = SCREEN_HEIGHT * 0.5f;

    public DefaultPond() {
        float sea_height = zone.getSea_height();
        setSeaHeight(sea_height);
        player.setY(sea_height);
    }

    public static void setSeaHeight(float seaHeight) {
        SEA_HEIGHT = seaHeight;
    }

    @Override
    protected void renderLayer(RenderLayer layer, SpriteBatch batch) {
        switch (layer) {
            case SKY -> ScreenUtils.clear(timeManager.getSkyColor());
            case BACKGROUND, BACKGROUND_OBJ, ENTITY, FOREGROUND_OBJ, OVERLAY -> entityManager.render(layer, batch);
            case FOREGROUND -> {
                batch.setColor(zone.getColor());
                batch.draw(UIAssets.WHITE, 0, 0, SCREEN_WIDTH, SEA_HEIGHT);
                batch.setColor(Color.WHITE);
                entityManager.render(layer,batch);
            }
        }
    }

    @Override
    public void update(float delta) {
        fishing.update(delta);
        entityManager.flushRemovals();
    }
}

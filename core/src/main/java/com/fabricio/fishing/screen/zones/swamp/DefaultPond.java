package com.fabricio.fishing.screen.zones.swamp;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.fabricio.fishing.assets.statics.UIAssets;
import com.fabricio.fishing.features.GameContext;
import com.fabricio.fishing.features.fishing.FishingFeature;
import com.fabricio.fishing.screen.zones.FishingZone;

import static com.fabricio.fishing.features.GameContext.*;

public class DefaultPond implements FishingZone {
    FishingFeature feature;
    private SpriteBatch batch;

    public DefaultPond(FishingFeature feature) {
        this.feature = feature;
        GameContext.setSeaHeight(SCREEN_HEIGHT * 0.7f);
        player.setY(SCREEN_HEIGHT * 0.7f);
    }

    @Override
    public void update(float delta) {
        timeManager.update(delta);
        player.update(delta);
        feature.update(delta);
        clickManager.update();
        entityManager.flushRemovals();
    }

    @Override
    public void render(SpriteBatch batch) {
        this.batch = batch;
        ScreenUtils.clear(timeManager.getSkyColor());
        feature.render(batch);
        batch.setColor(feature.getZone().getColor());
        batch.draw(UIAssets.WHITE, 0, 0, SCREEN_WIDTH, SEA_HEIGHT);
        player.render(batch);
    }

    @Override
    public void dispose() {
        feature.dispose();
    }
}

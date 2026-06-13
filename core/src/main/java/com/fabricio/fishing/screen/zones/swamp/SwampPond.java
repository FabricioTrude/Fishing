package com.fabricio.fishing.screen.zones.swamp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.fabricio.fishing.assets.statics.UIAssets;
import com.fabricio.fishing.features.fishing.FishingFeature;
import com.fabricio.fishing.screen.zones.FishingZone;

import static com.fabricio.fishing.features.GameContext.*;
import static com.fabricio.fishing.features.GameContext.player;

public class SwampPond implements FishingZone {
    private FishingFeature feature;
    private SpriteBatch batch;

    public SwampPond(FishingFeature feature) {
        this.feature = feature;
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
        //SKY
        ScreenUtils.clear(timeManager.getSkyColor());
        //BACKGROUND

        //FISHES
        feature.render(batch);

        //SEA
        batch.setColor(feature.getZone().getColor());
        batch.draw(UIAssets.WHITE,0,0,SCREEN_WIDTH, SEA_HEIGHT);
        //PLAYER
        player.render(batch);

//        entityManager().renderBoxes(shapeRenderer);

    }

    @Override
    public void dispose() {
        batch.dispose();
        feature.dispose();
    }
}

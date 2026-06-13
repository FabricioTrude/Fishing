package com.fabricio.fishing.screen.ui.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.fabricio.fishing.features.fishing.FishingFeature;
import com.fabricio.fishing.screen.FeatureScreen;

import static com.fabricio.fishing.features.GameContext.*;

public class FishingScreen implements FeatureScreen {

    private final FishingFeature feature = new FishingFeature();
    private final SpriteBatch batch = new SpriteBatch();
    private final ShapeRenderer renderer = new ShapeRenderer();



    public FishingScreen() {
        getContext().setFeature(this);
    }

    public void render(){
        update(Gdx.graphics.getDeltaTime());
        ScreenUtils.clear(timeManager.getSkyColor());
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(feature.getZone().getColor());
        renderer.rect(
            0,
            0,
            SCREEN_WIDTH,
            SEA_HEIGHT
        );
        renderer.end();

//        entityManager().renderBoxes(shapeRenderer);
        batch.begin();
        feature.render(batch);
        player.render(batch);
        batch.end();

    }

    public void update(float delta){
        timeManager.update(delta);
        player.update(delta);
        feature.update(delta);
        clickManager.update();
        entityManager.flushRemovals();
    }

    @Override
    public void dispose() {
        batch.dispose();
        feature.dispose();
    }
}

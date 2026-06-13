package com.fabricio.fishing.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.fabricio.fishing.features.fishing.FishingFeature;
import com.fabricio.fishing.features.fishing.records.FishingZoneSwitchEvent;
import com.fabricio.fishing.screen.zones.FishingZone;
import com.fabricio.fishing.screen.zones.swamp.SwampPond;
import com.fabricio.fishing.features.fishing.enums.FishingZones;

import static com.fabricio.fishing.features.GameContext.*;

public class FishingScreen implements FeatureScreen {
    private final FishingFeature feature = new FishingFeature();
    private FishingZone zone;
    private SpriteBatch batch = new SpriteBatch();

    public FishingScreen() {
        zone = new SwampPond(feature);
        eventBus.register(FishingZoneSwitchEvent.class, e -> setFishingScreen(e.zone()));
    }

    public void setFishingScreen(FishingZones zoneType) {
        switch (zoneType) {
            case FishingZones.SWAMP -> {
                zone.dispose();
                zone = new SwampPond(feature);
            }
            default -> {}
        }
    }

    @Override
    public void update(float delta) {
        zone.update(delta);
    }

    @Override
    public void render() {
        batch.begin();
        zone.render(batch);
        batch.end();
    }

    @Override
    public void dispose() {

    }
}

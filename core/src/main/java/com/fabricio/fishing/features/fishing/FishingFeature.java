package com.fabricio.fishing.features.fishing;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fabricio.fishing.event.Subscription;
import com.fabricio.fishing.features.fishing.enums.FishingZones;
import com.fabricio.fishing.features.fishing.records.FishingZoneSwitchEvent;

import static com.fabricio.fishing.features.GameContext.*;

public class FishingFeature {
    private final FishManager manager;

    private FishingZones zone;
    private final Subscription zoneSub;

    public FishingFeature() {
        zone = FishingZones.SWAMP;
        manager = new FishManager(this);
        zoneSub = eventBus.register(FishingZoneSwitchEvent.class, e -> setZone(e.zone()));
    }

    public FishingZones getZone() {
        return zone;
    }

    public void setZone(FishingZones zone) {
        this.zone = zone;
    }

    public void update(float delta){manager.update(delta);}

    public void render(SpriteBatch batch){
        manager.render(batch);
    }

    public void dispose(){}
}

package com.fabricio.fishing.features.fishing;

import com.badlogic.gdx.math.MathUtils;
import com.fabricio.fishing.event.Subscription;
import com.fabricio.fishing.features.fishing.enums.FishSpecies;
import com.fabricio.fishing.features.zones.Zones;
import com.fabricio.fishing.features.fishing.records.FishingZoneSwitchEvent;
import com.fabricio.fishing.features.player.stats.FishingStats;

import static com.badlogic.gdx.math.MathUtils.random;
import static com.fabricio.fishing.features.GameContext.*;
import static com.fabricio.fishing.screen.scenes.DefaultPond.SEA_HEIGHT;

public class FishingFeature {
    final FishingStats fishing = new FishingStats();
    float spawnTimer = 0;
    Subscription zoneSub;

    public FishingFeature() {
        zone = Zones.SWAMP;
        eventBus.register(FishingZoneSwitchEvent.class, e -> {
            fishing.setCurrentFishes(0);
            setZone(e.zone());
        });
    }

    public void createFish(){
        FishSpecies species = FishSpecies.random(zone);
        if(species == null) return;
        float direction = MathUtils.random(1f);
        float rX = MathUtils.random(50f);
        rX = direction >= 0.5f ? rX - 50 : rX + SCREEN_WIDTH;
        entityManager.register(new Fish(
            rX,
            random.nextFloat() * SEA_HEIGHT,
            species
        ));
        fishing.setCurrentFishes(fishing.getCurrentFishes() + 1);
    }

    public void update(float delta){
        spawnTimer += delta;
        if(spawnTimer > fishing.getFishingRespawnTime() &&
            fishing.getCurrentFishes() < fishing.getMaxFishes()){
            spawnTimer = 0;
            createFish();
        }
    }
}

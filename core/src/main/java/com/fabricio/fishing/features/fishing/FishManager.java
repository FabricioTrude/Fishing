package com.fabricio.fishing.features.fishing;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.fabricio.fishing.entity.Entity;
import com.fabricio.fishing.entity.enums.EntityIndex;
import com.fabricio.fishing.features.fishing.enums.FishSpecies;
import com.fabricio.fishing.features.fishing.enums.FishingZones;
import com.fabricio.fishing.features.player.stats.FishingStats;
import com.fabricio.fishing.manager.TimeManager;

import static com.badlogic.gdx.math.MathUtils.random;
import static com.fabricio.fishing.features.GameContext.*;

public class FishManager extends TimeManager {
    private FishingFeature feature;
    private final FishingStats fishing = new FishingStats();
    private float spawnTimer = 0;

    public FishManager(FishingFeature feature) {
        this.feature = feature;
    }

    public void createFish(){
        FishingZones zone = feature.getZone();
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
    }

    public void update(float delta){
        spawnTimer += delta;
        if(spawnTimer > fishing.getFishingRespawnTime()
            && fishing.getCurrentFishes() < fishing.getMaxFishes()){
            spawnTimer = 0;
            createFish();
        }
        for(Entity entity : entityManager.get(EntityIndex.FISH)){
           entity.update(delta);
        }
    }

    public void render(SpriteBatch batch){
        for(Entity entity: entityManager.get(EntityIndex.FISH))
            entity.render(batch);
    }
}

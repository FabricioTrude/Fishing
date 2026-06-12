package com.fabricio.fishing.features.fishing;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.fabricio.fishing.features.fishing.enums.FishSpecies;
import com.fabricio.fishing.features.fishing.enums.FishingZones;
import com.fabricio.fishing.features.player.Player;
import com.fabricio.fishing.features.GameContext;
import com.fabricio.fishing.entity.EntityManager;
import com.fabricio.fishing.manager.TimeManager;

import static com.badlogic.gdx.math.MathUtils.random;
import static com.fabricio.fishing.features.GameContext.*;

public class FishManager extends TimeManager {
    private final TimeManager timeManager;
    private final EntityManager entityManager;
    private final Player player;
    private final FishingStatus fishing;
    private float spawnTimer = 0;

    public FishManager(GameContext context, FishingStatus fishing) {
        this.timeManager = context.getTimeManager();
        this.entityManager = context.getEntityManager();
        this.player = context.getPlayer();
        this.fishing = fishing;
    }

    public void update(float delta){
        spawnTimer += delta;
        if(spawnTimer > fishing.getFishingRespawnTime()
            && entityManager.getFishes().size < fishing.getMaxFishes()){
            spawnTimer = 0;
            createFish();
        }
        for(Fish fish : entityManager.getFishes()){
            fish.update(delta);
        }
    }

    public void render(SpriteBatch batch){
        for(Fish fish: entityManager.getFishes())
            fish.render(batch);
    }

    public void createFish(){
        assert GameContext.getContext().getFishingFeature() != null;
        FishingZones zone = GameContext.getContext().getFishingFeature().getZone();
        FishSpecies species = FishSpecies.random(zone);
        if(species == null) return;
        float direction = MathUtils.random(1f);
        float rX = MathUtils.random(50f);
        rX = direction >= 0.5f ? rX - 50 : rX + SCREEN_WIDTH;
        entityManager.addEntity(new Fish(
            rX,
            random.nextFloat() * SEA_HEIGHT,
            species
        ));
    }
}

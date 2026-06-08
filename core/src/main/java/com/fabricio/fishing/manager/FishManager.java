package com.fabricio.fishing.manager;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.fabricio.fishing.entity.fish.Fish;
import com.fabricio.fishing.event.Event;
import com.fabricio.fishing.event.EventBus;
import com.fabricio.fishing.event.FishDiedEvent;

import static com.badlogic.gdx.math.MathUtils.random;
import static com.fabricio.fishing.screen.GameScreen.SCREEN_WIDTH;
import static com.fabricio.fishing.screen.GameScreen.SEA_HEIGHT;

public class FishManager extends TimeManager {
    TimeManager timeManager;
    private final EventBus eventBus;
    private final EntityManager entityManager;


    private int maxFishes = 3;
    private float spawnTimer = 0;

    public FishManager(EventBus eventBus,TimeManager timeManager, EntityManager entityManager) {
        this.eventBus = eventBus;
        this.timeManager = timeManager;
        this.entityManager = entityManager;
    }


    public void createFish(){
        Fish fish = spawnFish();
        entityManager.addEntity(fish);
    }

    public void update(float delta){
        spawnTimer += delta;
        if(spawnTimer > 1 && entityManager.getFishes().size <= maxFishes){
            spawnTimer = 0;
            createFish();
        }
        for(Fish fish : entityManager.getFishes()){
            fish.update(delta);
        }
    }

    private Fish spawnFish(){
        float direction = MathUtils.random(1f);
        float rX = MathUtils.random(50f);
        rX = direction >= 0.5f ? rX - 50 : rX + SCREEN_WIDTH;
        return new Fish(
            rX,
            random.nextFloat() * SEA_HEIGHT,
            eventBus
        );
    }

    public void render(SpriteBatch batch){
        for(Fish fish: entityManager.getFishes())
            fish.render(batch);
    }
}

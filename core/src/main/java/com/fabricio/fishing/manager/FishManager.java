package com.fabricio.fishing.manager;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.fabricio.fishing.entity.fish.Fish;

import static com.fabricio.fishing.screen.GameScreen.SCREEN_WIDTH;

public class FishManager extends TimeManager {
    TimeManager timeManager;
    private final EntityManager entityManager;


    private int maxFishes = 3;
    private float spawnTimer = 0;

    public FishManager(TimeManager timeManager, EntityManager entityManager) {
        this.timeManager = timeManager;
        this.entityManager = entityManager;
    }


    public void createFish(){
        Fish fish = Fish.spawn();
        entityManager.addEntity(fish);
    }

    public void update(float delta){
        spawnTimer += delta;
        if(spawnTimer > 1 && entityManager.getFishes().size <= maxFishes){
            spawnTimer = 0;
            createFish();
        }
        for(Fish fish : entityManager.getFishes()){
            if(!fish.alive())
                entityManager.MarkForRemoval(fish);
            fish.update(delta);
        }
    }

    public void render(SpriteBatch batch){
        for(Fish fish: entityManager.getFishes())
            fish.render(batch);
    }
}

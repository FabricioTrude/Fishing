package com.fabricio.fishing.manager;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.fabricio.fishing.entity.fish.Fish;
import com.fabricio.fishing.entity.fish.FishSize;
import com.fabricio.fishing.entity.fish.FishSpecies;
import com.fabricio.fishing.entity.fish.FishRarity;

import static com.badlogic.gdx.math.MathUtils.random;
import static com.fabricio.fishing.screen.GameScreen.screenWidth;
import static com.fabricio.fishing.screen.GameScreen.seaHeight;

public class FishManager extends TimeManager {
    TimeManager timeManager;
    private final Array<Fish> fishes = new Array<>();

    private int maxFishes = 50;
    private float spawnTimer = 0;

    public FishManager(TimeManager timeManager) {
        this.timeManager = timeManager;
    }

    public Array<Fish> getFishes(){
        return fishes;
    }

    public void createFish(){
        Fish fish = Fish.spawn();
        fishes.add(fish);
    }

    public void update(float delta){
        spawnTimer += delta;
        if(spawnTimer > 1 && getFishes().size <= maxFishes){
            spawnTimer = 0;
            createFish();
            System.out.println("Peixes:"+ getFishes().size);
        }
        for(int i = 0; i < fishes.size; i++){
            Fish fish = fishes.get(i);
            fish.update(delta);
            if(fish.getX() >= screenWidth + 50) fishes.removeIndex(i);
            System.out.println("Fish " + i + " - X : " + fish.getX() + " - Y : " + fish.getY());
        }
    }

    public void render(ShapeRenderer shapeRenderer){
        for(Fish fish:fishes) fish.render(shapeRenderer);
    }
}

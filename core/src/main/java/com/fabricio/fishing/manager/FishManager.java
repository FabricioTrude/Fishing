package com.fabricio.fishing.manager;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.fabricio.fishing.entity.fish.Fish;

import static com.fabricio.fishing.screen.GameScreen.SCREEN_WIDTH;

public class FishManager extends TimeManager {
    TimeManager timeManager;
    private final Array<Fish> fishes = new Array<>();

    private int maxFishes = 3;
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
//            System.out.println("Fish " + i + " - X : " + fish.getX() + " - Y : " + fish.getY());
        }
    }

    public void render(SpriteBatch batch){
        for(Fish fish:fishes) fish.render(batch);
    }
}

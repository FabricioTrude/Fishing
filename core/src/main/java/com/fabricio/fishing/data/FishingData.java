package com.fabricio.fishing.data;

import com.fabricio.fishing.context.statics.G;
import com.fabricio.fishing.features.fishing.records.FishCaughtEvent;

public class FishingData {
    private final int baseMaxFishes = 10;
    private int currentFishes = 0;
    private float fishingRespawnTime = 1;

    public FishingData() {
        G.ebus().register(FishCaughtEvent.class, e -> setCurrentFishes(currentFishes - 1));
    }

    public float getFishingRespawnTime(){
        return fishingRespawnTime;
    }

    public int getMaxFishes() {
        return baseMaxFishes;
    }

    public int getCurrentFishes() {
        return currentFishes;
    }

    public void setCurrentFishes(int n){
        currentFishes = n;
    }
}

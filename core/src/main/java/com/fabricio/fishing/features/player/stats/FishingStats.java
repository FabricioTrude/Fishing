package com.fabricio.fishing.features.player.stats;


import com.fabricio.fishing.features.fishing.records.FishingZoneSwitchEvent;

import static com.fabricio.fishing.features.GameContext.eventBus;

public class FishingStats {
    private final int baseMaxFishes = 10;
    private int currentFishes = 0;
    private float fishingRespawnTime = 1;

    public FishingStats() {
        eventBus.register(FishingZoneSwitchEvent.class, event -> currentFishes = 0);
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
        currentFishes += 1;
    }
}

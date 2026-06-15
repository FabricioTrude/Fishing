package com.fabricio.fishing.features.player.stats;

public class FishingStats {
    private final int baseMaxFishes = 10;
    private int currentFishes = 0;
    private float fishingRespawnTime = 1;

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

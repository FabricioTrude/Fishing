package com.fabricio.fishing.features.fishing;


public class FishingStatus {
    private final int baseMaxFishes = 10;
    private float fishingRespawnTime = 1;

    public int getMaxFishes(){
        return baseMaxFishes;
    }
    public float getFishingRespawnTime(){
        return fishingRespawnTime;
    }
}

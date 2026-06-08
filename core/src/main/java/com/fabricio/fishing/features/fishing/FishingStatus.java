package com.fabricio.fishing.features.fishing;


public class FishingStatus {
    private final int baseMaxFishes = 3;
    private float fishingRespawnTime = 30;

    public int getMaxFishes(){
        return baseMaxFishes;
    }
    public float getFishingRespawnTime(){
        return fishingRespawnTime;
    }
}

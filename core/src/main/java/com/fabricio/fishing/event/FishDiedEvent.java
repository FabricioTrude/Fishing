package com.fabricio.fishing.event;

import com.fabricio.fishing.entity.fish.Fish;

public class FishDiedEvent implements Event{
    public final Fish fish;
    public float fishValue;

    public FishDiedEvent(Fish fish, float fishValue){
        this.fish = fish;
        this.fishValue = fishValue;
    }
}

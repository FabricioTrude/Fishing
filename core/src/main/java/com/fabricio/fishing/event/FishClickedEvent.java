package com.fabricio.fishing.event;

import com.fabricio.fishing.features.fishing.Fish;

public class FishClickedEvent implements Event{
    public final Fish targetFish;
    public final int fishValue;

    public FishClickedEvent(Fish fish, int fishValue){
        this.targetFish = fish;
        this.fishValue = fishValue;
    }
}
